package com.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.card.entities.CardDetails;
import com.card.entities.CardNumber;

@SpringBootApplication
public class CardVerifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardVerifyApplication.class, args);
        
		
	}

}
