package com.example.login;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.student.StudentModel;
import com.example.student.StudentRepository;
import com.example.tutor.TutorModel;
import com.example.tutor.TutorRepository;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    private final TutorRepository tutorRepository;
    private final StudentRepository studentRepository;

    public LoginService(LoginRepository loginRepository, StudentRepository studentRepository, TutorRepository tutorRepository) {
        this.loginRepository = loginRepository;
        this.tutorRepository = tutorRepository;
        this.studentRepository = studentRepository;
    }

    public Optional<LoginUser> loginUser(LoginUser user) {
        Optional<LoginUser> userOptional = loginRepository.findUserByEmail(user.getEmail());
        return userOptional;
    }

    public Optional<LoginUser> getUserInfo(String email) {
        Optional<LoginUser> user = loginRepository.findUserByEmail(email);
        if (user.isPresent()){
            if (user.get().isTutor()){
                Optional<TutorModel> tutor = tutorRepository.findById(user.get().getId());
                return Optional.of(tutor.get());
            }
            else if (user.get().isStudent()){
                Optional<StudentModel> student = studentRepository.findById(user.get().getId());
                return Optional.of(student.get());
            }
            else{
                throw new IllegalStateException("User type not specified");
            }
        }
        else{
            return Optional.empty();
        }
    }
}
