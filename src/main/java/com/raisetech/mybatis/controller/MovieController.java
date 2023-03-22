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
  public List<MovieResponse> movies(@RequestParam(value = "published_year", required = false) String publishedYear) {
    if (publishedYear != null) {
      return movieService.getPublishedYear(publishedYear).stream().map(MovieResponse::new).toList();
    } else {
      return movieService.findAll().stream().map(MovieResponse::new).toList();
    }
  }
}
