package com.starwars.planets.port.adapters.rest;

import com.starwars.planets.application.planet.PlanetApplicationService;
import com.starwars.planets.application.planet.dto.PlanetCommand;
import com.starwars.planets.application.planet.dto.PlanetDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetApplicationService planetApplicationService;

    public PlanetController(PlanetApplicationService planetApplicationService) {
        this.planetApplicationService = planetApplicationService;
    }

    @PostMapping("")
    public ResponseEntity<PlanetDTO> savePlanet(@RequestBody PlanetCommand planetCommand) {
        PlanetDTO planetDTO = planetApplicationService.savePlanet(planetCommand);
        return status(CREATED).body(planetDTO);
    }

}
