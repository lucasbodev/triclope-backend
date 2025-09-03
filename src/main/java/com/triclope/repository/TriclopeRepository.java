package com.triclope.repository;

import com.triclope.model.TriClope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriclopeRepository extends JpaRepository<TriClope, Integer> {

}
