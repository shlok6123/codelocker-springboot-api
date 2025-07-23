package com.shlok.CodeLocker.service;

import com.shlok.CodeLocker.dto.AuthenticationResponse;
import com.shlok.CodeLocker.dto.RegisterRequest;
import com.shlok.CodeLocker.model.Role;
import com.shlok.CodeLocker.model.User;
import com.shlok.CodeLocker.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.User)
                .build();
        userRepository.save(user);
        return new AuthenticationResponse("User registered successfully");
    }
}
