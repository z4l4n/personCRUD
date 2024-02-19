package com.example.PersonalDataCRUDApp.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = ex.getBindingResult().getAllErrors().stream()
                .collect(Collectors.toMap(err -> ((FieldError) err).getField(), DefaultMessageSourceResolvable::getDefaultMessage));

        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value
            = {Exception.class})
    protected ResponseEntity<ErrorResponseDto> handleGeneralException(
            Exception ex, WebRequest request) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder().message(ex.getMessage()).build());
    }
}
