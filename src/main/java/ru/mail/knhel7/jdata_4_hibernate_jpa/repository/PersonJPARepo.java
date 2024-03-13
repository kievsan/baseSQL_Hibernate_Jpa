package ru.mail.knhel7.jdata_4_hibernate_jpa.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.Person;
import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonJPARepo extends JpaRepository<Person, PersonId> {

    @Query("select p from Person as p where p.city = :city")
    List<Person> findByCity(String city);
    @Query("select p from Person as p where p.name = :name and p.surname = :surname")
    Optional<Person> findByNameAndSurname(String name, String surname);
    @Query("select p from Person as p where p.age < :age order by p.age")
    List<Person> findByAgeLessThan(int age, Sort sort);
}
