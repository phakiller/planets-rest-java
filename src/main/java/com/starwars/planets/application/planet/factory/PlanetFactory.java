package com.starwars.planets.application.planet.factory;

import com.starwars.planets.application.planet.dto.PlanetDTO;
import com.starwars.planets.domain.model.planet.Planet;

public final class PlanetFactory {

    private PlanetFactory() {

    }

    public static Planet toPlanet(PlanetDTO planetDTO) {
        return Planet.builder()
                .id(planetDTO.getId())
                .name(planetDTO.getName())
                .climate(planetDTO.getClimate())
                .terrain(planetDTO.getTerrain())
                .numberOfMovies(planetDTO.getNumberOfMovies())
                .build();
    }

    public static PlanetDTO toPlanetDTO(Planet planet) {
        return PlanetDTO.builder()
                .id(planet.getId())
                .name(planet.getName())
                .climate(planet.getClimate())
                .terrain(planet.getTerrain())
                .numberOfMovies(planet.getNumberOfMovies())
                .build();
    }

}
