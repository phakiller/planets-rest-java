package com.starwars.planets.domain.service.planet;

import com.starwars.planets.domain.model.planet.Planet;

import java.util.List;

public interface PlanetRepository {

    Planet save(Planet planet);

    List<Planet> findAll();

}
