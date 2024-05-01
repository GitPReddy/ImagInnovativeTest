package com.imaginnovate.tax.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleEmployNotValidException(EmployNotValidException employNotValidException){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(employNotValidException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleEmployAlreadyExistsException(EmployAlreadyExistsException employNotValidException){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(employNotValidException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleInValidDateException(InvalidDateException invalidDateException){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(invalidDateException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleInValidFieldException(InvalidFieldException invalidFieldException){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(invalidFieldException.getMessage());
    }
}
