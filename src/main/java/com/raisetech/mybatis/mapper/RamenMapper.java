package com.raisetech.mybatis.mapper;

import com.raisetech.mybatis.entity.Ramen;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RamenMapper {
  @Select("SELECT * FROM ramens")
  List<Ramen> findAll();

  @Select("SELECT * FROM ramens WHERE point = #{point}")
  List<Ramen> getPoint(Integer point);

  @Update("UPDATE ramens SET name = #{name}, address = #{address}, ave_price = #{avePrice}, point = #{point} WHERE id = #{id}")
  void update(int id, String name, String address, Integer avePrice, Integer point);

  @Delete("DELETE FROM ramens WHERE id = #{id}")
  void delete(int id);
}
