package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.UserService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> userSignup(@RequestBody User userData){
        User user = this.userService.createUser(userData);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody User userData){
        System.out.println(userData);
        User user = this.userService.loginUser(userData);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get-user/{userEmailIdData}")
    public ResponseEntity<User> getUserByEmailId(@PathVariable String userEmailIdData){
        System.out.println(userEmailIdData + "controller");
        User user = this.userService.getUserByEmailId(userEmailIdData);
        return ResponseEntity.ok(user);
    }

    @GetMapping("get-user-by-id/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId){
        User user = this.userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
