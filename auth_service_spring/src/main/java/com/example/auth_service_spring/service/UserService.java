package com.example.auth_service_spring.service;

import com.example.auth_service_spring.repository.entities.ApplicationUser;

public interface UserService {
    void save(ApplicationUser user);

    ApplicationUser findByUsername(String username);
}
