package io.github.carolinacedro.cdjobproject.infra.dto;

import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import io.github.carolinacedro.cdjobproject.infra.entities.Vacancy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.modelmapper.ModelMapper;

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
    private String status;
    private String responsibility;
    private static List<Requiriments> requiriments = new ArrayList<>();

//    private Long vacancy;

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

    public static List<Requiriments> getRequirements(List<RequirementsDto> dto){


        dto.forEach(res -> {

            Requiriments requirimentsConvert = Requiriments.builder()
                    .description(res.getDescription())
                    .build();

            requiriments.add(requirimentsConvert);
        });
        return requiriments;
    }

}
