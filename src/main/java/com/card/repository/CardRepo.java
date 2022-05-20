package com.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.card.entities.CardNumber;

@Repository
public interface CardRepo extends JpaRepository<CardNumber,Integer>{

}
