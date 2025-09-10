package com.triclope.repository;

import com.triclope.model.TriclopeDb;
import com.triclope.model.UserDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TriclopeRepository extends JpaRepository<TriclopeDb, UUID> {

    List<TriclopeDb> findByMembersId(UUID userId);
    
    @Query("SELECT t.members FROM TriclopeDb t WHERE t.id = :triclopeId")
    List<UserDb> findMembersByTriclopeId(@Param("triclopeId") UUID triclopeId);
}
