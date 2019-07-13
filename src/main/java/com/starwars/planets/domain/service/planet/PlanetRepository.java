package com.starwars.planets.domain.service.planet;

import com.starwars.planets.domain.model.planet.Planet;

import java.util.List;
import java.util.Optional;

public interface PlanetRepository {

    Planet save(Planet planet);

    List<Planet> findAll();

    List<Planet> findByNameMatchesRegexAndIgnoreCase(String name);

    Optional<Planet> findById(String planetId);

}
