package com.example.cardManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardManagement.model.card;

public interface cardRepository extends JpaRepository<card, Integer> {

    Optional<card> findBycardType(String cardType);
    Optional<card> findBycardNumber(Long cardNumber);

}
 