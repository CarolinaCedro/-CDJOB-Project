package io.github.carolinacedro.cdjobproject.api;

import io.github.carolinacedro.cdjobproject.infra.dto.AdminDTO;
import io.github.carolinacedro.cdjobproject.infra.entities.Adm;
import io.github.carolinacedro.cdjobproject.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AdminDTO>> findAll() {
        return ResponseEntity.ok(service.getAdmin());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Optional<AdminDTO> adm = service.findById(id);
        return adm.isPresent() ? ResponseEntity.ok(adm) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity save(@RequestBody AdminDTO adminDTO) {
        AdminDTO adm = new AdminDTO(adminDTO.getName(), adminDTO.getEmail(), adminDTO.getPassword());
        return ResponseEntity.ok(service.save(adm));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Adm adm) {
        adm.setId(id);

        AdminDTO adm1 = service.update(id, adm);

        return adm1 != null ? ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
