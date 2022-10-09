package io.github.carolinacedro.cdjobproject.infra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.carolinacedro.cdjobproject.infra.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titlevacancy")
    private String titleVacancy;
    private String description;
    private String status;

//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(name = "vacancy_has_candidate", joinColumns =
//            {@JoinColumn(name = "vacancy_id")}, inverseJoinColumns =
//            {@JoinColumn(name = "candidate_id")})
//    private List<Candidate> candidates = new ArrayList<>();


    @OneToMany
    private List<Responsibilitys> responsibility = new ArrayList<>();

    @OneToMany
    private List<Requiriments> requiriments = new ArrayList<>();

    public Vacancy(String titleVacancy, String description, String status, List<Responsibilitys> responsibility, List<Requiriments> requiriments) {
        this.titleVacancy = titleVacancy;
        this.description = description;
        this.status = status;
        this.responsibility = responsibility;
        this.requiriments = requiriments;
    }
}
