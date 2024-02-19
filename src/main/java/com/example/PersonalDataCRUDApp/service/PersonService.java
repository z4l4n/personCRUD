package com.example.PersonalDataCRUDApp.service;

import com.example.PersonalDataCRUDApp.entity.Person;
import com.example.PersonalDataCRUDApp.entity.dto.PersonDto;
import com.example.PersonalDataCRUDApp.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;
    private ModelMapper modelMapper;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person readPerson(long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.orElseThrow(() -> new EntityNotFoundException("There is no person stored with id: " + id));
    }

    public List<PersonDto> readPeople() {
        List<Person> people = personRepository.findAll();
        return people.stream().map(person -> modelMapper.map(person, PersonDto.class)).collect(Collectors.toList());
    }

    public Person updatePerson(Long id, Person person) {
        Optional<Person> storedPersonOptional = personRepository.findById(id);
        if (storedPersonOptional.isEmpty()) {
            throw new EntityNotFoundException("There is no person stored with id: " + id);
        }

        BeanUtils.copyProperties(person, storedPersonOptional.get(), "id");

        return personRepository.save(storedPersonOptional.get());
    }

    public void deletePerson(long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isEmpty()) {
            throw new EntityNotFoundException("There is no person stored with id: " + id);
        }

        personRepository.deleteById(id);
    }

}
