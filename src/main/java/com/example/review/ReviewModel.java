package com.example.review;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "review")
public class ReviewModel {
    @Id
    @SequenceGenerator(
        name = "review_sequence",
        sequenceName = "review_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "review_sequence"
    )
    private Long reviewId;

    @Column(name = "tutor_id")
    private Long tutorId;

    int score;
    String comment;
    String subject;

    public ReviewModel() {
    }

    public Long getId() {
        return reviewId;
    }

    public void setId(Long id) {
        this.reviewId = id;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long id) {
        this.tutorId = id;
    }

    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment=comment;
    }

    int getScore(){
        return score;
    }

    void setScore(int score){
        this.score=score;
    }

    public String getSubject(){
        return this.subject;
    }

    void setSubject(String subject){
        this.subject=subject;
    }
}