package ru.mail.knhel7.jdata_4_hibernate_jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.Person;
import ru.mail.knhel7.jdata_4_hibernate_jpa.repository.PersonJPARepo;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonJPARepo repo;

  @GetMapping("/by-city")
  public ResponseEntity <List<Person>> getPersonsByCity(@RequestParam("city") String city) {
    return ResponseEntity.ok(repo.findByCity(city));
  }

  @GetMapping("/by-name")
  public ResponseEntity<Person> getPersonsByCity(@RequestParam("name") String name, @RequestParam("surname") String surname){
    return repo.findByNameAndSurname(name, surname).map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @GetMapping("/by-age")
  public ResponseEntity<List<Person>> getPersonsByAge(@RequestParam("age") int age){
    return ResponseEntity.ok(repo.findByAgeLessThan(age));
  }

}
