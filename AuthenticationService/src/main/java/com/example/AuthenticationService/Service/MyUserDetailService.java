package com.example.AuthenticationService.Service;

import com.example.AuthenticationService.Entity.User;
import com.example.AuthenticationService.Repository.UserRepository;
import com.example.AuthenticationService.config.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByName(username);
        if (user == null) {
            System.out.println("Jwt user not found");
            throw new UsernameNotFoundException("jwt user not found");
        }
        return new UserPrinciple(user);
    }


}