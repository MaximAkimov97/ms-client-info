package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "Ответ об ошибке")
public class ErrorResponse {
    @Schema(description = "Код ошибки")
    @Getter
    private String error;
    @Schema(description = "Сообщение об ошибке")
    @Getter
    private String message;

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
