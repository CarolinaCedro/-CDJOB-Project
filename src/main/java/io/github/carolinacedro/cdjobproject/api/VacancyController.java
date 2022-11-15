package io.github.carolinacedro.cdjobproject.api;

import io.github.carolinacedro.cdjobproject.infra.dto.RequirementsDto;
import io.github.carolinacedro.cdjobproject.infra.dto.VacancyDto;
import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import io.github.carolinacedro.cdjobproject.infra.repository.RequirimentsRepository;
import io.github.carolinacedro.cdjobproject.infra.repository.ResponsibilitysRepository;
import io.github.carolinacedro.cdjobproject.service.VacancyService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vacancys")
public class VacancyController {

    @Autowired
    private VacancyService service;
    @Autowired
    private RequirimentsRepository requirimentsRepository;
    @Autowired
    private ResponsibilitysRepository responsibilitysRepository;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid VacancyDto vacancyDto) {
        List<Requiriments> requiriments = requirimentsRepository.findAllByIdIn(vacancyDto);
        Vacancy vacancy =
                new Vacancy(vacancyDto.getTitleVacancy(),
                        vacancyDto.getDescription(),
                        vacancyDto.getStatus(),
                        vacancyDto.getResponsibility(),
                        requiriments);
        return ResponseEntity.ok(service.save(modelMapper.map(vacancy,VacancyDto.class)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
