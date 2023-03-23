package com.raisetech.mybatis.mapper;

import com.raisetech.mybatis.entity.Ramen;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RamenMapper {
  @Select("SELECT * FROM ramens")
  List<Ramen> findAll();

  @Select("SELECT * FROM ramens where point = #{point}")
  List<Ramen> getPoint(Integer point);

  @Delete("DELETE FROM ramens where id = #{id}")
  void delete(int id);
}
