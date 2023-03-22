package com.raisetech.mybatis.entity;

public class Movie {

  private int id;

  private String name;

  private String publishedYear;

  public Movie(int id, String name, String publishedYear) {
    this.id = id;
    this.name = name;
    this.publishedYear = publishedYear;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPublishedYear() {
    return publishedYear;
  }
}
