package mk.ukim.finki.wp.eimt_lab.service.domain.impl;

import mk.ukim.finki.wp.eimt_lab.model.domain.Author;
import mk.ukim.finki.wp.eimt_lab.model.domain.Country;
import mk.ukim.finki.wp.eimt_lab.repository.AuthorRepository;
import mk.ukim.finki.wp.eimt_lab.repository.CountryRepository;
import mk.ukim.finki.wp.eimt_lab.service.domain.AuthorService;
import mk.ukim.finki.wp.eimt_lab.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
               return countryRepository
                       .findById(id)
                    .map((existingAuthor) -> {
                    existingAuthor.setName(country.getName());
                    existingAuthor.setContinent(country.getContinent());
                    return countryRepository.save(existingAuthor);
                });

    }

    @Override
    public Optional<Country> deleteById(Long id) {
        Optional<Country> author = countryRepository.findById(id);
        author.ifPresent(countryRepository::delete);
        return author;
    }
}
