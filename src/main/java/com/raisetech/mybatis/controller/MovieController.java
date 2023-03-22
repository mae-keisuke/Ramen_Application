package com.raisetech.mybatis.controller;

import com.raisetech.mybatis.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

  private MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("/movies")
  public List<MovieResponse> movies() {
    return movieService.findAll().stream().map(MovieResponse::new).toList();
  }

  @GetMapping("/movies2")
  public List<MovieResponse> movies(@RequestParam("published_year") String publishedYear) {
    return movieService.getPublishedYear(publishedYear).stream().map(MovieResponse::new).toList();
  }
}
