package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import io.github.carolinacedro.cdjobproject.infra.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository repository;


    public List<Vacancy> findAll() {
        return repository.findAll();
    }

    public Optional findById(Long id) {
        return repository.findById(id);
    }

    public Vacancy save(Vacancy vacancy) {
        return repository.save(vacancy);
    }
}
