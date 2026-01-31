package com.brainmentors.springmvcjdbc.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.brainmentors.springmvcjdbc.models.User;


public interface UserRepository extends CrudRepository<User,Long>{
    //register user
    boolean existsByEmail(String email);
    //login
    Optional<User> findByEmail(String email);

    
    

}
