package com.raisetech.mybatis.service;

import com.raisetech.mybatis.controller.RamenResponse;
import com.raisetech.mybatis.entity.Ramen;
import com.raisetech.mybatis.mapper.RamenMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamenServiceImpl implements RamenService {

  private RamenMapper ramenMapper;

  public RamenServiceImpl(RamenMapper movieMapper) {
    this.ramenMapper = movieMapper;
  }

  public List<Ramen> findAll() {
    return ramenMapper.findAll();
  }

  public List<Ramen> findByPoint(Integer point) {
    return ramenMapper.getPoint(point);
  }

  public List<RamenResponse> getRamenList(Integer point) {
    if (point != null) {
      return findByPoint(point).stream().map(RamenResponse::new).toList();
    } else {
      return findAll().stream().map(RamenResponse::new).toList();
    }
  }

  public void delete(int id) {

  }
}