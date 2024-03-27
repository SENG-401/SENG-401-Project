package com.example.tutor;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TutorRepository extends JpaRepository<TutorModel, Long>{

}