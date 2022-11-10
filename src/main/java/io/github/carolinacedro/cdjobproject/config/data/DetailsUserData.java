package io.github.carolinacedro.cdjobproject.config.data;

import io.github.carolinacedro.cdjobproject.infra.entities.roles.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetailsUserData implements UserDetails {
    private final Optional<io.github.carolinacedro.cdjobproject.infra.entities.roles.User> usuario;

    public DetailsUserData(Optional<User> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new User()).getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new User()).getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
