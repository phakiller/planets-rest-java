package com.starwars.planets.domain.service.planet;

import com.starwars.planets.domain.model.planet.Planet;

import java.util.List;

public interface PlanetService {

    Planet save(Planet planet);

    List<Planet> getPlanets();

    List<Planet> findByName(String name);

    Planet findById(String planetId);

}
