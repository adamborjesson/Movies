package com.example.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String director;
  private String yearOfRelease;
  private double length;
  @ManyToOne
  private Genre genre;

  public Movie(String title, String director, String yearOfRelease, double length, Genre genre) {
    this.title = title;
    this.director = director;
    this.yearOfRelease = yearOfRelease;
    this.length = length;
    this.genre = genre;
  }

  public Movie() {

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getYearOfRelease() {
    return yearOfRelease;
  }

  public void setYearOfRelease(String yearOfRelease) {
    this.yearOfRelease = yearOfRelease;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }


}
