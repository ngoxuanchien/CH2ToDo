package com.example.chtodo.service;

import com.example.chtodo.model.auth.AuthenticationRequest;
import com.example.chtodo.model.auth.AuthenticationResponse;
import com.example.chtodo.model.auth.RegisterRequest;
import com.example.chtodo.model.database.CHUser;
import com.example.chtodo.model.database.Role;
import com.example.chtodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;



    private void UserExist(String email) {
        var user = userRepository.findByEmail(email).orElseThrow();
    }


    public AuthenticationResponse register(RegisterRequest registerRequest) {
        try {
            UserExist(registerRequest.getEmail());
            return AuthenticationResponse.builder()
                    .jwtToken("Email was exist")
                    .build();
        } catch (NoSuchElementException e) {
            CHUser chUser = CHUser.builder()
                    .firstName(registerRequest.getFirstName())
                    .lastName(registerRequest.getLastName())
                    .birthday(registerRequest.getBirthday())
                    .address(registerRequest.getAddress())
                    .mobilePhone(registerRequest.getMobilePhone())
                    .email(registerRequest.getEmail())
                    .password(passwordEncoder.encode(registerRequest.getPassword()))
                    .role(Role.USER)
                    .build();

            userRepository.save(chUser);
            var jwtToken = jwtService.generateToken(chUser);
            return AuthenticationResponse.builder()
                    .jwtToken(jwtToken)
                    .build();
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println(request);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .jwtToken(jwtToken)
                .build();
    }

}
