package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об ошибке")
public class ErrorResponse {
    @Schema(description = "Код ошибки")
    private String error;
    @Schema(description = "Сообщение об ошибке")
    private String message;

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }
    public String getCode() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
