package mk.ukim.finki.wp.eimt_lab.service.application.impl;

import mk.ukim.finki.wp.eimt_lab.model.domain.Author;
import mk.ukim.finki.wp.eimt_lab.model.domain.Country;
import mk.ukim.finki.wp.eimt_lab.model.dto.CreateAuthorDto;
import mk.ukim.finki.wp.eimt_lab.model.dto.CreateBookDto;
import mk.ukim.finki.wp.eimt_lab.model.dto.DisplayAuthorDto;
import mk.ukim.finki.wp.eimt_lab.model.dto.DisplayBookDto;
import mk.ukim.finki.wp.eimt_lab.model.exception.AuthorNotFoundException;
import mk.ukim.finki.wp.eimt_lab.service.application.AuthorApplicationService;
import mk.ukim.finki.wp.eimt_lab.service.application.BookApplicationService;
import mk.ukim.finki.wp.eimt_lab.service.domain.AuthorService;
import mk.ukim.finki.wp.eimt_lab.service.domain.BookService;
import mk.ukim.finki.wp.eimt_lab.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationServiceImpl implements AuthorApplicationService {
    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorApplicationServiceImpl(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }


    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService
                .findById(id)
                .map(DisplayAuthorDto::from);

    }

    @Override
    public List<DisplayAuthorDto> findAll() {
        return DisplayAuthorDto.from(authorService.findAll());


    }

    @Override
    public DisplayAuthorDto create(CreateAuthorDto createAuthorDto) {
        Country country = countryService
                .findById(createAuthorDto.countryId())
                .orElseThrow(() -> new AuthorNotFoundException(createAuthorDto.countryId()));
        return DisplayAuthorDto.from(authorService.create(createAuthorDto.toAuthor(country)));


    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto createAuthorDto) {
        Country country = countryService
                .findById(createAuthorDto.countryId())
                .orElseThrow(() -> new AuthorNotFoundException(createAuthorDto.countryId()));
                DisplayAuthorDto.from(authorService.create(createAuthorDto.toAuthor(country)));
        return authorService
                .update(id, createAuthorDto.toAuthor(country))
                .map(DisplayAuthorDto::from);

    }

    @Override
    public Optional<DisplayAuthorDto> deleteById(Long id) {
        return authorService
                .deleteById(id)
                .map(DisplayAuthorDto::from);

    }
}
