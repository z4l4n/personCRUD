package com.example.PersonalDataCRUDApp.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
    private String message;


}
