package com.card.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.card.entities.CardNumber;


public interface CardRepo extends JpaRepository<CardNumber,String>{

	Boolean existsByCardNumber(String cardNumber);

	Optional<CardNumber> findByCardNumber(String cardNumber);
	
}
