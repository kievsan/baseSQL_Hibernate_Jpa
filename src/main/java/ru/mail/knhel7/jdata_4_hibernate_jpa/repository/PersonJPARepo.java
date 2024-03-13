package ru.mail.knhel7.jdata_4_hibernate_jpa.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.Person;
import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonJPARepo extends JpaRepository<Person, PersonId> {

    List<Person> findByCity(String city);
    Optional<Person> findByNameAndSurname(String name, String surname);
    List<Person> findByAgeLessThan(int age, Sort sort);
}
