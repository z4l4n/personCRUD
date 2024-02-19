package com.example.PersonalDataCRUDApp.controller;

import com.example.PersonalDataCRUDApp.entity.Person;
import com.example.PersonalDataCRUDApp.entity.dto.PersonDto;
import com.example.PersonalDataCRUDApp.service.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api")
@Slf4j
//@Validated
public class PersonController {
    private PersonService personService;

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody @Valid Person person) {
        log.info("POST request received for api/people");

        Person storedPerson = personService.createPerson(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(storedPerson);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> readPerson(@PathVariable(name = "id") Long id) {
        log.info("GET request received for api/people/{}", id);

        Person storedPerson = personService.readPerson(id);

        return ResponseEntity.status(HttpStatus.OK).body(storedPerson);
    }

    @GetMapping("/people")
    public ResponseEntity<List<PersonDto>> readPeople() {
        log.info("GET request received for api/people");

        return ResponseEntity.status(HttpStatus.OK).body(personService.readPeople());
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(name = "id") Long id, @RequestBody @Valid Person person) {
        log.info("PUT request received for api/people/{}", id);

        Person updatedPerson = personService.updatePerson(id, person);

        return ResponseEntity.status(HttpStatus.OK).body(updatedPerson);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {
        log.info("DELETE request received for api/people/{}", id);

        personService.deletePerson(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
