package com.starwars.planets.domain.service.swapi;

import com.starwars.planets.domain.model.swapi.SwapiPlanetPage;
import org.springframework.stereotype.Service;

@Service
public class SwapiDomainService implements SwapiService {

    private final SwapiPlanetRepository swapiPlanetRepository;

    public SwapiDomainService(SwapiPlanetRepository swapiPlanetRepository) {
        this.swapiPlanetRepository = swapiPlanetRepository;
    }

    public SwapiPlanetPage getPlanetsPage(Integer page, String url) {
        SwapiPlanetPage swapiPlanetPage = swapiPlanetRepository.getPlanetsPage(page);
        setNextWithApplicationUri(swapiPlanetPage, page, url);
        return swapiPlanetPage;
    }

    private void setNextWithApplicationUri(SwapiPlanetPage swapiPlanetPage, Integer page, String uri) {
        if (swapiPlanetPage.getNext() != null)
            swapiPlanetPage.setNext(uri.concat("?page=" + (page + 1)));

        if (swapiPlanetPage.getPrevious() != null)
            swapiPlanetPage.setPrevious(uri.concat("?page=" + (page - 1)));
    }

}
