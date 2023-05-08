package com.example.movies.service;

import com.example.movies.model.Genre;
import com.example.movies.model.Movie;
import com.example.movies.repository.GenreRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class GenreService {

  @Autowired
  GenreRepository genreRepository;

  public Genre addGenre(String type, Movie movie) {
    if(genreRepository.findByType(type).isEmpty()) {
      Genre genre = new Genre();
      genre.setType(type);
      List<Movie> movies = new ArrayList<>();
      genre.setMovies(movies);
      return genreRepository.save(genre);

    }
    return genreRepository.findByType(type).get();
  }

  public void addMovie(Genre genre, Movie movie) {
    genre.getMovies().add(movie);
    genreRepository.save(genre);
  }

  public List<Genre> getAllGenres() {
    return (List<Genre>) genreRepository.findAll();
  }

  public Genre getGenre(Long id) {
    return genreRepository.findById(id).get();
  }

  public void delete(Long id) {

      Genre genre = genreRepository.findById(id).get();
      genreRepository.delete(genre);

  }
}
