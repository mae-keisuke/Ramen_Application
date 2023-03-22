package com.raisetech.mybatis.service;

import com.raisetech.mybatis.entity.Movie;
import com.raisetech.mybatis.mapper.MovieMapper;
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

  public List<Movie> getPublishedYear(String publishedYear) {
    return movieMapper.getPublishedYear(publishedYear);
  }
}
