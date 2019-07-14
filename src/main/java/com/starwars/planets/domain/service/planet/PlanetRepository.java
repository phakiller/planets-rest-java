package com.starwars.planets.domain.service.planet;

import com.starwars.planets.domain.model.planet.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PlanetRepository {

    Planet save(Planet planet);

    Page<Planet> findAll(Pageable pageable);

    Page<Planet> findByNameMatchesRegexAndIgnoreCase(String name, Pageable pageable);

    Optional<Planet> findById(String planetId);

    void deleteById(String planetId);

}
