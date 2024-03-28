package com.example.tutor;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Service;

import com.example.login.LoginRepository;
import com.example.login.LoginUser;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;
    private final LoginRepository loginRepository;

    public TutorService(TutorRepository tutorRepository, LoginRepository loginRepository) {
        this.tutorRepository = tutorRepository;
        this.loginRepository = loginRepository;
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

    public Optional<TutorModel> updateTutorInfo(TutorModel newInfo) {
        Optional<LoginUser> user = loginRepository.findUserByEmail(newInfo.getEmail());
        if (user.isPresent() && user.get().isTutor()) {

            TutorModel model = new TutorModel();
            if (user.get().getFirstName() != null) {
                model.setFirstName(user.get().getFirstName());
            }
            if (user.get().getLastName() != null) {
                model.setLastName(user.get().getLastName());
            }
            if (user.get().isStudent() != null) {
                model.setIsStudent(user.get().isStudent().toString());
            }
            if (user.get().isTutor() != null) {
                model.setIsTutor(user.get().isTutor().toString());
            }
            if (user.get().getProfileComplete() != null) {
                model.setProfileComplete(user.get().getProfileComplete());
            }
            if (user.get().getPassword() != null) {
                model.setPassword(user.get().getPassword());
            }

            if (newInfo.getBio() != null) {
                model.setBio(newInfo.getBio());
            }

            if (newInfo.getEmail() != null) {
                model.setEmail(newInfo.getEmail());
            }

            if (newInfo.getAbleToTeach() != null) {
                model.setAbleToTeach(newInfo.getAbleToTeach());
            }
            tutorRepository.save(model);
            return Optional.of(newInfo);
        }
        else{
            return Optional.empty();
        }
    }

}