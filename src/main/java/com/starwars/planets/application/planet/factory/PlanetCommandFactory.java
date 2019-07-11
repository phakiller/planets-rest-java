package com.starwars.planets.application.planet.factory;

import com.starwars.planets.application.planet.dto.PlanetCommand;
import com.starwars.planets.domain.model.planet.Planet;

public final class PlanetCommandFactory {

    private PlanetCommandFactory() {

    }

    public static Planet toPlanet(PlanetCommand planetCommand) {
        return Planet.builder()
                .name(planetCommand.getName())
                .climate(planetCommand.getClimate())
                .terrain(planetCommand.getTerrain())
                .build();
    }

}
