package com.starwars.planets.application.swapi;

import com.starwars.planets.application.swapi.dto.SwapiPlanetPageDTO;
import com.starwars.planets.application.swapi.factory.SwapiPlanetPageFactory;
import com.starwars.planets.domain.service.swapi.SwapiService;
import org.springframework.stereotype.Service;

@Service
public class SwapiApplicationService {

    private final SwapiService swapiService;

    public SwapiApplicationService(SwapiService swapiService) {
        this.swapiService = swapiService;
    }

    public SwapiPlanetPageDTO getSwapiPlanetPage(Integer page, String url) {
        return SwapiPlanetPageFactory.toSwapiPlanetPageDTO(swapiService.getPlanetsPage(page, url));
    }

}
