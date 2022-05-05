package com.example.application.views.main;

import jdk.jfr.DataAmount;
import lombok.Data;


@Data
public class Person {
    private String firstName;
    private String lastName;
    private String eMail;
    private String address;
    private String phoneNumber;

    public Person(String firstName, String lastName, String eMail, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
