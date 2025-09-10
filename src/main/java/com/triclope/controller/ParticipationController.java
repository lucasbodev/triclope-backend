package com.triclope.controller;

import com.triclope.dto.request.ParticipationCreationRequest;
import com.triclope.dto.request.ParticipationUpdateRequest;
import com.triclope.dto.response.ParticipationDto;
import com.triclope.service.ParticipationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/participation")
public class ParticipationController {

    Logger logger = LoggerFactory.getLogger(ParticipationController.class);

    @Autowired
    private ParticipationService service;

    @GetMapping
    public List<ParticipationDto> get() {
        logger.info("A request to retrieve all participations was made");
        return service.get();
    }

    @GetMapping("/{id}")
    public ParticipationDto getById(@PathVariable final UUID id) {
        logger.info("A request to retrieve participation with id: {} was made", id);
        return service.getById(id);
    }

    @GetMapping("/triclope/{triclopeId}")
    public List<ParticipationDto> getByTriclopeId(@PathVariable final UUID triclopeId) {
        logger.info("A request to retrieve participations for triclope: {} was made", triclopeId);
        return service.getByTriclopeId(triclopeId);
    }

    @GetMapping("/user/{userId}/given")
    public List<ParticipationDto> getGivenByUserId(@PathVariable final UUID userId) {
        logger.info("A request to retrieve participations given by user: {} was made", userId);
        return service.getByGiverId(userId);
    }

    @GetMapping("/user/{userId}/received")
    public List<ParticipationDto> getReceivedByUserId(@PathVariable final UUID userId) {
        logger.info("A request to retrieve participations received by user: {} was made", userId);
        return service.getByTakerId(userId);
    }

    @PostMapping
    public ParticipationDto create(@RequestBody ParticipationCreationRequest request) {
        logger.info("A request to create a new participation was made: {}", request.toString());
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ParticipationDto update(@PathVariable UUID id, @RequestBody ParticipationUpdateRequest request) {
        logger.info("A request to update participation with id: {} was made: {}", id, request.toString());
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        logger.info("A request to delete participation with id: {} was made", id);
        service.delete(id);
    }
}
