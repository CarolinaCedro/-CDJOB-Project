package io.github.carolinacedro.cdjobproject.infra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.carolinacedro.cdjobproject.infra.dto.RequirementsDto;
import io.github.carolinacedro.cdjobproject.infra.dto.ResponsabilitysDto;
import io.github.carolinacedro.cdjobproject.infra.dto.VacancyDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Requiriments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany
    private static List<Requiriments> requiriments = new ArrayList<>();


    public static List<Requiriments> of(List<RequirementsDto> requirementsDto) {
        requirementsDto.forEach(res -> {

            Requiriments requirimentsConvert = Requiriments.builder()
                    .description(res.getDescription())
                    .build();

            requiriments.add(requirimentsConvert);
        });
        return requiriments;
    }

    public Requiriments(String description) {
        this.description = description;
    }
}
