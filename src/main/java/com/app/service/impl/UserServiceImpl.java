package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repo.UserRepo;
import com.app.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User userData) {
        return this.userRepo.save(userData);
    }

    @Override
    public User loginUser(User userData) {
       User user = this.userRepo.findByUserEmailId(userData.getUserEmailId());
       if(user.getPassword().equals(userData.getPassword())){
        return user;
       }else{
           return null;
       }
    }

    @Override
    public User getUserByEmailId(String userEmailId){
        User user =  this.userRepo.findByUserEmailId(userEmailId);
        System.out.println(user);
        log.error(user);
        return user;
    }

    @Override
    public User getUserById(int userId){
        return this.userRepo.findById(userId);
    }


    
}
