package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;

    public void setPhone(Long phone) {
    }
}
