package com.triclope.repository;

import com.triclope.model.ParticipationDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParticipationRepository extends JpaRepository<ParticipationDb, UUID> {
    
    List<ParticipationDb> findByTriclopeId(UUID triclopeId);
    
    List<ParticipationDb> findByGiverId(UUID giverId);
    
    List<ParticipationDb> findByTakerId(UUID takerId);
    
    List<ParticipationDb> findByTriclopeIdOrderByCreatedAtDesc(UUID triclopeId);
}