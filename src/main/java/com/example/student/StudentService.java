package com.example.student;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.login.LoginRepository;
import com.example.login.LoginUser;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final LoginRepository loginRepository;

    public StudentService(StudentRepository studentRepository, LoginRepository loginRepository) {
        this.studentRepository = studentRepository;
        this.loginRepository = loginRepository;
    }

    public Optional<StudentModel> getStudentInfo(Long id) {
        return studentRepository.findById(id);
    }

    public String addStudent(String entity) {
        // TODO Auto-generated method stub
        return new String("Student added");
    }

    public String deleteStudent(String param) {
        // TODO Auto-generated method stub
        return new String("Student deleted");
    }

    public Optional<StudentModel> updateStudentInfo(StudentModel newInfo) {
        Optional<LoginUser> user = loginRepository.findUserByEmail(newInfo.getEmail());
        if (user.isPresent() && user.get().isStudent()) {

            StudentModel model = new StudentModel();
            model.setId(user.get().getId());

            if (user.get().getFirstName() != null) {
                model.setFirstName(user.get().getFirstName());
            }
            if (user.get().getLastName() != null) {
                model.setLastName(user.get().getLastName());
            }
            if (user.get().isStudent() != null) {
                model.setIsStudent(user.get().isStudent().toString());
            }
            if (user.get().isTutor() != null) {
                model.setIsTutor(user.get().isTutor().toString());
            }

            if (user.get().getProfileComplete() != null) {
                model.setProfileComplete(user.get().getProfileComplete());
            }
            if (user.get().getPassword() != null) {
                model.setPassword(user.get().getPassword());
            }


            if (newInfo.getEmail() != null) {
                model.setEmail(newInfo.getEmail());
            }
            
            if (newInfo.getHelpList() != null) {
                model.setHelpList(newInfo.getHelpList());
            }
            studentRepository.save(model);
            return Optional.of(newInfo);
        }
        else{
            return Optional.empty();
        }

    }

}