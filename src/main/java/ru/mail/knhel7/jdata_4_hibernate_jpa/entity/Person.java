package ru.mail.knhel7.jdata_4_hibernate_jpa.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Builder;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")
@Entity
public class Person implements Serializable {
    @Id
    @Column(length = 20)
    private String name;
    @Id
    @Column(length = 30)
    private String surname;
    @Id
    private int age;
    @Column(name = "phone_number", length = 12)
    private String phone;
    @Column(name = "city_of_living", length = 30)
    private String city;
}
