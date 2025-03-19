package com.example.AuthenticationService.Controller;

import com.example.AuthenticationService.Entity.User;
import com.example.AuthenticationService.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate/api/auth")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password) {
        String token = authService.verify(name, password);
        return token;

    }

}
