package com.raisetech.mybatis;

public class MovieResponse {

  private int id;

  private String name;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public MovieResponse(Movie movie) {
    this.id = movie.getId();
    this.name = movie.getName();


  }
}
