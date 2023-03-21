package com.raisetech.mybatis;

import java.util.List;


public interface MovieService {

  List<Movie> findAll();

  List<Movie> getPublishedYear(String published_year);
}
