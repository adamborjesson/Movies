package com.example.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  private String type;
  @OneToMany(mappedBy = "genre")
  private List<Movie> Movies;

  public Genre(String type, List<Movie> movies) {
    this.type = type;
    Movies = movies;
  }

  public Genre() {
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<Movie> getMovies() {
    return Movies;
  }

  public void setMovies(List<Movie> movies) {
    Movies = movies;
  }
}
