package org.example.endtermback.service;

import org.example.endtermback.payload.JwtResponse;
import org.example.endtermback.payload.LoginRequest;
import org.example.endtermback.payload.RegRequest;


public interface AuthService {

    String registration(RegRequest user);

    JwtResponse authUser(LoginRequest loginRequest);
}
