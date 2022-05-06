package com.example.application.views.main;

import lombok.Data;


@Data
public class Employee {
    private String firstName;
    private String lastName;
    private String eMail;
    private String profession;
    private String status;

    public Employee(String firstName, String lastName, String eMail, String profession, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.profession = profession;
        this.status = status;
    }
}
