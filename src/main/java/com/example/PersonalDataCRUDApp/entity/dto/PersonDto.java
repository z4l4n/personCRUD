package com.example.PersonalDataCRUDApp.entity.dto;

import lombok.Data;

@Data
public class PersonDto {
    private long id;
    private String lastName;
    private String firstName;
    private String taxIDNumber;
}
