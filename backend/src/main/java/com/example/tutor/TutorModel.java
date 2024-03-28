package com.example.tutor;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table
public class TutorModel {
    @Id
    @SequenceGenerator(
        name = "tutor_sequence",
        sequenceName = "tutor_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "tutor_sequence"
    )
    private Long tutorId;

    @ElementCollection
    private ArrayList<String> ableToTeach;
    private int trainingMetric;
    private int userRating;
    private String bio;

    public TutorModel(Long tutorId, ArrayList<String> ableToTeach,
                      int trainingMetric, int userRating, String bio) {
        this.tutorId = tutorId;
        this.ableToTeach=new ArrayList<String>();
        this.trainingMetric=trainingMetric;
        this.userRating=userRating;
        this.bio=bio;
        this.ableToTeach.addAll(ableToTeach);

    }

    public Long getId() {
        return tutorId;
    }

    public void setId(Long id) {
        this.tutorId = id;
    }

    public ArrayList<String> getAbleToTeach(){return ableToTeach;}
    public void setAbleToTeach(ArrayList<String> list){ this.ableToTeach.addAll(list);}
    public void addSubject(String subject){ this.ableToTeach.add(subject);  }

    public void removeSubjects(ArrayList<String> remove){ this.ableToTeach.removeAll(remove);}

    public void removeSubject(String remove){ this.ableToTeach.remove(remove);}
}