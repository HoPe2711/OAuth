package com.example.auth_service_spring.security.service;


import com.example.auth_service_spring.repository.ApplicationUserRepository;
import com.example.auth_service_spring.repository.entities.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
    public class UserDetailsServiceImplement implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public UserDetailsServiceImplement(ApplicationUserRepository applicationUserRepository){
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        ApplicationUser applicationUser =  applicationUserRepository.findByUsername(username);
        if (applicationUser == null){
            throw new UsernameNotFoundException("User not found with " + username);
        }
        return UserDetailsImplement.build(applicationUser);
    }
}
