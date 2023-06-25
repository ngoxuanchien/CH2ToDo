package com.example.chtodo.service;

import com.example.chtodo.model.CHUser;
import com.example.chtodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
//    private final AuthentiactionManager authentiactionManager;


    public String register(CHUser user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "user ton tai";
        } else {
            userRepository.save(user);
            return "Tao user thanh cong";
        }
    }

}
