package ru.mail.knhel7.jdata_4_hibernate_jpa.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class PersonId implements Serializable {

    private String name;
    private String surname;
    private int age;
}
