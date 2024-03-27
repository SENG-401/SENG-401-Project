package com.example.register;

import org.springframework.stereotype.Repository;

import com.example.login.LoginUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<LoginUser, Long>{
    
    @Query("SELECT s FROM LoginUser s WHERE s.email = ?1")
    Optional<LoginUser> findUserByEmail(String email);

}
