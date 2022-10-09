package io.github.carolinacedro.cdjobproject.api;

import io.github.carolinacedro.cdjobproject.infra.dto.VacancyDto;
import io.github.carolinacedro.cdjobproject.infra.entities.*;
import io.github.carolinacedro.cdjobproject.infra.repository.CandidateRepository;
import io.github.carolinacedro.cdjobproject.infra.repository.JoinVacancyRepository;
import io.github.carolinacedro.cdjobproject.infra.repository.RequirimentsRepository;
import io.github.carolinacedro.cdjobproject.infra.repository.ResponsibilitysRepository;
import io.github.carolinacedro.cdjobproject.service.VacancyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/vacancys")
public class VacancyController {

    @Autowired
    private VacancyService service;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private RequirimentsRepository requirimentsRepository;
    @Autowired
    private ResponsibilitysRepository responsibilitysRepository;
    @Autowired
    private JoinVacancyRepository joinVacancyRepository;


    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid VacancyDto vacancyDto){

        Optional<Responsibilitys> responsibilitys = responsibilitysRepository.findById(vacancyDto.getResponsibility());
        Optional<Requiriments> requiriments = requirimentsRepository.findById(vacancyDto.getRequiriments());


        List<Responsibilitys> responsibilitysList = List.of(responsibilitys.get());
        List<Requiriments> requirimentsList = List.of(requiriments.get());

        Vacancy vacancy = new Vacancy(
                        vacancyDto.getTitleVacancy(), vacancyDto.getDescription(), vacancyDto.getStatus(),
                responsibilitysList, requirimentsList
                );

        Vacancy save = service.save(vacancy);
        URI location = getUri(vacancy.getId());
        return ResponseEntity.created(location).build();


    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

















}
