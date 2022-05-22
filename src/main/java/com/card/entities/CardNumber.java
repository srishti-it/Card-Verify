package com.card.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARD_NUMBER")
public class CardNumber {
	
public CardNumber(String cardNumber,Long id) {
	this.cardNumber = cardNumber;
	this.id=id;
}

public String getCardNumber() {
	return cardNumber;
}

public Integer hits;

public Integer getHits() {
	return hits;
}

public void setHits(Integer hits) {
	this.hits = hits;
}

public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

@Column(name = "card_number")
private String cardNumber;


public CardNumber() {

}
}

	

		
	

