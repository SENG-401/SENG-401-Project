package com.example.tutor;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
}