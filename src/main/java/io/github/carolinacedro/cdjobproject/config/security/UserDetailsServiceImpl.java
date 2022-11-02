package io.github.carolinacedro.cdjobproject.config.security;

import io.github.carolinacedro.cdjobproject.infra.entities.roles.User;
import io.github.carolinacedro.cdjobproject.infra.repository.rolesRepository.CandidateRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CandidateRoleRepository candidateRoleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User candidateRole = candidateRoleRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado com este nome: " + username));
        return new org.springframework.security.core.userdetails.User(candidateRole.getUsername(), candidateRole.getPassword(), true,true,true,true,candidateRole.getAuthorities());
    }
}
