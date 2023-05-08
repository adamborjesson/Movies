package com.example.movies.repository;

import com.example.movies.model.Genre;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {

  Optional<Genre> findByType(String type);
}
