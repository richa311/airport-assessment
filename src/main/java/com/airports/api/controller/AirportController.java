package com.airports.api.controller;

import com.airports.api.data.model.Country;
import com.airports.api.data.model.Runway;
import com.airports.api.service.CountryService;
import com.airports.api.service.RunwayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airports")
public class AirportController {

    private final CountryService countryService;
    private final RunwayService runwayService;

    @GetMapping("/runways/{country}")
    public ResponseEntity<Map<String, List<Runway>>> getRunwaysForAirports(@PathVariable String country) {
        return ResponseEntity.ok(runwayService.findRunwaysForAirports(country));
    }

    @GetMapping("/countries/highest")
    public ResponseEntity<List<Country>> getCountriesWithHighestNumberOfAirports() {
        List<Country> countries = countryService.findTopTenCountriesWithHighestNumberOfAirports();
        return ResponseEntity.ok(countries);
    }

}
