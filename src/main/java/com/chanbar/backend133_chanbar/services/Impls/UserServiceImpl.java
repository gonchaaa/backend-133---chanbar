package com.chanbar.backend133_chanbar.services.Impls;

import com.chanbar.backend133_chanbar.DTOs.request.LoginRequestDTO;
import com.chanbar.backend133_chanbar.DTOs.request.RegistrationDTO;
import com.chanbar.backend133_chanbar.DTOs.response.LoginResponseDTO;
import com.chanbar.backend133_chanbar.exceptions.BaseException;
import com.chanbar.backend133_chanbar.exceptions.ErrorsType;
import com.chanbar.backend133_chanbar.models.User;
import com.chanbar.backend133_chanbar.repositories.UserRepository;
import com.chanbar.backend133_chanbar.security.JwtService;
import com.chanbar.backend133_chanbar.services.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public void registerUser(RegistrationDTO registrationDTO) {
        try {
            User user = new User();

            user.setFirstName(registrationDTO.getFirstName());
            user.setLastName(registrationDTO.getLastName());
            user.setEmail(registrationDTO.getEmail());
            user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
            userRepository.save(user);

        } catch (Exception e) {
            throw new BaseException(ErrorsType.INVALID_DATA, e.getMessage());
        }

    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getEmail(),
                        loginRequestDTO.getPassword()
                )
        );

        Optional<User> user = userRepository.findByEmail(loginRequestDTO.getEmail());

        try{
            if (user.isPresent()){
                String token = jwtService.generateToken(user);
                log.info("Token was created succesfully");
                return new LoginResponseDTO(token);
            }
        } catch (Exception e) {
            log.error("Not found this user:{}",loginRequestDTO.getEmail());
            throw new RuntimeException(e);
        }
        return null;

    }
}
