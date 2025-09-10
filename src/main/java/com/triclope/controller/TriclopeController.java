package com.triclope.controller;

import com.triclope.dto.business.TriclopePrincipal;
import com.triclope.dto.request.TriclopeCreationRequest;
import com.triclope.dto.request.TriclopeUpdateRequest;
import com.triclope.dto.response.ParticipationDto;
import com.triclope.dto.response.TriclopeDto;
import com.triclope.dto.response.UserDto;
import com.triclope.service.ParticipationService;
import com.triclope.service.TriclopeService;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/triclope")
public class TriclopeController {

    Logger logger = LoggerFactory.getLogger(TriclopeController.class);

    @Autowired
    private TriclopeService service;

    @Autowired
    private ParticipationService participationService;

    @GetMapping
    public List<TriclopeDto> get() {
        logger.info("A request to retrieve all triclope was made");
        return service.get();
    }

    @GetMapping("/user/{userId}")
    public List<TriclopeDto> getByUserId(@PathVariable final UUID userId) {
        logger.info("A request to get all participation for a user with user id: {} was made", userId);
        return service.getByUserId(userId);
    }

    @PostMapping
    public TriclopeDto create(@RequestBody TriclopeCreationRequest request, @AuthenticationPrincipal TriclopePrincipal user) {
        logger.info("A request to create a new triclope was made {}", request.toString());
        return service.create(request, user.getUserId());
    }

    @PutMapping
    public TriclopeDto update(@RequestBody TriclopeUpdateRequest request) {
        logger.info("A request to edit a triclope was made {}", request.toString());
        return service.update(request);
    }

    @GetMapping("/{triclopeId}/user")
    public List<UserDto> getUsersByTriclopeId(@PathVariable final UUID triclopeId) {
        logger.info("A request to get all users for a triclope: {} was made", triclopeId);
        return service.getUsersByTriclopeId(triclopeId);
    }

    @GetMapping("/{triclopeId}/participation")
    public List<ParticipationDto> getParticipationByTriclope(@PathVariable final UUID triclopeId) {
        logger.info("A request to get all participation for a triclope: {} was made", triclopeId);
        return participationService.getByTriclopeId(triclopeId);
    }

}
