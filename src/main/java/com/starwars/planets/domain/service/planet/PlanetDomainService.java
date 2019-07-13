package com.starwars.planets.domain.service.planet;

import com.starwars.planets.domain.exceptions.NotFoundException;
import com.starwars.planets.domain.model.planet.Planet;
import com.starwars.planets.domain.model.swapi.SwapiPlanet;
import com.starwars.planets.domain.model.swapi.SwapiPlanetPage;
import com.starwars.planets.domain.service.swapi.SwapiService;
import com.starwars.planets.port.adapters.repositories.planet.PlanetRepositoryMongoDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetDomainService implements PlanetService {

    private final PlanetRepositoryMongoDB planetRepositoryMongoDB;
    private final SwapiService swapiService;

    public PlanetDomainService(
            PlanetRepositoryMongoDB planetRepositoryMongoDB,
            SwapiService swapiService) {
        this.planetRepositoryMongoDB = planetRepositoryMongoDB;
        this.swapiService = swapiService;
    }

    public Planet save(Planet planet) {
        SwapiPlanetPage swapiPlanetPage = swapiService.findByName(planet.getName());

        if (swapiPlanetPage != null)
            setNumberOfFilms(planet, swapiPlanetPage);

        return planetRepositoryMongoDB.save(planet);
    }

    public Planet findById(String planetId) {
        Optional<Planet> planet = planetRepositoryMongoDB.findById(planetId);
        return planet.orElseThrow(NotFoundException::new);
    }

    public List<Planet> getPlanets() {
        return planetRepositoryMongoDB.findAll();
    }

    public List<Planet> findByName(String name) {
        return planetRepositoryMongoDB.findByNameMatchesRegexAndIgnoreCase(name);
    }

    public void deleteById(String planetId) {
        planetRepositoryMongoDB.deleteById(planetId);
    }

    private void setNumberOfFilms(Planet planet, SwapiPlanetPage swapiPlanetPage) {
        SwapiPlanet swapiPlanet = swapiPlanetPage.getResults().get(0);

        if (swapiPlanetPage.getCount().equals(1) && isPlanetsNamesEqualsIgnoringCase(planet, swapiPlanet))
            planet.setNumberOfMovies(swapiPlanet.getFilms().size());
        else
            planet.setNumberOfMovies(-1);
    }

    private Boolean isPlanetsNamesEqualsIgnoringCase (Planet planet, SwapiPlanet swapiPlanet) {
        return swapiPlanet.getName().equalsIgnoreCase(planet.getName());
    }

}
