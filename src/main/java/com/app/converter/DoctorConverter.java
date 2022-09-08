package com.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.app.dto.DoctorDTO;
import com.app.entity.Doctor;

@Component
public class DoctorConverter {
    public DoctorDTO convertEntityToDto(Doctor doctor){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    public Doctor convertDtoToEntity(DoctorDTO doctorDTO){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(doctorDTO, Doctor.class);
    }
}
