package com.example.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public LoginUser loginUser(@RequestBody LoginUser user) {
        Optional<LoginUser> userOptional = loginService.loginUser(user);
        if (userOptional.isEmpty()){
            throw new IllegalStateException("User does not exist");
        }
        LoginUser userInfo = userOptional.get();
        if (user.getPassword().equals(userInfo.getPassword())){
            return userInfo;
        } 
        else {
            throw new IllegalStateException("Password is incorrect");
        }
    }
    

}
