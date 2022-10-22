package io.github.carolinacedro.cdjobproject.api;

import io.github.carolinacedro.cdjobproject.infra.dto.CandidateDto;
import io.github.carolinacedro.cdjobproject.infra.entities.Candidate;
import io.github.carolinacedro.cdjobproject.infra.entities.JoinVacancy;
import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import io.github.carolinacedro.cdjobproject.infra.repository.JoinVacancyRepository;
import io.github.carolinacedro.cdjobproject.infra.repository.VacancyRepository;
import io.github.carolinacedro.cdjobproject.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService service;

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private JoinVacancyRepository joinVacancyRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Optional<Candidate> candidate = service.findById(id);
        return ResponseEntity.ok(candidate);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid CandidateDto candidateDto) {

        Optional<Vacancy> vacancys = vacancyRepository.findById(candidateDto.getVacancy());
//        List<Vacancy> vacancyList = List.of(vacancys.get());

        Candidate candidate = new Candidate(
                candidateDto.getName(), candidateDto.getEmail(), candidateDto.getPhone(), candidateDto.getNote(),
                candidateDto.getState(), vacancys.get());

        Candidate save = service.save(candidate);
        URI location = getUri(candidate.getId());
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid Candidate candidate) {
        candidate.setId(id);
        Candidate c = service.update(candidate, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Candidate> candidate = service.findById(id);
        if (candidate.isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
