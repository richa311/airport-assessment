package com.airports.api.service;

import com.airports.api.data.model.Airport;
import com.airports.api.data.model.Country;
import com.airports.api.data.repository.AirportRepository;
import com.airports.api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public List<Airport> findByCountryCode(Country country) {
        Optional<List<Airport>> optionalAirports = airportRepository.findByIsoCountry(country.getCode());
        if (optionalAirports.isPresent() && !optionalAirports.get().isEmpty()) {
            return optionalAirports.get();
        } else {
            throw new NotFoundException(String.format("No airports found for country %s", country));
        }
    }

}
