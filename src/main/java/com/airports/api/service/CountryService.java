package com.airports.api.service;

import com.airports.api.data.model.Country;
import com.airports.api.data.repository.AirportRepository;
import com.airports.api.data.repository.CountryRepository;
import com.airports.api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryService {

    private final AirportRepository airportRepository;
    private final CountryRepository countryRepository;

    public Country findCountry(String country) {
        Optional<Country> optionalCountry = countryRepository.findByCodeIgnoreCase(country);
        if (!optionalCountry.isPresent()) {
            Optional<List<Country>> optionalCountryList = countryRepository.findByNameContainingIgnoreCase(country);
            if (optionalCountryList.isPresent() && !optionalCountryList.get().isEmpty()) {
                log.info("Found country: {} that roughly matches the search string", optionalCountryList.get().get(0).getName());
                return optionalCountryList.get().get(0);
            } else {
                throw new NotFoundException(String.format("No country found with code or name as %s", country));
            }
        }
        log.info("Found country : {} for code : {} that matches the search string",
                optionalCountry.get().getName(), optionalCountry.get().getCode());
        return optionalCountry.get();
    }

    public List<Country> findTopTenCountriesWithHighestNumberOfAirports() {
        List<String> countryIds = airportRepository.countriesWithHighestNumberOfAirports().stream().limit(10).collect(Collectors.toList());
        log.debug("TopTenCountriesWithHighestNumberOfAirports => {}", countryIds);
        return countryRepository.findByCodeIn(countryIds).get();
    }

}
