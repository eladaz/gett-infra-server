package com.gett.infra.hibernate.pojo.datagenerator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CreditCard {

    private int id;
    private String scrumName;
    @JsonProperty("CardNumber")
    private String cardNumber;
    @JsonProperty("IssuingNetwork")
    private String issuingNetwork;

    public CreditCard() {
    }

    public CreditCard(int id, String scrumName, String cardNumber, String issuingNetwork) {
        this.id = id;
        this.scrumName = scrumName;
        this.cardNumber = cardNumber;
        this.issuingNetwork = issuingNetwork;
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

    public String getIssuingNetwork() {
        return issuingNetwork;
    }

    public void setIssuingNetwork(String issuingNetwork) {
        this.issuingNetwork = issuingNetwork;
    }

}
