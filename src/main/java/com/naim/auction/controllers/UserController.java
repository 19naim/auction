package com.naim.auction.controllers;

import com.naim.auction.entities.User;
import com.naim.auction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@RestController
public class UserController {

    final String passwordSalt = "keyboard-kitten";

    @Autowired
    UserService userService;

    @Resource(name="authenticationManager")
    private AuthenticationManager authManager;

    /*@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletRequest req) {
        securityLogin(user.getEmail(), user.getPassword(), req);
        return ResponseEntity.ok("ok");
    }*/

    @GetMapping("/currentuser")
    public ResponseEntity<User> currentUser() {
        User user = userService.findCurrentUser();
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/auth/user")
    public User getUser(){
        return userService.findCurrentUser();
    }

    @PostMapping("/auth/register")
    public ResponseEntity<User> register(@RequestBody User user){
        var newuser = userService.registerUser(user.getName(), user.getEmail(), user.getPictureUrl(), user.getPassword());
        return ResponseEntity.ok(newuser);
    }

    private void securityLogin(String email, String password, HttpServletRequest req) {
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(email, password);
        Authentication auth = authManager.authenticate(authReq);

        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = req.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
    }

}

