package com.innova.controller;

import com.innova.dto.RegisterDto;
import com.innova.entity.UserEntity;
import com.innova.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

    @RestController
    public class UserRestController {

        @Autowired
        IUserRepository iUserRepository;

        @GetMapping("/rest/getAllUser")
        public Iterable<RegisterDto> getAllUser(){

            List<RegisterDto> dtoList = new ArrayList<>();
            Iterable<UserEntity> userList = this.iUserRepository.findAll();

            for (UserEntity user: userList) {

                RegisterDto dto = RegisterDto.builder()
                        .userId(user.getUserId()).userName(user.getUserName()).userPassword(user.getUserPassword())
                        .userEmail(user.getUserEmail()).userRace(user.getUserRace()).build();

                dtoList.add(dto);
            }

            return dtoList;
        }
    }

