package io.github.carolinacedro.cdjobproject.infra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.carolinacedro.cdjobproject.infra.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private String responsibility;


    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Requiriments> requiriments = new ArrayList<>();

    public Vacancy(String titleVacancy, String description, String status, String responsibility, List<Requiriments> requiriments) {
        this.titleVacancy = titleVacancy;
        this.description = description;
        this.status = status;
        this.responsibility = responsibility;
        this.requiriments = requiriments;
    }
}
