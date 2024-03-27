package com.example.login;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "loginuser")
public class LoginUser {
    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    @Column(name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isTutor;
    private Boolean isStudent;

    public LoginUser(){

    }

    public LoginUser(String firstName, String lastName, String email, String password, Boolean isTutor, Boolean isStudent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isTutor = isTutor;
        this.isStudent = isStudent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isTutor() {
        return isTutor;
    }

    public void setIsTutor(String isTutor) {
        this.isTutor = Boolean.parseBoolean(isTutor);
    }

    public Boolean isStudent() {
        return isStudent;
    }

    public void setIsStudent(String isStudent) {
        this.isStudent = Boolean.parseBoolean(isStudent);
    }
}
