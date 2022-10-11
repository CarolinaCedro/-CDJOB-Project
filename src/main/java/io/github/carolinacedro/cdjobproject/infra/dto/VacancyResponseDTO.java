package io.github.carolinacedro.cdjobproject.infra.dto;

import lombok.*;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyResponseDTO {
    private String titleVacancy;
    private String description;
    private String status;
    private List<ResponsabilitysDto> responsibility;
    private List<RequirementsDto> requiriments;
}
