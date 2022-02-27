package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

public class RegisterDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotEmpty(message = "Kullanıcı adını doldurunuz")
    private String userName;

    @NotEmpty(message = "Email'i doldurunuz")
    @Email(message = "Gecerli bir email giriniz")
    private String userEmail;

    @NotEmpty(message = "Sifre alanini doldurunuz")
    private String userPassword;

    @NotEmpty(message = "Irkınızı seçiniz")
    @NotNull(message = "Name may not be null")
    private String userRace;



}
