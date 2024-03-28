package com.example.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hasher.Hasher;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
        if (Hasher.hashString(user.getPassword()).equals(userInfo.getPassword())){
            return userInfo;
        } 
        else {
            throw new IllegalStateException("Password is incorrect");
        }
    }
    
    @GetMapping("/userInfo")
    public LoginUser getMethodName(@RequestParam String email) {
        Optional<LoginUser> user = loginService.getUserInfo(email);
        if (user.isPresent()){
            return user.get();
        }
        else{
            throw new IllegalStateException("User with that email does not exist");
        }
    }
    

}
