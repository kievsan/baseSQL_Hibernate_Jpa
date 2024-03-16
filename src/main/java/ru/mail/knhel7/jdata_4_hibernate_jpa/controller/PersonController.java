package ru.mail.knhel7.jdata_4_hibernate_jpa.controller;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.mail.knhel7.jdata_4_hibernate_jpa.entity.Person;
import ru.mail.knhel7.jdata_4_hibernate_jpa.repository.PersonJPARepo;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonJPARepo repo;

  @PermitAll
  @GetMapping("/")
  public ResponseEntity<String> hi(Authentication authentication) {
    return ResponseEntity.ok("Hi, " + authentication.getName() + " !!!  " + authentication.getAuthorities());
  }

  @Secured("ROLE_READ")
  @GetMapping("/by-city")
  public ResponseEntity <List<Person>> getPersonsByCity(@RequestParam("city") String city) {
    return ResponseEntity.ok(repo.findByCity(city));
  }

  @PreAuthorize("(hasRole('ROLE_DELETE') or hasRole('ROLE_WRITE')) and (#name == authentication.principal.username)")
  @GetMapping("/by-name")
  public ResponseEntity<Person> getPersonByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname){
      return repo.findByNameAndSurname(name, surname).map(ResponseEntity::ok)
              .orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @RolesAllowed({"ROLE_READ", "ROLE_WRITE"})  // дает ОШИБКУ 403 всегда, даже там, где ее нет ?????! @Secured - норм
  @GetMapping("/by-age")
  public ResponseEntity<List<Person>> getPersonsByAge(@RequestParam("age") int age){
    return ResponseEntity.ok(repo.findByAgeLessThan(age));
  }

}
