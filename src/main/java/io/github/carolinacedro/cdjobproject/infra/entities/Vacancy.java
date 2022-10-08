package io.github.carolinacedro.cdjobproject.infra.entities;

import io.github.carolinacedro.cdjobproject.infra.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {

    private Long id;
    private String titleVacancy;
    private String description;
    private String responsibility;
    private String requiriments;
    private Status status;
}
