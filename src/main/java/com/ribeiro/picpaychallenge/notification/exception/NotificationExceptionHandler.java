package com.ribeiro.picpaychallenge.notification.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotificationExceptionHandler {
    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<Object> handle(NotificationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
