package com.khaithumc.shopme_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = com.khaithumc.shopme_backend.exceptions.UpdateFailException.class)
    public final ResponseEntity<String> handleUpdateFailException(com.khaithumc.shopme_backend.exceptions.UpdateFailException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = com.khaithumc.shopme_backend.exceptions.AuthenticationFailException.class)
    public final ResponseEntity<String> handleUpdateFailException(com.khaithumc.shopme_backend.exceptions.AuthenticationFailException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CustomException.class)
    public final ResponseEntity<String> handleUpdateFailException(CustomException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
