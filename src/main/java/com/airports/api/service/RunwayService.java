package com.airports.api.service;

import com.airports.api.data.model.Airport;
import com.airports.api.data.model.Country;
import com.airports.api.data.model.Runway;
import com.airports.api.data.repository.RunwayRepository;
import com.airports.api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class RunwayService {

    private final CountryService countryService;
    private final RunwayRepository runwayRepository;
    private final AirportService airportService;

    public Map<String, List<Runway>> findRunwaysForAirports(String country) {
        Country countryDetails = countryService.findCountry(country);
        Map<String, List<Runway>> runwayMap = new HashMap<>();
        List<Airport> airportList = airportService.findByCountryCode(countryDetails);
        List<Long> airportIds = airportList.stream().map(Airport::getId).collect(toList());
        List<Runway> runways = getRunwaysByAirportIds(airportIds);
        airportList.forEach(airport -> {
            List<Runway> runwayList = runways.stream()
                    .filter(runway -> runway.getAirportRef() == airport.getId())
                    .collect(toList());
            if (!runwayList.isEmpty()) {
                runwayMap.put(airport.getName(), runwayList);
            }
        });
        return runwayMap;
    }

    private List<Runway> getRunwaysByAirportIds(List<Long> airportIds) {
        Optional<List<Runway>> runways = runwayRepository.findByAirportRefIn(airportIds);
        if (runways.isPresent() && !runways.get().isEmpty()) {
            return runways.get();
        } else {
            throw new NotFoundException("no runway found in DB");
        }
    }
}
