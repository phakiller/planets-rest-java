package com.starwars.planets.application.planet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
public class PlanetDTO implements Serializable {

    private String id;
    private String name;
    private String climate;
    private String terrain;
    private Integer numberOfMovies;

}
