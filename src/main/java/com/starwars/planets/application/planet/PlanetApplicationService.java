package com.starwars.planets.application.planet;

import com.starwars.planets.domain.service.planet.PlanetService;
import org.springframework.stereotype.Service;

@Service
public class PlanetApplicationService {

    private final PlanetService planetService;

    public PlanetApplicationService(PlanetService planetService) {
        this.planetService = planetService;
    }

}
