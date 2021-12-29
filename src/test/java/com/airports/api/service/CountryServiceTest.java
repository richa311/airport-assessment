package com.airports.api.service;

import com.airports.api.data.model.Country;
import com.airports.api.data.repository.AirportRepository;
import com.airports.api.data.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.airports.api.utils.AirportUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @InjectMocks
    private CountryService service;

    @Mock
    private CountryRepository countryRepository;

    @Mock
    private AirportRepository airportRepository;

    @Test
    void test_findCountry() {
        when(countryRepository.findByCodeIgnoreCase(COUNTRY)).thenReturn(Optional.of(buildCountryData()));
        Country country = service.findCountry(COUNTRY);
        assertNotNull(country.getCode());
    }

    @Test
    void test_findTopTenCountriesWithHighestNumberOfAirports() {
        when(airportRepository.countriesWithHighestNumberOfAirports()).thenReturn(topCountriesData());
        when(countryRepository.findByCodeIn(any())).thenReturn(Optional.of(buildCountryList()));
        List<Country> country = service.findTopTenCountriesWithHighestNumberOfAirports();
        assertNotNull(country);
        assertEquals(COUNTRY,
                country.get(0).getCode());
    }
}
