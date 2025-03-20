package com.example.demo.service;


import com.example.demo.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(MethodArgumentNotValidException ex) {
        ex.printStackTrace();
        final ErrorResponse error = new ErrorResponse("Bad_request", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ClientNotFoundException ex) {
        ex.printStackTrace();
        final ErrorResponse error = new ErrorResponse("Client Not Found", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClientRegistrationBanException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ClientRegistrationBanException ex) {
        ex.printStackTrace();
        final ErrorResponse error = new ErrorResponse("Ведро помоев, это не имя", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    // Общий обработчик для всех остальных необработанных исключений
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        // Логирование ошибки
        ex.printStackTrace();
        ErrorResponse error = new ErrorResponse("Другая ошибка", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
