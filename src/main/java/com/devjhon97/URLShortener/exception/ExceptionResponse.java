package com.devjhon97.URLShortener.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ExceptionResponse {
    private final int status;
    private final String message;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String stackTrace;
    private List<ValidationError> errors;

    public void addValidationError(String field, String message) {
        if (errors == null) {
            errors = new ArrayList<>();
        }

        errors.add(new ValidationError(field, message));
    }
}
