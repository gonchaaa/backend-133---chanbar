package com.chanbar.backend133_chanbar.services;

import com.chanbar.backend133_chanbar.DTOs.request.LoginRequestDTO;
import com.chanbar.backend133_chanbar.DTOs.request.RegistrationDTO;
import com.chanbar.backend133_chanbar.DTOs.response.LoginResponseDTO;

public interface IUserService {
    void registerUser(RegistrationDTO registrationDTO);
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
