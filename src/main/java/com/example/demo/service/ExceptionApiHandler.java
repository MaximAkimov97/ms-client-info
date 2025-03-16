package com.example.demo.service;


import com.example.demo.dto.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Optional: Returns 404
    public ResponseEntity<ErrorResponse> handleResourceNotFound(MethodArgumentNotValidException ex) {
        ex.printStackTrace();
        final ErrorResponse error = new ErrorResponse("000 001", "Неверный формат данных");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Optional: Returns 404
    public ResponseEntity<ErrorResponse> handleResourceNotFound(DataIntegrityViolationException ex) {
        ex.printStackTrace();
        final ErrorResponse error = new ErrorResponse("000 002", "Нарушение целостности данных");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Optional: Returns 404
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ClientNotFoundException ex) {
        ex.printStackTrace();
        final ErrorResponse error = new ErrorResponse("000 003", "Клиент не найден");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Общий обработчик для всех остальных необработанных исключений
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Optional: Returns 500
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        // Логирование ошибки
        ex.printStackTrace();

        ErrorResponse error = new ErrorResponse("Другая ошибка", "Обратитесь в службу поддержки");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
