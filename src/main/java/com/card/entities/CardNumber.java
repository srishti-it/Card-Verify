package com.card.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARD_NUMBER")
public class CardNumber {

	@Id
	private int cardNumber;

	public CardNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
}
