package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    @NotBlank//Не пустое значение номера телефона
    @Pattern(regexp = "^\\+7[0-9]{10}$", message = "Номер телефона должен быть в формате +7xxxxxxxxxx")
    private String phoneNumber;
}
