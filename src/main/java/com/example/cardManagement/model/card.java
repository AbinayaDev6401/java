package com.example.cardManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class card {
    @Id
    private int id;
    private String cardType;
    private Long cardNumber;
    private int cvvNumber;
    private String cardholderName;

    // constructors
    public card() {
    }

    public card(String cardholderName, String cardName, String cardType, Long cardNumber, int cvvNumber) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.cardType = cardType;
        this.cvvNumber = cvvNumber;
    }

    //Getters and setters
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getCardType(){
        return cardType;
    }
    public void setCardType(String cardType){
        this.cardType = cardType;
    }

    public Long getCardNumber(){
        return cardNumber;
    }
    public void setCardNumber(Long cardNumber){
        this.cardNumber = cardNumber;
    }

    public int getCvvNumber(){
        return cvvNumber;
    }
    public void setCvvNumber(int cvvNumber){
        this.cvvNumber = cvvNumber;
    }

    public String getCardholderName(){
        return cardholderName;
    }
    public void setCardholderName(String cardholderName){
        this.cardholderName = cardholderName;
    }
}
