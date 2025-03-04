package com.example.demo.service;


import org.hibernate.exception.ConstraintViolationException;
import org.springdoc.api.ErrorMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> Exception(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleClientNotFoundException(ClientNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String message = "Invalid input: " + ex.getName() + " must be of type " + ex.getRequiredType().getSimpleName();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String message = "Invalid request body: " + ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(message));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorMessage> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorMessage("Data integrity violation: " + ex.getMessage()));
    }

}
