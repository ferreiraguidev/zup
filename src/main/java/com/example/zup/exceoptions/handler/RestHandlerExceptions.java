package com.example.zup.exceoptions.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestHandlerExceptions {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ExceptionFilters DuplicatedEmail(final DataIntegrityViolationException ex) {
        return ExceptionFilters.builder()
                .title("already registered")
                .details(ex.getMessage())
                .status(BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NullPointerException.class)
    public ExceptionFilters UserNotFound(final DataIntegrityViolationException ex) {
        return ExceptionFilters.builder()
                .title("Not Found")
                .details(ex.getMessage())
                .status(NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
