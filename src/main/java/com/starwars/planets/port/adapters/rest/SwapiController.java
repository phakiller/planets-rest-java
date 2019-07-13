package com.starwars.planets.port.adapters.rest;

import com.starwars.planets.application.swapi.SwapiApplicationService;
import com.starwars.planets.application.swapi.dto.SwapiPlanetPageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/swapi")
public class SwapiController {

    private final SwapiApplicationService service;

    public SwapiController(SwapiApplicationService service) {
        this.service = service;
    }

    @GetMapping("/planets")
    public ResponseEntity<SwapiPlanetPageDTO> swapiPlanetPage(
            HttpServletRequest request,
            @RequestParam(defaultValue = "1") Integer page){
        String url = request.getRequestURL().toString();
        return ok().body(service.getSwapiPlanetPage(page, url));
    }
}
