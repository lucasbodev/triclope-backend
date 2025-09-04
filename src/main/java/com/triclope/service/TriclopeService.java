package com.triclope.service;

import com.triclope.dto.TriclopeDto;
import com.triclope.model.TriclopeDb;
import com.triclope.repository.TriclopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriclopeService {

    @Autowired
    private TriclopeRepository repository;

    public List<TriclopeDto> get() {
        List<TriclopeDb> triClopeDb = repository.findAll();
        return triClopeDb.stream()
                            .map(db -> new TriclopeDto(db.getId(), db.getName(), db.getCreationDate()))
                             .toList();
    }
}
