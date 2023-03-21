package com.raisetech.mybatis;

public class NameResponse {

  private int id;

  private String name;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public NameResponse(Name name) {
    this.id = name.getId();
    this.name = name.getName();


  }
}
