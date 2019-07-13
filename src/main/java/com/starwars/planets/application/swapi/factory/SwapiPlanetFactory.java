package com.starwars.planets.application.swapi.factory;

import com.starwars.planets.application.swapi.dto.SwapiPlanetDTO;
import com.starwars.planets.domain.model.swapi.SwapiPlanet;

public final class SwapiPlanetFactory {

    private SwapiPlanetFactory() {

    }

    public static SwapiPlanet toSwapiPlanet(SwapiPlanetDTO swapiPlanetDTO) {
        return SwapiPlanet.builder()
                .name(swapiPlanetDTO.getName())
                .rotationPeriod(swapiPlanetDTO.getRotationPeriod())
                .orbitalPeriod(swapiPlanetDTO.getOrbitalPeriod())
                .diameter(swapiPlanetDTO.getDiameter())
                .climate(swapiPlanetDTO.getClimate())
                .gravity(swapiPlanetDTO.getGravity())
                .terrain(swapiPlanetDTO.getTerrain())
                .surfaceWater(swapiPlanetDTO.getSurfaceWater())
                .population(swapiPlanetDTO.getPopulation())
                .residents(swapiPlanetDTO.getResidents())
                .films(swapiPlanetDTO.getFilms())
                .created(swapiPlanetDTO.getCreated())
                .edited(swapiPlanetDTO.getEdited())
                .url(swapiPlanetDTO.getUrl())
                .build();
    }

    public static SwapiPlanetDTO toSwapiPlanetDTO(SwapiPlanet swapiPlanet) {
        return SwapiPlanetDTO.builder()
                .name(swapiPlanet.getName())
                .rotationPeriod(swapiPlanet.getRotationPeriod())
                .orbitalPeriod(swapiPlanet.getOrbitalPeriod())
                .diameter(swapiPlanet.getDiameter())
                .climate(swapiPlanet.getClimate())
                .gravity(swapiPlanet.getGravity())
                .terrain(swapiPlanet.getTerrain())
                .surfaceWater(swapiPlanet.getSurfaceWater())
                .population(swapiPlanet.getPopulation())
                .residents(swapiPlanet.getResidents())
                .films(swapiPlanet.getFilms())
                .created(swapiPlanet.getCreated())
                .edited(swapiPlanet.getEdited())
                .url(swapiPlanet.getUrl())
                .build();
    }
}
