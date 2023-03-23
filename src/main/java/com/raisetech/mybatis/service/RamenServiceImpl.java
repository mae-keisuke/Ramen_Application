package com.raisetech.mybatis.service;

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

  public List<Ramen> getPoint(Integer point) {
    return ramenMapper.getPoint(point);
  }

  public void delete(int id) {
    
  }
}
