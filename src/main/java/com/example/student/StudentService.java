package com.example.student;


import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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

    public String updateStudent(String id, String entity) {
        // TODO Auto-generated method stub
        return new String("Student updated");
    }

}