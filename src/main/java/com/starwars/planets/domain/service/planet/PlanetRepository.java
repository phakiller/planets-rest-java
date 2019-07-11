package com.starwars.planets.domain.service.planet;

import com.starwars.planets.domain.model.planet.Planet;

public interface PlanetRepository {

    Planet save(Planet planet);

}
