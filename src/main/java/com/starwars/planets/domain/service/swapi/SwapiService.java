package com.starwars.planets.domain.service.swapi;

import com.starwars.planets.domain.model.swapi.SwapiPlanetPage;

public interface SwapiService {

    SwapiPlanetPage getPlanetsPage(Integer page, String url);

    SwapiPlanetPage findByName(String name);

}
