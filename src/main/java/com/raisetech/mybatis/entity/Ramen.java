package com.raisetech.mybatis.entity;

public class Ramen {

  private int id;

  private String name;

  private String address;

  private int avePrice;

  private int point;

  public Ramen(int id, String name, String address, int avePrice, int point) {
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

  public int getAvePrice() {
    return avePrice;
  }

  public int getPoint() {
    return point;
  }
}
