package mk.ukim.finki.wp.eimt_lab.model.dto;

import mk.ukim.finki.wp.eimt_lab.model.domain.Author;
import mk.ukim.finki.wp.eimt_lab.model.domain.Country;

public record CreateCountryDto(
        String name,
        String continent
) {
    public Country toCountry(){
        return new Country(name,continent);
    }
}
