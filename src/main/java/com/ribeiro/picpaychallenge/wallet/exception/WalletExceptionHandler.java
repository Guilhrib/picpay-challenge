package com.ribeiro.picpaychallenge.wallet.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WalletExceptionHandler {
    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<Object> handle(WalletNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
