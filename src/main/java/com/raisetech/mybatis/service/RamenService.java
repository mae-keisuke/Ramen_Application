package com.raisetech.mybatis.service;

import com.raisetech.mybatis.entity.Ramen;

import java.util.List;


public interface RamenService {

  List<Ramen> findAll();

  List<Ramen> getPoint(Integer point);

  void delete(int id);
}
