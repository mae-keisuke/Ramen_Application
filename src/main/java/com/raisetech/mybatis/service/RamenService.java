package com.raisetech.mybatis.service;

import com.raisetech.mybatis.entity.Ramen;

import java.util.List;


public interface RamenService {

  List<Ramen> findAll();

  List<Ramen> findByPoint(Integer point);

  List<Ramen> getRamenList(Integer point);

  void create(Ramen ramen);

  void update(Integer id, String name, String address, Integer avePrice, Integer point);

  void delete(Integer id);
}
