package com.example.movies.service;

import com.example.movies.model.Genre;
import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired
  MovieRepository movieRepository;

  public List<Movie> getAllMovies() {
    return (List<Movie>) movieRepository.findAll();
  }

  public void addMovie(Movie movie) {
    movieRepository.save(movie);
  }

  public void deleteMovie(Long id) {
    movieRepository.deleteById(id);
  }

  public Movie getMovieById(Long id) {

    return movieRepository.findById(id).get();
  }

  public List<Movie> getAllMoviesByGenre(Genre genre) {
    return movieRepository.findAllByGenre(genre).get();
  }
}
