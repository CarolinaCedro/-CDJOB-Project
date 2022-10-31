package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.dto.AdminDTO;
import io.github.carolinacedro.cdjobproject.infra.entities.Adm;
import io.github.carolinacedro.cdjobproject.infra.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<AdminDTO> getAdmin() {
        return repository.findAll().stream().map(AdminDTO::create).collect(Collectors.toList());
    }

    public Optional<AdminDTO> findById(Long id) {
        return repository.findById(id).map(AdminDTO::create);
    }

    public AdminDTO save(Adm adm) {
        return AdminDTO.create(adm);
    }


    public AdminDTO update(Long id, Adm adm) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Adm> optional = repository.findById(id);
        if (optional.isPresent()) {
            Adm db = optional.get();
            db.setEmail(adm.getEmail());
            db.setName(adm.getName());
            db.setPassword(adm.getPassword());

            repository.save(db);
            return AdminDTO.create(db);
        }

        return null;

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
