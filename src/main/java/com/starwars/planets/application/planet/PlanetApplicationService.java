package com.starwars.planets.application.planet;

import com.starwars.planets.application.planet.dto.PlanetCommand;
import com.starwars.planets.application.planet.dto.PlanetDTO;
import com.starwars.planets.application.planet.factory.PlanetCommandFactory;
import com.starwars.planets.application.planet.factory.PlanetFactory;
import com.starwars.planets.domain.model.planet.Planet;
import com.starwars.planets.domain.service.planet.PlanetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<PlanetDTO> getPlanets(String name, Pageable pageable) {
        Page<Planet> planets = name != null ? planetService.findByName(name, pageable) : planetService.getPlanets(pageable);
        return planets.map(PlanetFactory::toPlanetDTO);
    }

    public PlanetDTO findPlanetById(String planetId) {
        return PlanetFactory.toPlanetDTO(planetService.findById(planetId));
    }

    public void deletePlanetById(String planetId) {
        planetService.deleteById(planetId);
    }

}
