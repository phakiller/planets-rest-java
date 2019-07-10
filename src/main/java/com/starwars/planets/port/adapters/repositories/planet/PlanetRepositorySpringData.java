package com.starwars.planets.port.adapters.repositories.planet;

import com.starwars.planets.domain.model.planet.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanetRepositorySpringData extends MongoRepository<Planet, UUID> {
}
