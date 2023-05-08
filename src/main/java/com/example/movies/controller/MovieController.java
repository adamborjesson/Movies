package com.example.movies.controller;

import com.example.movies.model.Genre;
import com.example.movies.model.Movie;
import com.example.movies.service.GenreService;
import com.example.movies.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {


  MovieService movieService;
  GenreService genreService;

  @Autowired
  public MovieController(MovieService movieService, GenreService genreService) {
    this.movieService = movieService;
    this.genreService = genreService;
  }

  @GetMapping("/findall")
  public String findAllMovies(Model model) {

    List<Movie> movies = movieService.getAllMovies();
    model.addAttribute("movielist", movies);
    return "movies";
  }
  @GetMapping("/")
  public String backToHomePage(Model model) {
    return "index";
  }

  @GetMapping("/addmovie")
  public String addMovie(Model model) {
    Movie movie = new Movie();
    model.addAttribute("movie", movie);
    return "addmovie";
  }
  @PostMapping("/savemovie")
  public String saveMovie(Model model, @ModelAttribute("movie") Movie movie) {
    Genre genre = genreService.addGenre(movie.getGenre().getType(), movie);
    movie.setGenre(genre);
    movieService.addMovie(movie);
    genreService.addMovie(genre, movie);
    List<Movie> movies = movieService.getAllMovies();
    model.addAttribute("movielist", movies);
    return "movies";
  }
  @RequestMapping("/deletemovie/{id}")
  public String deleteMovie(Model model, @PathVariable(value = "id") Long id) {
    movieService.deleteMovie(id);
    List<Movie> movies = movieService.getAllMovies();
    model.addAttribute("movielist", movies);
    return "index";
  }
  @RequestMapping("/updatemovie/{id}")
  public String updateMovie(@PathVariable(value = "id") Long id, Model model) {
    Movie movie = movieService.getMovieById(id);
    model.addAttribute("movie", movie);

    return "updatemovie";
  }
  @PostMapping("/saveupdate")
  public String saveUpdate(Movie movie, Model model){
    Genre genre = genreService.addGenre(movie.getGenre().getType(), movie);
    movie.setGenre(genre);
    movieService.addMovie(movie);
    List<Movie> movies = movieService.getAllMovies();
    model.addAttribute("movielist", movies);
    return "movies";
  }
  @GetMapping("/moviesofgenre/{id}")
  public String getMoviesOfGenre(Model model, @PathVariable(value = "id") Long id) {
    Genre genre = genreService.getGenre(id);
    List<Movie> movies = movieService.getAllMoviesByGenre(genre);
    model.addAttribute("movielist", movies);
    return "movies";
  }

}
