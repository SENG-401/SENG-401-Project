package com.example.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addTutor(String entity) {
        // TODO Auto-generated method stub
        return new String("Tutor added");
    }

    public String deleteTutor(String param) {
        // TODO Auto-generated method stub
        return new String("Tutor deleted");
    }

    public String updateTutor(String id, String entity) {
        // TODO Auto-generated method stub
        return new String("Tutor updated");
    }

}