package com.example.application.views.main.object;

import jdk.jfr.DataAmount;
import lombok.Data;


@Data
public class Person {
    private String firstName;
    private String lastName;
    private String eMail;
    private String address;
    private String phoneNumber;
    private String pictureUrl;
    private String profession;
    private String status;

    public Person(String firstName, String lastName, String eMail, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Person(String firstName, String lastName, String eMail, String address, String phoneNumber, String pictureUrl, String profession, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.pictureUrl = pictureUrl;
        this.profession = profession;
        this.status = status;
    }

    public Person(String firstName, String lastName, String profession, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.status = status;
    }

    public Person(String firstName, String lastName, String eMail, String pictureUrl, String profession, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.pictureUrl = pictureUrl;
        this.profession = profession;
        this.status = status;
    }

    public String getFullName(){
        return firstName+" "+lastName;
    }
}
