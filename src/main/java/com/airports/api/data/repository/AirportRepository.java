package com.airports.api.data.repository;

import com.airports.api.data.model.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

    Optional<List<Airport>> findByIsoCountry(String code);

    @Query("SELECT a.isoCountry FROM Airport a GROUP BY a.isoCountry ORDER BY COUNT(a) DESC")
    List<String> countriesWithHighestNumberOfAirports();
}
