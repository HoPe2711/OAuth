package com.example.auth_service_spring.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class ApplicationUser implements Serializable {
    private static final long serialVersionUID = 885755982832759979L;
    @Id
    private String id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private boolean status;
    @Transient
    private String passwordConfirm;
}
