package com.app.service;

import com.app.dto.UserDTO;
import com.app.entity.User;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);
    
    public UserDTO loginUser(UserDTO userDTO);

    public User getUserByEmailId(String userEmailId);

    public User getUserById(Long userId);
}
