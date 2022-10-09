package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.entities.Adm;
import io.github.carolinacedro.cdjobproject.infra.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public List<Adm> findAll() {
        return repository.findAll();
    }

    public Optional<Adm> findById(Long id) {
        return repository.findById(id);
    }

    public Adm save(Adm adm) {
        return repository.save(adm);
    }


    public Adm update(Long id, Adm adm) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Adm> optional = repository.findById(id);
        if (optional.isPresent()){
            Adm db = optional.get();
            db.setEmail(adm.getEmail());
            db.setName(adm.getName());
            db.setPassword(adm.getPassword());

            repository.save(db);
            return db;
        }

        return null;

    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
