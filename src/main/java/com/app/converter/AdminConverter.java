package com.app.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.app.dto.AdminDTO;
import com.app.entity.Admin;

@Component
public class AdminConverter {
    public AdminDTO convertEntityToDto(Admin admin){
        return new ModelMapper().map(admin, AdminDTO.class);
    }

    public Admin convertDtoToEntity(AdminDTO adminDTO){
        return new ModelMapper().map(adminDTO, Admin.class);
    }
}
