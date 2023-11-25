package com.example.ibhw2.service;

import com.example.ibhw2.model.User;

public interface AuthService {
    User login(String username, String password);
}
