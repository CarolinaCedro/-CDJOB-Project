package io.github.carolinacedro.cdjobproject.infra.dto;

import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyDto {

    private String titleVacancy;
    private String description;
    private String status;
//    private List<Long> responsibility;
    private String responsibility;
    private List<Long> requiriments;

//    public static VacancyDto of(Vacancy vacancy){
//        return VacancyDto.builder()
//                .titleVacancy(vacancy.getTitleVacancy())
//                .description(vacancy.getDescription())
//                .status(vacancy.getStatus())
//                .description(vacancy.getDescription())
//                .responsibility(vacancy.getResponsibility())
//                .requiriments(getRequirimentesIds(RequirementsDto.of(vacancy.getRequiriments())))
//                .build();
//    }

    public static VacancyDto create(Vacancy vacancy) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vacancy, VacancyDto.class);
    }

    private static List<Long> getRequirimentesIds(List<RequirementsDto> dto){
        List<Long> ids = new ArrayList<>();

        dto.forEach(x -> {
            ids.add(x.getId());
        });
        return ids;
    }

}
