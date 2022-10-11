package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import io.github.carolinacedro.cdjobproject.infra.repository.RequirimentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequirimentsService {

    @Autowired
    private RequirimentsRepository repository;

    public void save(Requiriments entity){
        repository.save(entity);
    }

    public void findById(Long id){
        repository.findById(id);
    }
}
