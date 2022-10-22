package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import io.github.carolinacedro.cdjobproject.infra.repository.RequirimentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirimentsService {

    @Autowired
    private RequirimentsRepository repository;

    public List<Requiriments> findAll() {
        return repository.findAll();
    }


    public void findById(Long id){
        repository.findById(id);
    }


    public Requiriments save(Requiriments requiriments) {
        return repository.save(requiriments);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
