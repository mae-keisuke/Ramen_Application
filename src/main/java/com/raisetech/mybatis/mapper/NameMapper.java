package com.raisetech.mybatis.mapper;

import com.raisetech.mybatis.entity.Name;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NameMapper {
  @Select("SELECT * FROM names")
  List<Name> findAll();
}
