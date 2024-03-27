package com.example.login;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Optional<LoginUser> loginUser(LoginUser user) {
        Optional<LoginUser> userOptional = loginRepository.findUserByEmail(user.getEmail());
        return userOptional;
    }
}
