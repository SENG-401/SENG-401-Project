package com.example.register;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.LoginUser;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/register")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public LoginUser registerUser(@RequestBody LoginUser user) {
        Optional<LoginUser> userOptional = registerService.registerUser(user);
        if (userOptional.isEmpty()){
            throw new IllegalStateException("Email already taken");
        }
        return userOptional.get();
    }
    


}
