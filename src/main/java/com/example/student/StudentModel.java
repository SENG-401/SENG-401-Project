package com.example.student;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import com.example.login.LoginUser;

@Entity
@Table(name = "student")
public class StudentModel extends LoginUser {
    @OneToOne
    @JoinColumn(name = "user_id")
    private LoginUser user;

    @ElementCollection
    private List<String> whatHelp = new ArrayList<>(); // Initialize the list

    public StudentModel() {
    }

    public Long getId() {
        return super.getId();
    }

    public void setId(Long studentId) {
        super.setId(studentId);
    }

    public List<String> getHelpList() {
        return whatHelp;
    }

    public void setHelpList(List<String> subjectList) {
        this.whatHelp.clear(); // Clear the existing list before adding new elements
        if (subjectList != null) {
            this.whatHelp.addAll(subjectList);
        }
    }

    public void addHelp(String subject) {
        this.whatHelp.add(subject);
    }

    public void removeHelps(List<String> remove) {
        this.whatHelp.removeAll(remove);
    }

    public void removeHelp(String remove) {
        this.whatHelp.remove(remove);
    }
}
