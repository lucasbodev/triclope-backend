package com.triclope.repository;

import com.triclope.model.TriclopeDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TriclopeRepository extends JpaRepository<TriclopeDb, String> {

    List<TriclopeDb> findByMembersId (String userId);
}
