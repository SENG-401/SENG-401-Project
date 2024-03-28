package com.example.student;

import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
@Table
public class StudentModel {
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
    private Long studentId;
    @ElementCollection
    private ArrayList<String> subjectList;


    public StudentModel(Long id,  ArrayList<String> subjectList) {
        this.studentId = id;
        this.subjectList = new ArrayList<String>();
        this.subjectList.addAll(subjectList);

    }

    public Long getId() {
        return studentId;
    }

    public void setId(Long studentId) {
        this.studentId = studentId;
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }
    public void setSubjectList(ArrayList<String> subjectList) {this.subjectList.addAll(subjectList);}

    public void addSubject(String subject){ this.subjectList.add(subject);  }

    public void removeSubjects(ArrayList<String> remove){ this.subjectList.removeAll(remove);}

    public void removeSubject(String remove){ this.subjectList.remove(remove);}
}