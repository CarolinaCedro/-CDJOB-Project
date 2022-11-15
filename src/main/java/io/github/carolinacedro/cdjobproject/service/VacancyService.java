package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.dto.VacancyDto;
import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import io.github.carolinacedro.cdjobproject.enums.Status;
import io.github.carolinacedro.cdjobproject.infra.repository.VacancyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    public List<Vacancy> findAll() {
        return repository.findByStatus(Status.Ativo);
//        return repository.findAll().stream().map(this::vacancyDto).collect(Collectors.toList());
    }

    public Optional findById(Long id) {
        return repository.findById(id);
    }

    public Vacancy save(Vacancy vacancy) {
        return repository.save(vacancy);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private VacancyDto vacancyDto(Vacancy vacancy) {
        return modelMapper.map(vacancy, VacancyDto.class);
    }
    public List<Vacancy> getVacancieByStatus(Status status) {
        return repository.findByStatus(status);
    }

    public Vacancy update(Vacancy vacancy, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Vacancy> optional = repository.findById(id);
        if (optional.isPresent()) {
            Vacancy db = optional.get();
            db.setStatus(vacancy.getStatus());
            repository.save(db);
            return db;
        }
        return null;
    }
}
