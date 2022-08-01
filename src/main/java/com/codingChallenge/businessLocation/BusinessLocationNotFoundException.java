package com.codingChallenge.businessLocation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusinessLocationNotFoundException extends RuntimeException {
    BusinessLocationNotFoundException(String locationId) {
        super("Could not find business location " + locationId);
    }
}
