package com.example.chtodo.controller;

import com.example.chtodo.model.auth.AuthenticationRequest;
import com.example.chtodo.model.auth.AuthenticationResponse;
import com.example.chtodo.model.auth.RegisterRequest;
import com.example.chtodo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
            ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
