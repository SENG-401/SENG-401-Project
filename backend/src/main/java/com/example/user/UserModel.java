package com.example.user;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table
public class UserModel {
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
    private Long userId;

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    
    private boolean isTutor;
    private boolean isStudent;
    private String displayName;

    public UserModel(Long userId, String firstName, String lastName,
                     String email, String username, String password,
                     String displayName, boolean isStudent, boolean isTutor) {
        this.userId = userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.username=username;
        this.password=password;
        this.displayName=displayName;
        this.isStudent=isStudent;
        this.isTutor=isTutor;
        

    }

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public  String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName=firstName;}

    public  String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName=lastName;}

    public  String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public  String getUsername(){return username;}
    public void setUsername(String username){this.username=username;}

    public  String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public  String getDisplayName(){return displayName;}
    public void setDisplayName(String displayName){this.displayName=displayName;}

    public  boolean getIsTutor(){return isTutor;}
    public void setIsTutor(boolean isTutor){this.isTutor=isTutor;}

    public  boolean getIsStudent(){return isStudent;}
    public void setIsStudent(boolean isStudent){this.isStudent=isStudent;}
    
    
    
    
    
}