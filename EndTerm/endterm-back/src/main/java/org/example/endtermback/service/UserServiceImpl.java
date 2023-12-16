package org.example.endtermback.service;

import org.example.endtermback.models.User;
import org.example.endtermback.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{

    private UserRepository userRepository;
    @Override
    public ResponseEntity<?> getUsers() {
        List<User> listOfUsers = userRepository.findAll();
        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUserProfile(Long id) {
        User user = userRepository.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
