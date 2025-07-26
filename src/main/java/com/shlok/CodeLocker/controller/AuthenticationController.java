package com.shlok.CodeLocker.controller;
import com.shlok.CodeLocker.dto.RegisterRequest;
import com.shlok.CodeLocker.dto.AuthenticationResponse;
import com.shlok.CodeLocker.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @GetMapping("/me")
    public ResponseEntity<Principal> getMe(Principal principal) {
        return ResponseEntity.ok(principal);
    }
}
