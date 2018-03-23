package com.gett.infra.hibernate.pojo.datagenerator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PhoneNumber {

    private int id;
    private String scrumName;
    private String phoneNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(int id, String scrumName, String phoneNumber) {
        this.id = id;
        this.scrumName = scrumName;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
