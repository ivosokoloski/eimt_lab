package mk.ukim.finki.wp.eimt_lab.service.domain;

import mk.ukim.finki.wp.eimt_lab.model.domain.Author;
import mk.ukim.finki.wp.eimt_lab.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country create(Country country);

    Optional<Country> update(Long id, Country country);

    Optional<Country> deleteById(Long id);

}
