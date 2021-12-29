package com.airports.api.utils;

import com.airports.api.data.model.Airport;
import com.airports.api.data.model.Country;
import com.airports.api.data.model.Runway;

import java.util.ArrayList;
import java.util.List;

public class AirportUtils {

    public static String COUNTRY = "AD";
    public static String CONTINENT = "EU";

    public static Country buildCountryData() {
        return Country.builder().code(COUNTRY).continent(CONTINENT).build();
    }

    public static List<Airport> buildAirportData() {
        Airport airport = Airport.builder().name("Andorra la Vella Heliport").continent(CONTINENT).build();
        List<Airport> airports = new ArrayList<>();
        airports.add(airport);
        return airports;
    }

    public static List<String> topCountriesData() {
        List<String> countries = new ArrayList<>();
        countries.add(COUNTRY);
        countries.add("US");
        return countries;
    }

    public static List<Country> buildCountryList() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(buildCountryData());
        return countryList;
    }

    public static List<Runway> buildRunwayList() {
        List<Runway> runwayList = new ArrayList<>();
        runwayList.add(Runway.builder().airportRef(6523L).build());
        return runwayList;
    }
}
