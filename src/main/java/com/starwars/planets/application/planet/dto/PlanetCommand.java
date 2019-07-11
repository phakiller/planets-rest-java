package com.starwars.planets.application.planet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetCommand implements Serializable {

    private String name;
    private String climate;
    private String terrain;

}
