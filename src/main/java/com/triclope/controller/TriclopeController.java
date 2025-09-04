package com.triclope.controller;

import com.triclope.dto.ParticipationDto;
import com.triclope.dto.TriclopeDto;
import com.triclope.service.TriclopeService;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/triclope")
public class TriclopeController {

    Logger logger = LoggerFactory.getLogger(TriclopeController.class);

    @Autowired
    private TriclopeService service;

    @GetMapping
    public List<TriclopeDto> get () {
        logger.info("A request to retrieve all triclopes was made");
        return service.get();
    }

    @GetMapping("/user/{userId}")
    public List<TriclopeDto> getByUserId (@PathVariable String userId ) {
        logger.info("A request to get all participation for a user with user id: {} was made", userId);
        throw new NotImplementedException();
    }

    @GetMapping("/{triclopeId}/user")
    public List<TriclopeDto> getUsersByTriclopeId (@PathVariable String triclopeId ) {
        logger.info("A request to get all users for a triclope: {} was made", triclopeId);
        throw new NotImplementedException();
    }

    @GetMapping("/{triclopeId}/participation")
    public ParticipationDto getParticipationByTriclope(@PathVariable final String triclopeId) {
        logger.info("A request to get all participation for a triclope: {} was made", triclopeId);
        throw new NotImplementedException();
    }

}
