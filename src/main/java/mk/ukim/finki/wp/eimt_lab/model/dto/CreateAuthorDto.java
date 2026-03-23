package mk.ukim.finki.wp.eimt_lab.model.dto;

import mk.ukim.finki.wp.eimt_lab.model.domain.*;

public record CreateAuthorDto(
        String name,
        String surname,
        Long countryId
) {
    public Author toAuthor(Country country){
        return new Author(name,surname,country);
    }
}
