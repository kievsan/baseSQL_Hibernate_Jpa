package ru.mail.knhel7.jdata_4_hibernate_jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.Person;

@Repository
public class PersonRepoImpl implements PersonRepo {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public List<Person> getPersonsByCity(String city) {
        var query = manager.createQuery("SELECT p FROM Person p WHERE p.city = :city");
        query.setParameter("city", city);
        return query.getResultList();
    }
}
