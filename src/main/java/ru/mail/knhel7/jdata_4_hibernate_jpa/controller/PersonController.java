package ru.mail.knhel7.jdata_4_hibernate_jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.Person;
import ru.mail.knhel7.jdata_4_hibernate_jpa.repository.PersonRepo;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons/by-city")
public class PersonController {

  private final PersonRepo repo;

  @GetMapping
  public ResponseEntity <List<Person>> selectPersonsByCity(@RequestParam("city") String city) {
    return ResponseEntity.ok(repo.getPersonsByCity(city));
  }

}
