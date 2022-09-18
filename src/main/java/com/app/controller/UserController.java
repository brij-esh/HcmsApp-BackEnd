package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.converter.UserConverter;
import com.app.dto.UserDTO;
import com.app.entity.User;
import com.app.service.UserService;

import lombok.extern.log4j.Log4j2;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
@Log4j2
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> userSignup(@RequestBody UserDTO userDTO){
        UserDTO user = this.userService.createUser(userDTO);
        return ResponseEntity.ok(user);
    }

    // @PostMapping("/login")
    // public ResponseEntity<UserDTO> userLogin(@RequestBody UserDTO userDTO){
    //     log.error(userDTO);
    //     UserDTO user = this.userService.loginUser(userDTO);
    //     return ResponseEntity.ok(user);
    // }

    @PostMapping("/login")
	public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO userDTO){
		User user = this.userService.getUserByEmailId(userDTO.getUserEmailId());
		if(user.getPassword().equals(userDTO.getPassword())) {
			UserDTO userDTO2 = this.userConverter.convertEntityToDto(user);
			return new ResponseEntity<>(userDTO2,HttpStatus.OK);
		}
		UserDTO userDTO2 = this.userConverter.convertEntityToDto(user);
		return new ResponseEntity<>(userDTO2, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

    @GetMapping("/get-user/{userEmailIdData}")
    public ResponseEntity<User> getUserByEmailId(@PathVariable String userEmailIdData){
        log.error(userEmailIdData + "controller");
        User user = this.userService.getUserByEmailId(userEmailIdData);
        return ResponseEntity.ok(user);
    }

    @GetMapping("get-user-by-id/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        User user = this.userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
