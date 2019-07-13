package com.starwars.planets.port.adapters.repositories.swapi;

import com.starwars.planets.domain.model.swapi.SwapiPlanetPage;
import com.starwars.planets.domain.service.swapi.SwapiPlanetRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class SwapiPlanetRepositoryApi implements SwapiPlanetRepository {

    private final PlanetRetrofitService planetRetrofitService;

    public SwapiPlanetRepositoryApi() {
        this.planetRetrofitService = PlanetRetrofitServiceGenerator.createService(PlanetRetrofitService.class);
    }

    public SwapiPlanetPage getPlanetsPage(Integer page) {
        try {
            return planetRetrofitService.getPlanets(page, null).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SwapiPlanetPage findByName(String name) {
        try {
            return planetRetrofitService.getPlanets(null, name).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
