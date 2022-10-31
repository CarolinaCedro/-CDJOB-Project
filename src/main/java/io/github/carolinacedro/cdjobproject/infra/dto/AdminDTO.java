package io.github.carolinacedro.cdjobproject.infra.dto;

import io.github.carolinacedro.cdjobproject.infra.entities.Adm;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.modelmapper.ModelMapper;

@Data
public class AdminDTO {

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    public static AdminDTO create(Adm adm) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(adm, AdminDTO.class);
    }
}
