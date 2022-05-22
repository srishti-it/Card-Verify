package com.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.Service.CardService;
import com.card.entities.CardNumber;
import com.card.repository.CardRepo;

@RestController
public class CardController {

	@Autowired
	private CardService cardService;
	@Autowired
	private CardRepo cardRepo;
	
	

	@GetMapping("/card-scheme/stats")
	public ResponseEntity<Object> getForm() {
		List<CardNumber> cardList = cardRepo.findAll();
		return new ResponseEntity<>(cardList, HttpStatus.OK);
	}

	@PostMapping("/card-scheme/verify/")
	public ResponseEntity<Object> saveDetails(@RequestBody CardNumber cardNumber) {
		if (null == cardNumber.getCardNumber()|| cardNumber.getCardNumber().isBlank() ) {
			return new ResponseEntity<>("Card Number is Empty", HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<>(cardService.savecrdNum(cardNumber), HttpStatus.OK);
	}
}
