package com.starwars.planets.port.adapters.repositories.planet;

import com.starwars.planets.domain.model.planet.Planet;
import com.starwars.planets.domain.service.planet.PlanetRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlanetRepositoryMongoDB implements PlanetRepository {

    private final PlanetRepositorySpringData planetRepositorySpringData;

    public PlanetRepositoryMongoDB(PlanetRepositorySpringData planetRepositorySpringData) {
        this.planetRepositorySpringData = planetRepositorySpringData;
    }

    @Override
    public Planet save(Planet planet) {
        return planetRepositorySpringData.save(planet);
    }

    @Override
    public List<Planet> findAll() {
        return planetRepositorySpringData.findAll();
    }

    @Override
    public List<Planet> findByNameMatchesRegexAndIgnoreCase(String name) {
        return planetRepositorySpringData.findByNameMatchesRegexAndIgnoreCase(name);
    }

    @Override
    public Optional<Planet> findById(String planetId) {
        return planetRepositorySpringData.findById(planetId);
    }

}
