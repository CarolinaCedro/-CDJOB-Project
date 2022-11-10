package io.github.carolinacedro.cdjobproject.infra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class JoinVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE)
    private  List<Candidate> candidate;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Vacancy> vacancy;
}
