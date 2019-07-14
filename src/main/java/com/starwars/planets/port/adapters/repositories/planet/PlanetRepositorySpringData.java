package com.starwars.planets.port.adapters.repositories.planet;

import com.starwars.planets.domain.model.planet.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepositorySpringData extends MongoRepository<Planet, String> {

    @Query("{ 'name': { '$regex': '?0', '$options': 'i' } }")
    Page<Planet> findByNameMatchesRegexAndIgnoreCase(String name, Pageable pageable);

}
