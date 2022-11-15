package io.github.carolinacedro.cdjobproject.service;

import io.github.carolinacedro.cdjobproject.infra.dto.CandidateDto;
import io.github.carolinacedro.cdjobproject.infra.entities.Candidate;

import io.github.carolinacedro.cdjobproject.infra.repository.CandidateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public List<CandidateDto> findAll() {
        return repository.findAll().stream().map(this::candidateDto).collect(Collectors.toList());
    }

    public Optional<CandidateDto> findById(Long id) {
        return repository.findById(id).map(this::candidateDto);
    }

    public Candidate save(CandidateDto candidateDto) {
        Candidate saveCandidate = modelMapper.map(candidateDto, Candidate.class);
        return repository.save(saveCandidate);
    }

    public CandidateDto update(CandidateDto candidateDto, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Candidate> optional = repository.findById(id);
        if (optional.isPresent()) {
            Candidate db = optional.get();
            db.setEmail(candidateDto.getEmail());
            db.setName(candidateDto.getName());
            db.setPhone(candidateDto.getPhone());
            db.setNote(candidateDto.getNote());
            db.setState(candidateDto.getState());
            repository.save(db);
            return this.candidateDto(db);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    private CandidateDto candidateDto(Candidate candidate) {
        return modelMapper.map(candidate, CandidateDto.class);
    }

}
