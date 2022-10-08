package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import io.github.carolinacedro.cdjobproject.infra.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository repository;


    public List<Vacancy> findAll() {
        return repository.findAll();
    }
}
