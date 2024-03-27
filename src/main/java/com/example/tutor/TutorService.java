package com.example.tutor;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Service;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public Optional<TutorModel> getTutorInfo(Long id) {
        return tutorRepository.findById(id);
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