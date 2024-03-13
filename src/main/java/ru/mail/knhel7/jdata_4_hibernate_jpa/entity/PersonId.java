package ru.mail.knhel7.jdata_4_hibernate_jpa.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class PersonId implements Serializable {

    private String name;
    private String surname;
    private int age;
}
