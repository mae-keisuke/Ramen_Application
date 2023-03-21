package com.raisetech.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper {
  @Select("SELECT * FROM movies")
  List<Movie> findAll();

  @Select("SELECT * FROM movies where published_year = #{published_year}")
  List<Movie> getPublishedYear(String published_year);
}
