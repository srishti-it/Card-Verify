package com.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.card.entities.CardNumber;
import com.card.repository.CardRepo;

@Controller
public class CardController {

	@Autowired 
	private CardRepo cardRepo;
	
	    @GetMapping("/getForm")
	    public String getForm() {
	        return "card";
	    }
	    @PostMapping("/savecard")                     
	    public String saveDetails(@RequestParam("cardNumber") CardNumber cardNumber) {
	        // write your code to save details
	        cardRepo.save(cardNumber);
	        
	        return "CardForm";        
	    }
}
