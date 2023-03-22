package com.raisetech.mybatis.service;

import com.raisetech.mybatis.entity.Movie;

import java.util.List;


public interface MovieService {

  List<Movie> findAll();

  List<Movie> getPublishedYear(String publishedYear);
}
