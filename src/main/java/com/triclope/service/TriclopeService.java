package com.triclope.service;

import com.triclope.dto.TriClopeDto;
import com.triclope.model.TriClope;
import com.triclope.repository.TriclopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriclopeService {

    @Autowired
    private TriclopeRepository repository;

    public List<TriClopeDto> get() {
        List<TriClope> triClopesDb = repository.findAll();
        List<TriClopeDto> dtos = triClopesDb.stream()
                                        .map(db -> new TriClopeDto(db.getId(), db.getName(), db.getCreationDate()))
                                         .toList();
        return dtos;
    }
}
