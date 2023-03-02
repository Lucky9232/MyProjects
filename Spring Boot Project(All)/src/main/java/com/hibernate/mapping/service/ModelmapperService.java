package com.hibernate.mapping.service;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ModelmapperService {

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
