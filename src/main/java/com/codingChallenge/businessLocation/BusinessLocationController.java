package com.codingChallenge.businessLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessLocationController {

    private BusinessLocationService businessLocationService;

    @Autowired
    public BusinessLocationController(BusinessLocationService businessLocationService) {
        this.businessLocationService = businessLocationService;
    }

    @GetMapping("/betriebsstelle/{locationId}")
    public BusinessLocation getBusinessLocation(@PathVariable String locationId) {
        return businessLocationService.getLocationData(locationId);

    }

}
