package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.converter.UserConverter;
import com.app.dto.UserDTO;
import com.app.entity.User;
import com.app.repo.UserRepo;
import com.app.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return this.userConverter.convertEntityToDto(this.userRepo.save(this.userConverter.convertDtoToEntity(userDTO)));
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) {
       User user = this.userRepo.findByUserEmailId(userDTO.getUserEmailId());
       if(user.getPassword().equals(userDTO.getPassword())){
        return this.userConverter.convertEntityToDto(user);
       }else{
           return null;
       }
    }

    @Override
    public User getUserByEmailId(String userEmailId){
        User user =  this.userRepo.findByUserEmailId(userEmailId);
        log.error(user);
        return user;
    }

    @Override
    public User getUserById(Long userId){
        return this.userRepo.findById(userId);
    }


    
}
