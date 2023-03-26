package com.raisetech.mybatis.entity;

public class Ramen {

  private int id;

  private String name;

  private String address;

  private Integer avePrice;

  private Integer point;

  public Ramen(int id, String name, String address, Integer avePrice, Integer point) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.avePrice = avePrice;
    this.point = point;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public Integer getAvePrice() {
    return avePrice;
  }

  public Integer getPoint() {
    return point;
  }
}
