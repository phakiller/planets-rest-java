package com.starwars.planets.domain.service.planet;

import com.starwars.planets.domain.model.planet.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlanetService {

    Planet save(Planet planet);

    Page<Planet> getPlanets(Pageable pageable);

    Page<Planet> findByName(String name, Pageable pageable);

    Planet findById(String planetId);

    void deleteById(String planetId);

}
