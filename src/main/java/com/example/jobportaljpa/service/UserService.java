package com.example.jobportaljpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jobportaljpa.model.User;
import com.example.jobportaljpa.repo.UserRepo;


@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        // System.out.println(user.getPassword());
        return repo.save(user);
    }
}
