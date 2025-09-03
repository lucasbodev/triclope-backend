package com.triclope.controller;

import com.triclope.dto.TriClopeDto;
import com.triclope.service.TriclopeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("triclope")
public class TriClopeController {

    Logger logger = LoggerFactory.getLogger(TriClopeController.class);

    @Autowired
    private TriclopeService service;

    @GetMapping
    public List<TriClopeDto> get () {
        logger.info("A request to retrieve all triclopes was made");
        return service.get();
    }

    @GetMapping("/{id}")
    public void getById (@PathVariable String id ) {

    }

}
