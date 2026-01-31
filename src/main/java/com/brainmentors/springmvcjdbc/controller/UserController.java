package com.brainmentors.springmvcjdbc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.brainmentors.springmvcjdbc.models.User;
import com.brainmentors.springmvcjdbc.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*") //for now global but after deploy IP addres is put here
public class UserController {



    UserService userService = new UserService(null);

    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return new String("welcome spring boot");
    }
    

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){

        String message = userService.login(user);
        return ResponseEntity.status(200).body(message);

    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        String message = userService.register(user);
        return ResponseEntity.status(200).body(message);

    }
    

    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> response = userService.getAllUsers();
        return ResponseEntity.ok().body(response);

    }

    


}
