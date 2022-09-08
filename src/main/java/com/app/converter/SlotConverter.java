package com.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.app.dto.SlotDTO;
import com.app.entity.Slot;

@Component
public class SlotConverter {
    public SlotDTO convertEntityToDto(Slot slot){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(slot, SlotDTO.class);
    }

    public Slot convertDtoToEntity(SlotDTO slotDTO){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(slotDTO, Slot.class);
    }
}
