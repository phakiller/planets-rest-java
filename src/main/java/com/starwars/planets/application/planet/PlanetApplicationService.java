package com.starwars.planets.application.planet;

import com.starwars.planets.application.planet.dto.PlanetCommand;
import com.starwars.planets.application.planet.dto.PlanetDTO;
import com.starwars.planets.application.planet.factory.PlanetCommandFactory;
import com.starwars.planets.application.planet.factory.PlanetFactory;
import com.starwars.planets.domain.model.planet.Planet;
import com.starwars.planets.domain.service.planet.PlanetService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PlanetApplicationService {

    private final PlanetService planetService;

    public PlanetApplicationService(PlanetService planetService) {
        this.planetService = planetService;
    }

    public PlanetDTO savePlanet(PlanetCommand planetCommand) {
        Planet planet = planetService.save(PlanetCommandFactory.toPlanet(planetCommand));
        return PlanetFactory.toPlanetDTO(planet);
    }

    public List<PlanetDTO> getPlanets() {
        return planetService.getPlanets().stream()
                .map(PlanetFactory::toPlanetDTO).collect(toList());
    }

}
