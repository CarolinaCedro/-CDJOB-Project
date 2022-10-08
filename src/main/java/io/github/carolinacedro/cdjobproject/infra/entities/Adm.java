package io.github.carolinacedro.cdjobproject.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adm {

    private Long id;
    private String name;
    private String email;
    private String password;
}
