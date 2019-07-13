package com.starwars.planets.application.swapi.factory;

import com.starwars.planets.application.swapi.dto.SwapiPlanetPageDTO;
import com.starwars.planets.domain.model.swapi.SwapiPlanetPage;

import static java.util.stream.Collectors.toList;

public final class SwapiPlanetPageFactory {

    private SwapiPlanetPageFactory() {

    }

    public static SwapiPlanetPage toSwapiPlanetPage(SwapiPlanetPageDTO swapiPlanetPageDTO) {
        return SwapiPlanetPage.builder()
                .count(swapiPlanetPageDTO.getCount())
                .next(swapiPlanetPageDTO.getNext())
                .previous(swapiPlanetPageDTO.getPrevious())
                .results(
                        swapiPlanetPageDTO
                                .getResults()
                                .stream()
                                .map(SwapiPlanetFactory::toSwapiPlanet)
                                .collect(toList()))
                .build();
    }

    public static SwapiPlanetPageDTO toSwapiPlanetPageDTO(SwapiPlanetPage swapiPlanetPage) {
        return SwapiPlanetPageDTO.builder()
                .count(swapiPlanetPage.getCount())
                .next(swapiPlanetPage.getNext())
                .previous(swapiPlanetPage.getPrevious())
                .results(
                        swapiPlanetPage
                                .getResults()
                                .stream()
                                .map(SwapiPlanetFactory::toSwapiPlanetDTO)
                                .collect(toList()))
                .build();
    }

}
