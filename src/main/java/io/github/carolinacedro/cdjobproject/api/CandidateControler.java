package io.github.carolinacedro.cdjobproject.api;

import io.github.carolinacedro.cdjobproject.infra.entities.Candidate;
import io.github.carolinacedro.cdjobproject.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/candidates")
public class CandidateControler {

    @Autowired
    private CandidateService service;


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
    public ResponseEntity save(@RequestBody Candidate candidate) {
        Candidate candidate1 = service.save(candidate);
        URI location = getUri(candidate1.getId());
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Candidate candidate) {
        candidate.setId(id);

        Candidate UpdateCandidate = service.update(candidate, id);
        return UpdateCandidate != null ?
                ResponseEntity.ok(UpdateCandidate) :
                ResponseEntity.notFound().build();

    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
