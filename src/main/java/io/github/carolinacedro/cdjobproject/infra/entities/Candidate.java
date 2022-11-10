package io.github.carolinacedro.cdjobproject.infra.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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


    @OneToOne
    private Vacancy vacancy;


    public Candidate(String name, String phone, String email, String state, String note, Vacancy vacancy) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.state = state;
        this.note = note;
        this.vacancy = vacancy;
    }
}
