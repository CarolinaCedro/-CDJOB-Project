package io.github.carolinacedro.cdjobproject.api;

import io.github.carolinacedro.cdjobproject.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacancys")
public class VacancyController {

    @Autowired
    private VacancyService service;


    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


}
