package com.airports.api.data.repository;

import com.airports.api.data.model.Runway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RunwayRepository extends CrudRepository<Runway, Long> {

    Optional<List<Runway>> findByAirportRefIn(List<Long> airportIds);
}
