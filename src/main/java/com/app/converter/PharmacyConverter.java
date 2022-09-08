package com.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.app.dto.PharmacyDTO;
import com.app.entity.Pharmacy;
@Component
public class PharmacyConverter {
    public PharmacyDTO convertEntityToDto(Pharmacy pharmacy){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(pharmacy, PharmacyDTO.class);
    }

    public Pharmacy convertDtoToEntity(PharmacyDTO pharmacyDTO){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(pharmacyDTO, Pharmacy.class);
    }
}
