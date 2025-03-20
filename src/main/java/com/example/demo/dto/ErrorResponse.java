package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Schema(description = "Ответ об ошибке")
public class ErrorResponse {
    @Schema(description = "Код ошибки")
    private String error;
    @Schema(description = "Сообщение об ошибке")
    private String message;
}
