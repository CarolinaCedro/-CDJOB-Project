package io.github.carolinacedro.cdjobproject.infra.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDto {

    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    @Size(max = 30)
    private String phone;
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;
    @NotBlank
    @Size(max = 50)
    private String state;
    @NotBlank
    @Size(max = 255)
    private String note;

    private Long vacancy;
    private Long joinVacancy;
}