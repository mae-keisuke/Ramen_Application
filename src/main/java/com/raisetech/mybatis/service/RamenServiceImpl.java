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

  public List<Ramen> findByPoint(Integer point) {
    return ramenMapper.getPoint(point);
  }

  public List<Ramen> getRamenList(Integer point) {
    if (point != null) {
      return ramenMapper.getPoint(point);
    } else {
      return ramenMapper.findAll();
    }
  }

  public void create(int id, String name, String address, Integer avePrice, Integer point) {
    ramenMapper.create(id, name, address, avePrice, point);
  }
  
  public void update(int id, String name, String address, Integer avePrice, Integer point) {
    ramenMapper.update(id, name, address, avePrice, point);
  }

  public void delete(int id) {
    ramenMapper.delete(id);
  }
}
