package org.example.endtermback.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.endtermback.models.User;
import org.example.endtermback.payload.JwtResponse;
import org.example.endtermback.payload.LoginRequest;
import org.example.endtermback.payload.RegRequest;
import org.example.endtermback.repository.UserRepository;
import org.example.endtermback.security.jwt.JwtUtils;
import org.example.endtermback.security.services.UserDetailsImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImpl implements AuthService{
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    @Override
    public String registration(RegRequest regRequest) {
        if (userRepository.existsByEmail(regRequest.getEmail())) {
            return "Account Exists!!!";
        }
        User user = new User();
        user.setPassword(encoder.encode(regRequest.getPassword()));
        user.setEmail(regRequest.getEmail());
        user.setFirstname(regRequest.getFirstName());
        user.setLastname(regRequest.getLastName());
        userRepository.save(user);
        return "User registered successfully!";
    }


    @Override
    public JwtResponse authUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return new JwtResponse(jwt);
    }
}
