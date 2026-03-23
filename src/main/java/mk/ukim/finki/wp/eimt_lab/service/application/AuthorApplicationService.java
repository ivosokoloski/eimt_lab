package mk.ukim.finki.wp.eimt_lab.service.application;

import mk.ukim.finki.wp.eimt_lab.model.dto.*;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    Optional<DisplayAuthorDto> findById(Long id);

    List<DisplayAuthorDto> findAll();

    DisplayAuthorDto create(CreateAuthorDto createAuthorDto);

    Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto createAuthorDto);

    Optional<DisplayAuthorDto> deleteById(Long id);
}
