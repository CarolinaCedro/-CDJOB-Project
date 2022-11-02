package io.github.carolinacedro.cdjobproject.infra.repository.rolesRepository;

import io.github.carolinacedro.cdjobproject.infra.entities.roles.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CandidateRoleRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
