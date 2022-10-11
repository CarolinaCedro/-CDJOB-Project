package io.github.carolinacedro.cdjobproject.infra.repository;

import io.github.carolinacedro.cdjobproject.infra.entities.Requiriments;
import io.github.carolinacedro.cdjobproject.infra.entities.Responsibilitys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirimentsRepository extends JpaRepository<Requiriments,Long> {
    List<Requiriments> findAllByIdIn(List<Long> id);
}
