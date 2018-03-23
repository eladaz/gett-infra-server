package com.gett.infra.app.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CreditCardDTO {

    public int id;
    public String scrumName;
    public String cardNumber;
    private String issuingNetwork;

}
