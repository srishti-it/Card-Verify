package com.card.Service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.card.entities.CardDetails;
import com.card.entities.CardNumber;
import com.card.repository.CardRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CardService {

	@Autowired
	private CardRepo cardRepo;

	public Object savecrdNum(CardNumber num) {
		Boolean isExistedNum = cardRepo.existsByCardNumber(num.getCardNumber());
		Optional<CardNumber> cardNumObj= cardRepo.findByCardNumber(num.getCardNumber());
		
		if (isExistedNum) {
			int hits = cardNumObj.get().getHits();
			hits++;
			cardNumObj.get().setHits(hits);
			cardRepo.save(cardNumObj.get());
		} else {
			num.setHits(1);
			cardRepo.save(num);
		}

		String cardNum = num.getCardNumber();

		// calling third api
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("https://lookup.binlist.net/" + cardNum,
				String.class);
		if (null == response) {
			return "No Card Detail Found For This Number";
		} else {
			String body = response.getBody();

			// set values in card details
			CardDetails cardDetails = new CardDetails();
			try {
				Map<String, String> map = new ObjectMapper().readValue(body, Map.class);

				cardDetails.setScheme(map.get("scheme"));
				cardDetails.setType(map.get("type"));
				Object bankObj = map.get("bank");
				Map<String, String> bankDetails = new ObjectMapper().convertValue(bankObj, Map.class);
				cardDetails.setBank(bankDetails.get("name"));
			} catch (Exception e) {
				e.getStackTrace();
			}

			return cardDetails;
		}
	}

}
