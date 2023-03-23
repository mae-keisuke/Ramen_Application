package com.raisetech.mybatis.controller;

import com.raisetech.mybatis.entity.Ramen;

public class RamenResponse {

  private int id;

  private String name;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public RamenResponse(Ramen ramen) {
    this.id = ramen.getId();
    this.name = ramen.getName();
  }
}
