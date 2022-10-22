package io.github.carolinacedro.cdjobproject.api;

import io.github.carolinacedro.cdjobproject.infra.dto.RequirementsDto;
import io.github.carolinacedro.cdjobproject.infra.dto.RequirimentsPost;
import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import io.github.carolinacedro.cdjobproject.infra.repository.RequirimentsRepository;
import io.github.carolinacedro.cdjobproject.service.RequirimentsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("requiriments")
public class RequirimentsController {

    @Autowired
    private RequirimentsService service;

    @Autowired
    private RequirimentsRepository RequirimentsRepository;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity createPost(@RequestBody @Valid Requiriments requiriments) {
        return ResponseEntity.ok(service.save(requiriments));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
