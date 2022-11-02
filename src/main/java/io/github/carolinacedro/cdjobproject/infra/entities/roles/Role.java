package io.github.carolinacedro.cdjobproject.infra.entities.roles;

import io.github.carolinacedro.cdjobproject.enums.RoleName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Role implements GrantedAuthority,Serializable {

    private static final long seriaVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}
