package com.raisetech.mybatis.entity;

public class Movie {

  private int id;

  private String name;

  private String published_year;

  public Movie(int id, String name, String published_year) {
    this.id = id;
    this.name = name;
    this.published_year = published_year;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPublished_year() {
    return published_year;
  }
}
