package com.app.service;

import com.app.entity.User;

public interface UserService {

    public User createUser(User userData);
    
    public User loginUser(User userData);

    public User getUserByEmailId(String userEmailId);

    public User getUserById(int userId);
}
