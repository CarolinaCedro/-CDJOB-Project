package io.github.carolinacedro.cdjobproject.infra.dto;

import io.github.carolinacedro.cdjobproject.infra.entities.Adm;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    public AdminDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
