package io.github.carolinacedro.cdjobproject.api;

import io.github.carolinacedro.cdjobproject.infra.dto.ResponsabilitysDto;
import io.github.carolinacedro.cdjobproject.service.ResponsabilitiesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responsability")
public class ResponsabilitysController {

    @Autowired
    private ResponsabilitiesServices service;

    @GetMapping
    ResponseEntity<?>findAll(){return ResponseEntity.ok(service.findAll());}

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping()
    ResponseEntity<?> save(@RequestBody ResponsabilitysDto dto){
        return ResponseEntity.ok(service.save(dto));
    }
}
