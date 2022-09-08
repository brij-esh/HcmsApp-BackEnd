package com.app.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.app.dto.PaymentDTO;
import com.app.entity.Payment;

@Component
public class PaymentConverter {
    public PaymentDTO convertEntityToDto(Payment payment){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public Payment convertDtoToEntity(PaymentDTO paymentDTO){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(paymentDTO, Payment.class);
    }
}
