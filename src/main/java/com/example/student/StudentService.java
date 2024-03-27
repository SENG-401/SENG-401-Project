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

    public StudentModel updateStudentInfo(StudentModel newInfo) {
        Optional<LoginUser> user = loginRepository.findUserByEmail(newInfo.getEmail());
        if (user.isPresent() && user.get().isStudent()) {

            StudentModel model = new StudentModel();
            model.setId(user.get().getId());
            model.setFirstName(user.get().getFirstName());
            model.setLastName(user.get().getLastName());
            
            model.setEmail(newInfo.getEmail());
            model.setPassword(newInfo.getPassword());
            model.setHelpList(newInfo.getHelpList());
            studentRepository.save(model);
            return newInfo;
        }
        else{
            return null;
        }

    }

}