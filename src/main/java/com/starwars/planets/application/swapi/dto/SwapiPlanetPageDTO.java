package com.starwars.planets.application.swapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor(onConstructor_ = @Builder)
public class SwapiPlanetPageDTO implements Serializable {

    private Integer count;
    private String next;
    private String previous;
    private List<SwapiPlanetDTO> results;

}
