package com.starwars.planets.port.adapters.rest;

import com.starwars.planets.application.planet.PlanetApplicationService;
import com.starwars.planets.application.planet.dto.PlanetCommand;
import com.starwars.planets.application.planet.dto.PlanetDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;
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

    @GetMapping("")
    public ResponseEntity<List<PlanetDTO>> getPlanets() {
        return ok().body(planetApplicationService.getPlanets());
    }

}
