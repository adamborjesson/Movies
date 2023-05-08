package com.example.movies.repository;

import com.example.movies.model.Genre;
import com.example.movies.model.Movie;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface MovieRepository extends CrudRepository<Movie, Long> {

   Optional<List<Movie>> findAllByGenre(Genre genre);
}
