package io.github.carolinacedro.cdjobproject.infra.dto;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyResponseDTO {
    private String titleVacancy;
    private String description;
    private String status;
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ResponsabilitysDto> responsibility;
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<RequirementsDto> requiriments;
}
