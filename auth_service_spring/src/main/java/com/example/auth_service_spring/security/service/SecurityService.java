package com.example.auth_service_spring.security.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}