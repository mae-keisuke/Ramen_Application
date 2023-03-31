package com.raisetech.mybatis.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class Ramen {

  private Integer id;

  private String name;

  private String address;

  private Integer avePrice;

  @Min(1)
  @Max(10)
  private Integer point;

  public static Ramen newInstance(String name, String address, Integer avePrice, Integer point) {
    return new Ramen(null, name, address, avePrice, point);
  }

  public Ramen(Integer id, String name, String address, Integer avePrice, Integer point) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.avePrice = avePrice;
    this.point = point;
  }

  public Integer getId() {
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

  public void setId(Integer id) {
    this.id = id;
  }
}
