package com.starwars.planets.domain.service.swapi;

import com.starwars.planets.domain.model.swapi.SwapiPlanetPage;


public interface SwapiPlanetRepository {

    SwapiPlanetPage getPlanetsPage(Integer page);

}
