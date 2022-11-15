package io.github.carolinacedro.cdjobproject.infra.entities;

import io.github.carolinacedro.cdjobproject.enums.Status;
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
    @Column(name = "titlevacancy")
    private String titleVacancy;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Status status;
    private String responsibility;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Requiriments> requiriments = new ArrayList<>();


    public Vacancy(String titleVacancy, String description, Status status, String responsibility, List<Requiriments> requiriments) {
        this.titleVacancy = titleVacancy;
        this.description = description;
        this.status = Status.Ativo;
        this.responsibility = responsibility;
        this.requiriments = requiriments;
    }
}
