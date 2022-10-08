package io.github.carolinacedro.cdjobproject.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinVacancy {
    private Long id;
    private Candidate candidate;
    private Vacancy vacancy;
}
