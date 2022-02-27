package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

public class LoginDto {

    @NotEmpty(message = "Kullanıcı adı boş olamaz")
    private String userName;

    @NotEmpty(message = "Sifre Boş olamaz")
    private String userPassword;
}
