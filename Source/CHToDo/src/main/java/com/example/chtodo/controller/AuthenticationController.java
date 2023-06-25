package com.example.chtodo.controller;

import com.example.chtodo.model.CHUser;
import com.example.chtodo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/register")
    public String registerUser(@RequestBody CHUser newUser) {
        return authenticationService.register(newUser);
    }

}
