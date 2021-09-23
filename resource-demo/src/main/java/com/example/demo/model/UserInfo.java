package com.example.demo.model;

import com.example.demo.repository.entities.ApplicationUser;
import lombok.Data;

@Data
public class UserInfo {
    private String id;
    private String email;

    public UserInfo(ApplicationUser applicationUser){
        this.id = applicationUser.getId();
        this.email = applicationUser.getEmail();
    }
}
