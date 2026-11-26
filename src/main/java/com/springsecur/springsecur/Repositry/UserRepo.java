package com.springsecur.springsecur.Repositry;

import com.springsecur.springsecur.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
