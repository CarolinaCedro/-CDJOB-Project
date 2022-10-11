package io.github.carolinacedro.cdjobproject.infra.dto;

import io.github.carolinacedro.cdjobproject.infra.entities.Responsibilitys;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsabilitysDto {
    private String description;

    public static ResponsabilitysDto of(Responsibilitys responsibilitys){
        return ResponsabilitysDto.builder()
                .description(responsibilitys.getDescription())
                .build();
    }
}
