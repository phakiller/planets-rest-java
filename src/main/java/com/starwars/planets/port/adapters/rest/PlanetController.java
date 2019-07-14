package com.starwars.planets.port.adapters.rest;

import com.starwars.planets.application.planet.PlanetApplicationService;
import com.starwars.planets.application.planet.dto.PlanetCommand;
import com.starwars.planets.application.planet.dto.PlanetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<PlanetDTO>> getPlanets(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize
    ) {
        return ok().body(planetApplicationService.getPlanets(name, PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{planetId}")
    public ResponseEntity<PlanetDTO> findPlanetById(@PathVariable String planetId) {
        return ok().body(planetApplicationService.findPlanetById(planetId));
    }

    @DeleteMapping("/{planetId}")
    public ResponseEntity deletePlanetById(@PathVariable String planetId) {
        planetApplicationService.deletePlanetById(planetId);
        return ok().build();
    }

}
