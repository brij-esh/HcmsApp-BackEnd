package com.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.app.dto.UserDTO;
import com.app.entity.User;

@Component
public class UserConverter {
    public UserDTO convertEntityToDto(User user){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertDtoToEntity(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(userDTO, User.class);
    }
}
