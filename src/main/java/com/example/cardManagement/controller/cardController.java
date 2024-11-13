package com.example.cardManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardManagement.model.card;
import com.example.cardManagement.service.cardService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/card")
public class cardController {
    @Autowired
    private cardService cardService;

    @GetMapping
    public List<card> getAllCards() {
        return cardService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<card> getCardById(@PathVariable int id) {
        Optional<card> card = cardService.findById(id);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{cardType}")
    public ResponseEntity<card> getCardByCardType(@PathVariable String cardType) {
        Optional<card> card = cardService.findBycardType(cardType);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<card> getCardByCardNumber(@PathVariable Long cardNumber) {
        Optional<card> card = cardService.findBycardNumber(cardNumber);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<card> createCard(@RequestBody card card) {
        card savedCard = cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<card> updateCard(@PathVariable int id, @RequestBody card card) {
        if(!cardService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        card.setId(id);
        card updatedCard = cardService.save(card);
        return ResponseEntity.ok(updatedCard);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<card> deleteCard(@PathVariable int id) {
        if (!cardService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}
