package mk.ukim.finki.wp.eimt_lab.service.domain;

import mk.ukim.finki.wp.eimt_lab.model.domain.Book;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService{
    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        return Optional.empty();
    }
}
