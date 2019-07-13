package com.starwars.planets.domain.model.swapi;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor(onConstructor_ = @Builder)
public class SwapiPlanet {

    @SerializedName("rotation_period")
    private Integer rotationPeriod;

    @SerializedName("orbital_period")
    private Integer orbitalPeriod;

    @SerializedName("surface_water")
    private String surfaceWater;

    private String name;
    private Integer diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String population;
    private List<String> residents;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

}
