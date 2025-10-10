package com.chanbar.backend133_chanbar.services.Impls;

import com.chanbar.backend133_chanbar.DTOs.request.LoginRequestDTO;
import com.chanbar.backend133_chanbar.DTOs.request.RegistrationDTO;
import com.chanbar.backend133_chanbar.DTOs.response.LoginResponseDTO;
import com.chanbar.backend133_chanbar.models.User;
import com.chanbar.backend133_chanbar.repositories.UserRepository;
import com.chanbar.backend133_chanbar.security.JwtService;
import com.chanbar.backend133_chanbar.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
            throw new RuntimeException("Qeydiyyat zamanı xəta baş verdi: " + e.getMessage());
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

        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı"));

        String token = jwtService.generateToken(user);
        return new LoginResponseDTO(token);
    }
}
