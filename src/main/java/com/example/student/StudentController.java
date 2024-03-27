package com.example.student;

import com.example.tutor.TutorService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public StudentModel getStudentInfo(@RequestParam Long id) {
        Optional<StudentModel> student = studentService.getStudentInfo(id);
        if (student.isPresent()) {
            return student.get();
        }
        else{
            throw new IllegalStateException("Student not found");
        }
    }
}
