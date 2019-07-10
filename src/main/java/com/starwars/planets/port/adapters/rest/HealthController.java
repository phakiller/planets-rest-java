package com.starwars.planets.port.adapters.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/status")
    public ResponseEntity getHealthStatus() {
        return ResponseEntity.ok().body("OK");
    }

}
