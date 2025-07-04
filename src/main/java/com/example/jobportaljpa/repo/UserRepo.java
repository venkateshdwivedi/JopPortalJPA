package com.example.jobportaljpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobportaljpa.model.User;


@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    User findByUsername(String username);
}
