package org.example.endtermback.service;

import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> getUsers();

    ResponseEntity<?> getUserProfile(Long id);

}
