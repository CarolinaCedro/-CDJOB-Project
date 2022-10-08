package io.github.carolinacedro.cdjobproject.infra.repository;

import io.github.carolinacedro.cdjobproject.infra.entities.Adm;
import io.github.carolinacedro.cdjobproject.infra.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Adm,Long> {
}
