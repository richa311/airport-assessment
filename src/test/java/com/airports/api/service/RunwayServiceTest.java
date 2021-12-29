package com.airports.api.service;

import com.airports.api.data.model.Runway;
import com.airports.api.data.repository.AirportRepository;
import com.airports.api.data.repository.CountryRepository;
import com.airports.api.data.repository.RunwayRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.airports.api.utils.AirportUtils.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RunwayServiceTest {

    @InjectMocks
    private RunwayService runwayService;

    @Mock
    private RunwayRepository runwayRepository;

    @Mock
    private CountryRepository countryRepository;

    @Mock
    private AirportRepository airportRepository;

    @Mock
    private CountryService countryService;

    @Mock
    private AirportService airportService;

    @Test
    void test_findRunwaysForAirports() {
        when(countryService.findCountry(COUNTRY)).thenReturn(buildCountryData());
        when(airportService.findByCountryCode(any())).thenReturn(buildAirportData());
        when(runwayRepository.findByAirportRefIn(any())).thenReturn(Optional.of(buildRunwayList()));
        Map<String, List<Runway>> map = runwayService.findRunwaysForAirports(COUNTRY);
        assertNotNull(map);

    }
}
