package ru.mail.knhel7.jdata_4_hibernate_jpa.repository;

import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.Person;

import java.util.List;

public interface PersonRepo {

    List<Person> getPersonsByCity (String city);
}
