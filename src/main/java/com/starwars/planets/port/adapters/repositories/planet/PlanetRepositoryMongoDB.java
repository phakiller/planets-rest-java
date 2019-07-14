package com.starwars.planets.port.adapters.repositories.planet;

import com.starwars.planets.domain.model.planet.Planet;
import com.starwars.planets.domain.service.planet.PlanetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

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
    public Page<Planet> findAll(Pageable pageable) {
        return planetRepositorySpringData.findAll(pageable);
    }

    @Override
    public Page<Planet> findByNameMatchesRegexAndIgnoreCase(String name, Pageable pageable) {
        return planetRepositorySpringData.findByNameMatchesRegexAndIgnoreCase(name, pageable);
    }

    @Override
    public Optional<Planet> findById(String planetId) {
        return planetRepositorySpringData.findById(planetId);
    }

    public void deleteById(String planetId) {
        planetRepositorySpringData.deleteById(planetId);
    }

}
