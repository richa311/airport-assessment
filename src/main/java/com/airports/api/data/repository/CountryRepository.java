package com.airports.api.data.repository;

import com.airports.api.data.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    Optional<List<Country>> findByNameContainingIgnoreCase(String name);

    Optional<Country> findByCodeIgnoreCase(String code);

    Optional<List<Country>> findByCodeIn(List<String> collect);

    List<Country> findByIdIn(List<Long> countryIds);
}
