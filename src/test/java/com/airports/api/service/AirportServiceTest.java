package com.airports.api.service;

import com.airports.api.data.model.Airport;
import com.airports.api.data.repository.AirportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.airports.api.utils.AirportUtils.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {

    @InjectMocks
    private AirportService service;

    @Mock
    private AirportRepository airportRepository;

    @Test
    void test_findByCountryCode() {
        when(airportRepository.findByIsoCountry(COUNTRY)).thenReturn(Optional.of(buildAirportData()));
        List<Airport> airports = service.findByCountryCode(buildCountryData());
        assertNotNull(airports);
    }
}
