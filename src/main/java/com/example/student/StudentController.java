package com.example.student;

import com.example.tutor.TutorService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



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

    @PutMapping("/edit")
    public ResponseEntity<String> updateStudentInfo(@RequestBody StudentModel newInfo) {
        Optional<StudentModel> model = studentService.updateStudentInfo(newInfo);
        if (model.isPresent()) {
            return ResponseEntity.ok("Student updated");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Student does not exist");
        }
    }
}
