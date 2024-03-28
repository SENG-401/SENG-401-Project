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

    public TutorModel updateTutorInfo(TutorModel newInfo) {
        Optional<LoginUser> user = loginRepository.findUserByEmail(newInfo.getEmail());
        if (user.isPresent() && user.get().isTutor()) {

            TutorModel model = new TutorModel();
            model.setId(user.get().getId());
            model.setFirstName(user.get().getFirstName());
            model.setLastName(user.get().getLastName());
            
            model.setEmail(newInfo.getEmail());
            model.setPassword(newInfo.getPassword());
            model.setAbleToTeach(newInfo.getAbleToTeach());
            tutorRepository.save(model);
            return newInfo;
        }
        else{
            return null;
        }
    }

}