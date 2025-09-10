package com.triclope.service;

import com.triclope.dto.request.ParticipationCreationRequest;
import com.triclope.dto.request.ParticipationUpdateRequest;
import com.triclope.dto.response.ParticipationDto;
import com.triclope.mapper.ParticipationMapper;
import com.triclope.model.ParticipationDb;
import com.triclope.model.TriclopeDb;
import com.triclope.model.UserDb;
import com.triclope.repository.ParticipationRepository;
import com.triclope.repository.TriclopeRepository;
import com.triclope.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ParticipationService {

    @Autowired
    private ParticipationRepository repository;

    @Autowired
    private ParticipationMapper mapper;

    @Autowired
    private TriclopeRepository triclopeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ParticipationDto> get() {
        List<ParticipationDb> participations = repository.findAll();
        return mapper.toList(participations);
    }

    public ParticipationDto getById(final UUID id) {
        ParticipationDb participation = repository.findById(id).orElseThrow();
        return mapper.toDto(participation);
    }

    public List<ParticipationDto> getByTriclopeId(UUID triclopeId) {
        List<ParticipationDb> participations = repository.findByTriclopeIdOrderByCreatedAtDesc(triclopeId);
        return mapper.toList(participations);
    }

    public List<ParticipationDto> getByGiverId(UUID giverId) {
        List<ParticipationDb> participations = repository.findByGiverId(giverId);
        return mapper.toList(participations);
    }

    public List<ParticipationDto> getByTakerId(UUID takerId) {
        List<ParticipationDb> participations = repository.findByTakerId(takerId);
        return mapper.toList(participations);
    }

    @Transactional
    public ParticipationDto create(ParticipationCreationRequest request) {
        ParticipationDb participation = new ParticipationDb();
        
        TriclopeDb triclope = triclopeRepository.findById(request.triclopeId()).orElseThrow();
        UserDb giver = userRepository.findById(request.giverId()).orElseThrow();
        UserDb taker = userRepository.findById(request.takerId()).orElseThrow();
        
        participation.setTriclope(triclope);
        participation.setGiver(giver);
        participation.setTaker(taker);
        participation.setQuantity(request.quantity());
        participation.setCreatedAt(LocalDateTime.now());
        
        ParticipationDb saved = repository.save(participation);
        return mapper.toDto(saved);
    }

    @Transactional
    public ParticipationDto update(ParticipationUpdateRequest request) {
        ParticipationDb participation = repository.findById(request.id()).orElseThrow();
        participation.setQuantity(request.quantity());
        
        ParticipationDb saved = repository.save(participation);
        return mapper.toDto(saved);
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
