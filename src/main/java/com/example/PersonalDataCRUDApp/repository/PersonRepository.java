package com.example.PersonalDataCRUDApp.repository;

import com.example.PersonalDataCRUDApp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
