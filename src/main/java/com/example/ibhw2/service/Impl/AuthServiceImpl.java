package com.example.ibhw2.service.Impl;

import com.example.ibhw2.model.User;
import com.example.ibhw2.model.exceptions.InvalidArgumentsException;
import com.example.ibhw2.model.exceptions.InvalidUserCredentialsException;
import com.example.ibhw2.repository.UserRepository;
import com.example.ibhw2.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}

