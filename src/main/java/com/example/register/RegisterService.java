package com.example.register;
import org.springframework.stereotype.Service;

import com.example.login.LoginUser;
import com.example.student.StudentModel;
import com.example.student.StudentRepository;
import com.example.tutor.TutorModel;
import com.example.tutor.TutorRepository;

import java.util.Optional;

@Service
public class RegisterService {
    private final RegisterRepository registerRepository;
    private final TutorRepository tutorRepository;
    private final StudentRepository studentRepository;

    public RegisterService(RegisterRepository registerRepository, StudentRepository studentRepository, TutorRepository tutorRepository) {
        this.registerRepository = registerRepository;
        this.tutorRepository = tutorRepository;
        this.studentRepository = studentRepository;
    }

    public Optional<LoginUser> registerUser(LoginUser user) {
        Optional<LoginUser> userOptional = registerRepository.findUserByEmail(user.getEmail());
        if (userOptional.isEmpty()){
            if (user.isTutor()){
                TutorModel tutor = new TutorModel();
                tutor.setId(user.getId());
                tutor.setFirstName(user.getFirstName());
                tutor.setLastName(user.getLastName());
                tutor.setPassword(user.getPassword());
                tutor.setEmail(user.getEmail());
                tutor.setBio("Hello, I am a tutor");
                tutor.setIsTutor(user.isTutor().toString());
                tutor.setIsStudent(user.isStudent().toString());
                tutorRepository.save(tutor);
            }
            else if (user.isStudent()){
                StudentModel student = new StudentModel();
                student.setId(user.getId());
                student.setFirstName(user.getFirstName());
                student.setLastName(user.getLastName());
                student.setPassword(user.getPassword());
                student.setEmail(user.getEmail());
                student.setIsTutor(user.isTutor().toString());
                student.setIsStudent(user.isStudent().toString());
                studentRepository.save(student);
            }
            else{
                throw new IllegalStateException("User type not specified");
            }
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
