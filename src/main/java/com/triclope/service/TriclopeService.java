package com.triclope.service;

import com.triclope.dto.request.TriclopeCreationRequest;
import com.triclope.dto.response.TriclopeDto;
import com.triclope.dto.request.TriclopeUpdateRequest;
import com.triclope.mapper.TriclopeMapper;
import com.triclope.model.TriclopeDb;
import com.triclope.model.UserDb;
import com.triclope.repository.TriclopeRepository;
import com.triclope.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TriclopeService {

    @Autowired
    private TriclopeRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TriclopeMapper mapper;

    public List<TriclopeDto> get() {
        List<TriclopeDb> triClopeDb = repository.findAll();
        return triClopeDb.stream()
                .map(db -> new TriclopeDto(db.getId(), db.getName(), db.getCreationDate()))
                .toList();
    }

    public List<TriclopeDto> getByUserId(String userId) {
        List<TriclopeDb> byMembersId = repository.findByMembersId(userId);
        return mapper.toList(byMembersId);
    }

    @Transactional
    public TriclopeDto create(final TriclopeCreationRequest request) {
        TriclopeDb toSave = this.mapper.toCreateDb(request);
        UserDb userDb = userRepository.findById(request.createdBy()).orElseThrow();
        toSave.setCreatedBy(userDb);
        toSave.getMembers().add(userDb);
        TriclopeDb saved = repository.save(toSave);
        return mapper.toDto(saved);
    }

    @Transactional
    public TriclopeDto update(final TriclopeUpdateRequest request) {
        TriclopeDb db = this.mapper.toUpdateDb(request);
        db.setName(request.name());
        return mapper.toDto(db);
    }

}
