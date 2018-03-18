package com.gett.infra.hibernate.pojo.datagenerator;

public class CreditCard {

    private int id;
    private String scrumName;
    private String cardNumber;

    public CreditCard() {
    }

    public CreditCard(int id, String scrumName, String cardNumber) {
        this.id = id;
        this.scrumName = scrumName;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScrumName() {
        return scrumName;
    }

    public void setScrumName(String scrumName) {
        this.scrumName = scrumName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
