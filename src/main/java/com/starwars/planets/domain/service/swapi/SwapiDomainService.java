package com.starwars.planets.domain.service.swapi;

import com.starwars.planets.domain.exceptions.NotFoundException;
import com.starwars.planets.domain.model.swapi.SwapiPlanetPage;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SwapiDomainService implements SwapiService {

    private final SwapiPlanetRepository swapiPlanetRepository;

    public SwapiDomainService(SwapiPlanetRepository swapiPlanetRepository) {
        this.swapiPlanetRepository = swapiPlanetRepository;
    }

    public SwapiPlanetPage getPlanetsPage(Integer page, String url) {
        SwapiPlanetPage swapiPlanetPage = Optional.ofNullable(swapiPlanetRepository.getPlanetsPage(page))
                .orElseThrow(NotFoundException::new);
        setNextWithApplicationUri(swapiPlanetPage, page, url);
        return swapiPlanetPage;
    }

    private void setNextWithApplicationUri(SwapiPlanetPage swapiPlanetPage, Integer page, String uri) {
        if (swapiPlanetPage.getNext() != null)
            swapiPlanetPage.setNext(uri.concat("?page=" + (page + 1)));

        if (swapiPlanetPage.getPrevious() != null)
            swapiPlanetPage.setPrevious(uri.concat("?page=" + (page - 1)));
    }

    public SwapiPlanetPage findByName(String name) {
        return swapiPlanetRepository.findByName(name);
    }

}
