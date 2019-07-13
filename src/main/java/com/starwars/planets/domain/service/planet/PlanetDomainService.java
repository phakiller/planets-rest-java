package com.starwars.planets.domain.service.planet;

import com.starwars.planets.domain.exceptions.NotFoundException;
import com.starwars.planets.domain.model.planet.Planet;
import com.starwars.planets.port.adapters.repositories.planet.PlanetRepositoryMongoDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetDomainService implements PlanetService {

    private final PlanetRepositoryMongoDB planetRepositoryMongoDB;

    public PlanetDomainService(PlanetRepositoryMongoDB planetRepositoryMongoDB) {
        this.planetRepositoryMongoDB = planetRepositoryMongoDB;
    }

    public Planet save(Planet planet) {
        return planetRepositoryMongoDB.save(planet);
    }

    public Planet findById(String planetId) {
        Optional<Planet> planet = planetRepositoryMongoDB.findById(planetId);
        return planet.orElseThrow(NotFoundException::new);
    }

    public List<Planet> getPlanets() {
        return planetRepositoryMongoDB.findAll();
    }

    public List<Planet> findByName(String name) {
        return planetRepositoryMongoDB.findByNameMatchesRegexAndIgnoreCase(name);
    }

    public void deleteById(String planetId) {
        planetRepositoryMongoDB.deleteById(planetId);
    }

}
