package com.raisetech.mybatis.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ramen ramen = (Ramen) o;
    return Objects.equals(id, ramen.id) && Objects.equals(name, ramen.name) && Objects.equals(address, ramen.address) && Objects.equals(avePrice, ramen.avePrice) && Objects.equals(point, ramen.point);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, avePrice, point);
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
}
