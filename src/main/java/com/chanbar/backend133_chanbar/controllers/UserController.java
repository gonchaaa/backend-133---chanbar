package com.chanbar.backend133_chanbar.controllers;

import com.chanbar.backend133_chanbar.DTOs.request.LoginRequestDTO;
import com.chanbar.backend133_chanbar.DTOs.request.RegistrationDTO;
import com.chanbar.backend133_chanbar.DTOs.response.LoginResponseDTO;
import com.chanbar.backend133_chanbar.services.IUserService;
import com.chanbar.backend133_chanbar.services.Impls.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping("/register")
    void registerUser(@RequestBody RegistrationDTO registrationDTO){
        log.info("Registration email: {}",registrationDTO.getEmail());
        userService.registerUser(registrationDTO);
    }
    @PostMapping("/login")
    LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        log.info("Login user email:{}",loginRequestDTO.getEmail());
        return userService.login(loginRequestDTO);
    }
}
