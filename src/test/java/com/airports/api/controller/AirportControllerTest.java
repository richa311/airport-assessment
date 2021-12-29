package com.airports.api.controller;

import com.airports.api.data.model.Country;
import com.airports.api.data.model.Runway;
import com.airports.api.service.CountryService;
import com.airports.api.service.RunwayService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.airports.api.utils.AirportUtils.COUNTRY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AirportControllerTest {

    @InjectMocks
    private AirportController controller;

    @Mock
    private CountryService countryService;

    @Mock
    private RunwayService runwayService;

    @Test
    void test_getRunwaysForAirports() {
        Map<String, List<Runway>> map = new HashMap<>();
        map.put(COUNTRY, new ArrayList<>());
        when(runwayService.findRunwaysForAirports(any())).thenReturn(map);
        ResponseEntity<Map<String, List<Runway>>> response = controller.getRunwaysForAirports(COUNTRY);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void test_getCountriesWithHighestNumberOfAirports() {
        List<Country> list = new ArrayList<>();
        list.add(new Country());
        when(countryService.findTopTenCountriesWithHighestNumberOfAirports()).thenReturn(list);
        ResponseEntity<List<Country>> response = controller.getCountriesWithHighestNumberOfAirports();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}
