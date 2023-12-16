package org.example.endtermback.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.endtermback.payload.JwtResponse;
import org.example.endtermback.payload.LoginRequest;
import org.example.endtermback.payload.RegRequest;
import org.example.endtermback.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = authService.authUser(loginRequest);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/user/signup")
    public ResponseEntity<?> register(@Valid @RequestBody RegRequest regRequest) {
        String result = authService.registration(regRequest);
        return ResponseEntity.ok(result);
    }
}
