package com.starwars.planets.port.adapters.repositories.planet;

import com.starwars.planets.domain.service.planet.PlanetRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PlanetRepositoryMongoDB implements PlanetRepository {

    private final PlanetRepositorySpringData planetRepositorySpringData;

    public PlanetRepositoryMongoDB(PlanetRepositorySpringData planetRepositorySpringData) {
        this.planetRepositorySpringData = planetRepositorySpringData;
    }
}
