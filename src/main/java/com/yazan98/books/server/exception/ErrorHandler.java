package com.yazan98.books.server.exception;

import com.yazan98.books.server.response.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.MethodNotSupportedException;
import java.time.Instant;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 9:49 AM
 */

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(NotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        ex.getMessage(),
                        Instant.now(),
                        request.getContextPath(),
                        HttpStatus.NOT_FOUND.value() + "",
                        ex.getStackTrace()
                )
        );
    }

    @ExceptionHandler(value = {InvalidValueException.class})
    protected ResponseEntity<Object> handleInvalid(NotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage(),
                        Instant.now(),
                        request.getContextPath(),
                        HttpStatus.BAD_REQUEST.value() + "",
                        ex.getStackTrace()
                )
        );
    }

    @ExceptionHandler(value = {MethodNotSupportedException.class , MethodNotAllowedException.class})
    protected ResponseEntity<Object> handleMethodNotAllowed(NotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(
                new ErrorResponse(
                        HttpStatus.METHOD_NOT_ALLOWED.value(),
                        ex.getMessage(),
                        Instant.now(),
                        request.getContextPath(),
                        HttpStatus.METHOD_NOT_ALLOWED.value() + "",
                        ex.getStackTrace()
                )
        );
    }
}
