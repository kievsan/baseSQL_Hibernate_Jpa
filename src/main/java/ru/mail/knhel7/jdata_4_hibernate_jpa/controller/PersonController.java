package ru.mail.knhel7.jdata_4_hibernate_jpa.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.Person;
import ru.mail.knhel7.jdata_4_hibernate_jpa.repository.PersonJPARepo;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonJPARepo repo;

  @GetMapping("/")
  public ResponseEntity<String> hi(Principal principal) {
    return ResponseEntity.ok("Hi, " + principal.getName() + " !!!");
  }

  @Secured("ROLE_READ")
  @GetMapping("/by-city")
  public ResponseEntity <List<Person>> getPersonsByCity(@RequestParam("city") String city) {
    return ResponseEntity.ok(repo.findByCity(city));
  }

  @RolesAllowed({"ROLE_READ", "ROLE_WRITE"})
  @GetMapping("/by-name")
  public ResponseEntity<Person> getPersonByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname){
    return repo.findByNameAndSurname(name, surname).map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PreAuthorize("hasRole('ROLE_DELETE') or hasRole('ROLE_WRITE')")
  @GetMapping("/by-age")
  public ResponseEntity<List<Person>> getPersonsByAge(@RequestParam("age") int age){
    return ResponseEntity.ok(repo.findByAgeLessThan(age));
  }

}
