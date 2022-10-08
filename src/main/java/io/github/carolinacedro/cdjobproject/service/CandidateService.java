package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.entities.Candidate;

import io.github.carolinacedro.cdjobproject.infra.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository repository;
    public List<Candidate> findAll() {
        return repository.findAll();
    }

    public Optional<Candidate> findById(Long id) {
        return repository.findById(id);
    }

    public Candidate save(Candidate candidate) {
        return repository.save(candidate);
    }

    public Candidate update(Candidate candidate, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Candidate> optional = repository.findById(id);
        if (optional.isPresent()) {
            Candidate db = optional.get();
            db.setEmail(candidate.getEmail());
            db.setName(candidate.getName());
            db.setPhone(candidate.getPhone());
            db.setNote(candidate.getNote());
            db.setState(candidate.getState());
            repository.save(db);
            return db;
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
