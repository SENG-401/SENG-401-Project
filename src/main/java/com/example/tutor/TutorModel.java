package com.example.tutor;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import com.example.login.LoginUser;

@Entity
@Table(name = "tutor")
public class TutorModel extends LoginUser {
    @OneToOne
    @JoinColumn(name = "user_id")
    private LoginUser user;

    @ElementCollection
    private List<String> ableToTeach = new ArrayList<>(); // Initialize the list

    @ElementCollection
    private List<String> socialMedia = new ArrayList<>(); // Initialize the list

    @Transient
    private int userRating;

    private int ratingCount;

    private int totalStarts;

    private String bio;

    public TutorModel() {
    }

    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }

    public List<String> getAbleToTeach() {
        return ableToTeach;
    }

    public void setAbleToTeach(List<String> ableToTeach) {
        this.ableToTeach.clear(); // Clear the existing list before adding new elements
        if (ableToTeach != null) {
            this.ableToTeach.addAll(ableToTeach);
        }
    }

    public void addSubject(String subject){ 
        this.ableToTeach.add(subject);
    }

    public void removeSubjects(List<String> remove){
         this.ableToTeach.removeAll(remove);
    }

    public void removeSubject(String remove){
        this.ableToTeach.remove(remove);
    }

    public void setUserRating() {
        this.userRating = totalStarts / ratingCount;
    }

    public int getUserRating() {
        return userRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount() {
        this.ratingCount++;
    }

    public int getTotalStarts() {
        return totalStarts;
    }

    public void setTotalStarts(int totalStarts) {
        this.totalStarts = totalStarts;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}