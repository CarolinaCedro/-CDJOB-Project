package io.github.carolinacedro.cdjobproject.infra.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String state;
    private String note;

//    @ManyToMany
//    @JoinTable(name = "candidate_has_vacancy", joinColumns =
//            {@JoinColumn(name = "candidate_id")}, inverseJoinColumns =
//            {@JoinColumn(name = "vacancy_id")})
//    private List<Vacancy> vacancies = new ArrayList<>();

    @ManyToOne
    private JoinVacancy joinVacancy;

    public Candidate(String name, String phone, String email, String state, String note, JoinVacancy joinVacancy) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.state = state;
        this.note = note;
        this.joinVacancy = joinVacancy;
    }


}
