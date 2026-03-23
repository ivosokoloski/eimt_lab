package mk.ukim.finki.wp.eimt_lab.service.application.impl;

import mk.ukim.finki.wp.eimt_lab.model.domain.Author;
import mk.ukim.finki.wp.eimt_lab.model.dto.CreateBookDto;
import mk.ukim.finki.wp.eimt_lab.model.dto.CreateCountryDto;
import mk.ukim.finki.wp.eimt_lab.model.dto.DisplayBookDto;
import mk.ukim.finki.wp.eimt_lab.model.dto.DisplayCountryDto;
import mk.ukim.finki.wp.eimt_lab.model.exception.AuthorNotFoundException;
import mk.ukim.finki.wp.eimt_lab.service.application.BookApplicationService;
import mk.ukim.finki.wp.eimt_lab.service.application.CountryApplicationService;
import mk.ukim.finki.wp.eimt_lab.service.domain.AuthorService;
import mk.ukim.finki.wp.eimt_lab.service.domain.BookService;
import mk.ukim.finki.wp.eimt_lab.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {
    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }


    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService
                .findById(id)
                .map(DisplayCountryDto::from);

    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(countryService.findAll());


    }

    @Override
    public DisplayCountryDto create(CreateCountryDto createCountryDto) {
        return DisplayCountryDto.from(countryService.create(createCountryDto.toCountry()));


    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return countryService
                .update(id, createCountryDto.toCountry())
                .map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> deleteById(Long id) {
        return countryService
                .deleteById(id)
                .map(DisplayCountryDto::from);

    }
}
