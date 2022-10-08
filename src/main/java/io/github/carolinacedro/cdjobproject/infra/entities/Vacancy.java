package io.github.carolinacedro.cdjobproject.infra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.carolinacedro.cdjobproject.infra.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleVacancy;
    private String description;
    private Status status;


    @ManyToMany
    @JoinTable(name = "vacancy_has_candidate", joinColumns =
            {@JoinColumn(name = "vacancy_id")}, inverseJoinColumns =
            {@JoinColumn(name = "candidate_id")})
    private List<Candidate> candidates = new ArrayList<>();


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsibilitys_id", nullable = false)
    private Responsibilitys responsibility;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requiriments_id", nullable = false)
    private Requiriments requiriments;

    @OneToMany
    private List<Vacancy> vacancyList = new ArrayList<>();

    @ManyToOne
    private JoinVacancy joinVacancy;

    public Vacancy(String titleVacancy, String description, Status status, List<Candidate> candidates, Responsibilitys responsibility, Requiriments requiriments, List<Vacancy> vacancyList) {
        this.titleVacancy = titleVacancy;
        this.description = description;
        this.status = status;
        this.candidates = candidates;
        this.responsibility = responsibility;
        this.requiriments = requiriments;
        this.vacancyList = vacancyList;
    }
}
