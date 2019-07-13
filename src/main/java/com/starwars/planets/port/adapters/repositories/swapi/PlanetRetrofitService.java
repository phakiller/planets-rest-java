package com.starwars.planets.port.adapters.repositories.swapi;

import com.starwars.planets.domain.model.swapi.SwapiPlanetPage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlanetRetrofitService {

    @GET("planets")
    Call<SwapiPlanetPage> getPlanets(
            @Query("page") Integer page
    );

}
