package com.triclope.service;

import com.triclope.dto.ParticipationDto;
import com.triclope.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {

    private ParticipantRepository repository;

    public List<ParticipationDto> get() {
        return null;
    }

    public ParticipationDto getById(final String id) {
        //return repository.findById(id).map(participationDb -> new ParticipationDto(participationDb.getId(), participationDb.getTriclope()));
    return null;
    }
}
