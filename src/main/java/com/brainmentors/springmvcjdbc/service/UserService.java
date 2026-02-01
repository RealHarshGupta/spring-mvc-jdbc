package com.brainmentors.springmvcjdbc.service;

import java.util.ArrayList;
import java.util.List;
// import org.apache.el.stream.Optional;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.brainmentors.springmvcjdbc.models.User;
import com.brainmentors.springmvcjdbc.repo.UserRepository;


@Service
public class UserService {
    //doing di
    //constructor injection
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        //constructor injection
        this.userRepository = userRepository;

    }

    public String register (User user){

       boolean isExist= userRepository.existsByEmail(user.getEmail());
       if(isExist){
        return "user already exist can't resgister";
       }
       userRepository.save(user);
       return "user register succefully";
    }

    public String login(User user){
        Optional<User> opt = userRepository.findByEmail((user.getEmail()));
        // System.out.print(user.getEmail()+"error");
        if(opt.isEmpty()){
            return "invalid email or password.....";
            
        }
        User dbUser = opt.get();

        if(dbUser.getPassword().equals(user.getPassword())){
            return "wecome "+dbUser.getName();
        }else{
            return "invalid email or password";
        }

    }

    public List<User> getAllUsers(){
        List <User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;

        
    }
}
