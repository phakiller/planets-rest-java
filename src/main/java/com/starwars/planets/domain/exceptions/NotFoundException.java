package com.starwars.planets.domain.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(code = NOT_FOUND, reason = "Resource not found")
public class NotFoundException extends RuntimeException {
}
