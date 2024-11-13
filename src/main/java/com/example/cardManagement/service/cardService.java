package com.example.cardManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cardManagement.model.card;
import com.example.cardManagement.repository.cardRepository;

@Service
public class cardService {
    @Autowired
    private cardRepository cardRepository;

    public List<card> findAll(){
        return cardRepository.findAll();
    }

    public Optional<card> findById(int id){
        return cardRepository.findById(id);
    }

    public Optional<card> findBycardType(String cardType){
        return cardRepository.findBycardType(cardType);
    }

    public Optional<card> findBycardNumber(Long cardNumber){
        return cardRepository.findBycardNumber(cardNumber);
    }

    public card save(card card){
        return cardRepository.save(card);
    }

    public void deleteById(int id){
        cardRepository.deleteById(id);
    }
}
