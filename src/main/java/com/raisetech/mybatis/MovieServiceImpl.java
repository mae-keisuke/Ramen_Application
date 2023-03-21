package com.raisetech.mybatis;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

  private MovieMapper movieMapper;

  public MovieServiceImpl(MovieMapper movieMapper) {
    this.movieMapper = movieMapper;
  }

  public List<Movie> findAll() {
    return movieMapper.findAll();
  }

  public List<Movie> getPublishedYear(String published_year) {
    return movieMapper.getPublishedYear(published_year);
  }
}
  

