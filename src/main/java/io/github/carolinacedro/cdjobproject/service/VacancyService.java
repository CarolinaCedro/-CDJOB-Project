package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.dto.AdminDTO;
import io.github.carolinacedro.cdjobproject.infra.dto.VacancyDto;
import io.github.carolinacedro.cdjobproject.infra.entities.Adm;
import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import io.github.carolinacedro.cdjobproject.infra.repository.VacancyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    public List<VacancyDto> findAll() {
        return repository.findAll().stream().map(this::vacancyDto).collect(Collectors.toList());
    }

    public Optional findById(Long id) {
        return repository.findById(id).map(this::vacancyDto);
    }

    public Vacancy save(VacancyDto vacancyDto) {
        return repository.save(modelMapper.map(vacancyDto,Vacancy.class));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private VacancyDto vacancyDto(Vacancy vacancy) {
        return modelMapper.map(vacancy,VacancyDto.class);
    }
}
