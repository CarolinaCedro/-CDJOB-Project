package io.github.carolinacedro.cdjobproject.infra.dto;

import io.github.carolinacedro.cdjobproject.infra.entities.Responsibilitys;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsabilitysDto {
    private String description;
    private Long id;

    public static ResponsabilitysDto of(Responsibilitys responsibilitys){
        return ResponsabilitysDto.builder()
                .description(responsibilitys.getDescription())
                .id(responsibilitys.getId())
                .build();
    }

    public static List<ResponsabilitysDto> listOf(List<Responsibilitys> responsibilitys){
        List<ResponsabilitysDto> dtosList = new ArrayList<>();
        responsibilitys.forEach(x -> {
            dtosList.add(ResponsabilitysDto.of(x));
        });
        return dtosList;
    }
}
