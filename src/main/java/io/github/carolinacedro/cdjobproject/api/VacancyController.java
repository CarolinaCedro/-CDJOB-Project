package io.github.carolinacedro.cdjobproject.api;

import io.github.carolinacedro.cdjobproject.infra.dto.CandidateDto;
import io.github.carolinacedro.cdjobproject.infra.dto.VacancyDto;
import io.github.carolinacedro.cdjobproject.infra.entities.Candidate;
import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import io.github.carolinacedro.cdjobproject.enums.Status;
import io.github.carolinacedro.cdjobproject.infra.repository.RequirimentsRepository;
import io.github.carolinacedro.cdjobproject.service.VacancyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/vacancys")
@AllArgsConstructor
public class VacancyController {


    private final VacancyService service;
    private final RequirimentsRepository requirimentsRepository;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity changeStatus(@PathVariable Long id,@RequestBody Vacancy vacancy){
        vacancy.setId(id);
        Vacancy c = service.update(vacancy, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity getByStatus (@PathVariable("status") Status status) {
        List<Vacancy> vacancies = service.getVacancieByStatus(status);
        return vacancies.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(vacancies);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid VacancyDto vacancyDto) {

        List<Requiriments> requiriments = requirimentsRepository.findAllById(vacancyDto.getRequiriments());
        Vacancy vacancy =
                new Vacancy(
                        vacancyDto.getTitleVacancy(),
                        vacancyDto.getDescription(),
                        vacancyDto.getStatus(),
                        vacancyDto.getResponsibility(),
                        requiriments);
        return ResponseEntity.ok(service.save(vacancy));
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
