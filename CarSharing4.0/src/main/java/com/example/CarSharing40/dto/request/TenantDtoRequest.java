package com.example.CarSharing40.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Getter
public class TenantDtoRequest {

    @NotBlank(message = "Username must be specified")
    private String username;

    @NotBlank(message = "Name must be specified")
    private String name;

    @NotBlank(message = "Surname must be specified")
    private String surname;

    @NotBlank(message = "Age must be specified")
    private Integer age;
}
