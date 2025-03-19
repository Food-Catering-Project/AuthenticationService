package com.example.AuthenticationService.Repository;


import com.example.AuthenticationService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
       User findByName(String name);

}