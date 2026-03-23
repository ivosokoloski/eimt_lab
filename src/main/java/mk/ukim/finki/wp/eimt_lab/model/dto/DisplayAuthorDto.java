package mk.ukim.finki.wp.eimt_lab.model.dto;

import mk.ukim.finki.wp.eimt_lab.model.domain.Author;
import mk.ukim.finki.wp.eimt_lab.model.domain.Book;
import mk.ukim.finki.wp.eimt_lab.model.domain.BookCategory;
import mk.ukim.finki.wp.eimt_lab.model.domain.BookState;

import java.util.List;

public record DisplayAuthorDto(
        Long id,
        String name,
        String surname,
        Long country_id
) {
    public static DisplayAuthorDto from(Author author){
        return  new DisplayAuthorDto(
                author.getId(),
                author.getName(),
                author.getSurname(),
                author.getCountry().getId()
        );
    }
    public static List<DisplayAuthorDto> from(List<Author> authors){
        return authors.stream().map(DisplayAuthorDto::from).toList();
    }

}
