package com.naim.auction.services;

import com.naim.auction.entities.User;
import com.naim.auction.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    public User findCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByEmail(email);
    }

    public User registerUser(String name, String email, String pictureUrl, String password) {
        return myUserDetailsService.addUser(name, email, pictureUrl, password);
    }
}

