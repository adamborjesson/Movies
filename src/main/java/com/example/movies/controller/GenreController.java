package com.example.movies.controller;

import com.example.movies.model.Genre;
import com.example.movies.model.Movie;
import com.example.movies.service.GenreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenreController {

  @Autowired
  GenreService genreService;


  @GetMapping("/findgenres")
  public String getallGenres(Model model) {
    List<Genre> genres = genreService.getAllGenres();
    model.addAttribute("genrelist", genres);
    return "genres";
  }
  @RequestMapping("/deletegenre/{id}")
  public String deleteGenre(Model model, @PathVariable(value = "id") Long id) {
    try {
      genreService.delete(id);
    } catch (Exception e) {

    }
    List<Genre> genres = genreService.getAllGenres();
    model.addAttribute("genrelist", genres);
    return "genres";

  }
}
