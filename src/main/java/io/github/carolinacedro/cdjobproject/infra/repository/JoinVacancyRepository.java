package io.github.carolinacedro.cdjobproject.infra.repository;

import io.github.carolinacedro.cdjobproject.infra.entities.JoinVacancy;
import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinVacancyRepository extends JpaRepository<JoinVacancy,Long> {
}
