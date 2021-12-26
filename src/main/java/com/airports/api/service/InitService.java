package com.airports.api.service;

import com.airports.api.data.model.Airport;
import com.airports.api.data.model.Country;
import com.airports.api.data.model.Runway;
import com.airports.api.data.repository.AirportRepository;
import com.airports.api.data.repository.CountryRepository;
import com.airports.api.data.repository.RunwayRepository;
import com.airports.api.utils.DataUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitService {

    private final CountryRepository countryRepository;
    private final AirportRepository airportRepository;
    private final RunwayRepository runwayRepository;

    private List<Country> countries = new ArrayList<>();

    @PostConstruct
    public void buildCsvData() throws IOException {
        log.info("Reading csv and loading data...");
        buildCountriesData();
        buildAirportsData();
        buildRunwaysData();
    }

    void buildCountriesData() throws IOException {
        log.info("Reading countries.csv and loading data...");
        List<Map<String, String>> data = DataUtils.getCsvData("countries.csv");
        data.parallelStream().forEach(entry -> {
            Country country = Country.buildCountry(entry);
            this.countries.add(country);
        });
        log.info("Saving countries to db, size: {}", countries.size());
        countryRepository.saveAll(this.countries);
    }

    void buildAirportsData() throws IOException {
        log.info("Reading airports.csv and loading data...");
        DataUtils.getCsvData("airports.csv").parallelStream().forEach(entry -> {
            Airport airport = Airport.buildAirport(entry);
            airportRepository.save(airport);
        });
    }

    void buildRunwaysData() throws IOException {
        log.info("Reading runways.csv and loading data...");
        DataUtils.getCsvData("runways.csv").parallelStream().forEach(entry -> {
            Runway runway = Runway.buildRunway(entry);
            runwayRepository.save(runway);
        });
    }
}
