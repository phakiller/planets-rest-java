package com.starwars.planets.domain.model.swapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor(onConstructor_ = @Builder)
public class SwapiPlanetPage {

    private Integer count;
    private String next;
    private String previous;
    private List<SwapiPlanet> results;

}
