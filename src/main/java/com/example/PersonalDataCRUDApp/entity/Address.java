package com.example.PersonalDataCRUDApp.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Embeddable
public class Address {

    @NotNull
    private Integer postalCode;
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotNull
    private Integer houseNumber;
}
