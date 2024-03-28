package com.example.tutor;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import javax.swing.text.html.Option;

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
@RequestMapping("api/v1/tutor")
class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public TutorModel getTutorInfo(@RequestParam Long id) {
        Optional<TutorModel> tutor = tutorService.getTutorInfo(id);
        if (tutor.isPresent()) {
            return tutor.get();
        }
        else{
            throw new IllegalStateException("Tutor not found");
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<String> updateTutorInfo(@RequestBody TutorModel newInfo) {
        TutorModel model = tutorService.updateTutorInfo(newInfo);
        if (model != null) {
            return ResponseEntity.ok("Tutor updated");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tutor does not exist");
        }
        
        
    }
}