package com.ribeiro.picpaychallenge.authorization.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthorizationExceptionHandler {
    @ExceptionHandler(UnauthorizedTransactionException.class)
    public ResponseEntity<Object> handle(UnauthorizedTransactionException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
