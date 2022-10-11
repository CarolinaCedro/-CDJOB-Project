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

import java.util.List;

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
    public ResponseEntity findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid VacancyDto vacancyDto) {
        List<Requiriments> requiriments = requirimentsRepository.findAllByIdIn(vacancyDto.getRequiriments());
        List<Responsibilitys> responsibilitys = responsibilitysRepository.findAllByIdIn(vacancyDto.getResponsibility());

        Vacancy vacancy =
                new Vacancy(vacancyDto.getTitleVacancy(),
                        vacancyDto.getDescription(),
                        vacancyDto.getStatus(),
                        responsibilitys,
                        requiriments);

        return ResponseEntity.ok(VacancyDto.of(service.save(vacancy)));
 }
//    private URI getUri(Long id) {
//        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(id).toUri();
//    }
}
