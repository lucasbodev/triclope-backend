package com.triclope.controller;

import com.triclope.dto.response.ParticipationDto;
import com.triclope.service.ParticipationService;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/participation")
public class ParticipationController {

    Logger logger = LoggerFactory.getLogger(ParticipationController.class);

    private ParticipationService service;

    @PostMapping
    public List<ParticipationDto> addParticipation() {
        logger.info("A request to add a participation was made %s");
        throw new NotImplementedException();
    }



}
