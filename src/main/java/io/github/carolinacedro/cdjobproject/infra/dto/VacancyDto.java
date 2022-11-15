package io.github.carolinacedro.cdjobproject.infra.dto;

import io.github.carolinacedro.cdjobproject.enums.Status;
import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyDto {

    private Long id;
    private String titleVacancy;
    private String description;
    private Status status;
    private String responsibility;
    public List<Long> requiriments;

    public static VacancyDto of(Vacancy vacancy) {
        return VacancyDto.builder()
                .titleVacancy(vacancy.getTitleVacancy())
                .description(vacancy.getDescription())
                .status(vacancy.getStatus())
                .responsibility(vacancy.getResponsibility())
                .requiriments(getRequirimentesIds(RequirementsDto.of(vacancy.getRequiriments())))
                .build();
    }




    private static List<Long> getRequirimentesIds(List<RequirementsDto> dto) {
        List<Long> ids = new ArrayList<>();
        dto.forEach(x -> {
            ids.add(x.getId());
        });
        return ids;

    }
}


