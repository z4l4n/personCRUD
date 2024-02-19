package com.example.PersonalDataCRUDApp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonalDataCrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalDataCrudAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
