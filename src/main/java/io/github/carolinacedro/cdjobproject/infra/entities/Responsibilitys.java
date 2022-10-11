package io.github.carolinacedro.cdjobproject.infra.entities;

import io.github.carolinacedro.cdjobproject.infra.dto.ResponsabilitysDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Responsibilitys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public static List<Responsibilitys> of(List<ResponsabilitysDto> responsabilitysDto) {
        List<Responsibilitys> responsibilitys = new ArrayList<>();
        responsabilitysDto.forEach(res -> {

            Responsibilitys responsibilitysConvert = Responsibilitys.builder()
                    .description(res.getDescription())
                    .build();

            responsibilitys.add(responsibilitysConvert);
        });
        return responsibilitys;
    }
}


