package io.github.carolinacedro.cdjobproject.config;

import io.github.carolinacedro.cdjobproject.infra.dto.CandidateDto;
import io.github.carolinacedro.cdjobproject.infra.dto.VacancyDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

//        modelMapper.createTypeMap(CandidateDto.class, VacancyDto.class)
//                .addMapping(CandidateDto::getVacancy,
//                        (dest,value) -> dest.setVacancy(dest.getVacancy()));


        return modelMapper;
    }
}
