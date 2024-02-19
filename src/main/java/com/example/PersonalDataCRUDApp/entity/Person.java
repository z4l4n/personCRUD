package com.example.PersonalDataCRUDApp.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotBlank
    private String birthName;

    @NotBlank
    private String mothersName;

    private Gender gender;

    @NotBlank
    private String citizenship;

    @NotNull
    @Valid
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postalCode", column = @Column(name = "res_postal_code")),
            @AttributeOverride(name = "city", column = @Column(name = "res_city")),
            @AttributeOverride(name = "street", column = @Column(name = "res_street")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "res_house_number"))
    })
    private Address residentialAddress; // could have created a separate table and manyToOne rel.

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postalCode", column = @Column(name = "mail_postal_code")),
            @AttributeOverride(name = "city", column = @Column(name = "mail_city")),
            @AttributeOverride(name = "street", column = @Column(name = "mail_street")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "mail_house_number"))
    })
    @Valid
    private Address mailingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postalCode", column = @Column(name = "tmp_postal_code")),
            @AttributeOverride(name = "city", column = @Column(name = "tmp_city")),
            @AttributeOverride(name = "street", column = @Column(name = "tmp_street")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "tmp_house_number"))
    })
    @Valid
    private Address temporaryAddress;

    @NotBlank
    @Pattern(regexp = "[0-9]{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "[0-9]{8}", message = "Tax number must be 8 digits")
    private String taxIDNumber;

    private String comments;
}
