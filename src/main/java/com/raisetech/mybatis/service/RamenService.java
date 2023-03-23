package com.raisetech.mybatis.service;

import com.raisetech.mybatis.controller.RamenResponse;
import com.raisetech.mybatis.entity.Ramen;

import java.util.List;


public interface RamenService {

  List<Ramen> findAll();

  List<Ramen> findByPoint(Integer point);

  List<RamenResponse> getRamenList(Integer point);

  void delete(int id);
}
