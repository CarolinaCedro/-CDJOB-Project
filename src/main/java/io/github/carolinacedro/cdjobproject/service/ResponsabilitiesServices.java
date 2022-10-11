package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.exception.DomainException;
import io.github.carolinacedro.cdjobproject.infra.dto.ResponsabilitysDto;
import io.github.carolinacedro.cdjobproject.infra.entities.Responsibilitys;
import io.github.carolinacedro.cdjobproject.infra.repository.ResponsibilitysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ResponsabilitiesServices {
    @Autowired
    private ResponsibilitysRepository responsibilitysRepository;


    public ResponsabilitysDto save(ResponsabilitysDto dto){
        Responsibilitys saved = responsibilitysRepository
                .save(Responsibilitys.of(List.of(dto)).get(0));
        return ResponsabilitysDto.of(saved);
    }


    public ResponsabilitysDto findById(@PathVariable Long id){
        Responsibilitys find = responsibilitysRepository.findById(id)
                .orElseThrow(() -> new DomainException("ID -> "+id+" não encontrado!"));

        return ResponsabilitysDto.of(find);
    }
}
