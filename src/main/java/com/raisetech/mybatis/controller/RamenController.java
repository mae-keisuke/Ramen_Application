package com.raisetech.mybatis.controller;

import com.raisetech.mybatis.service.RamenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RamenController {

  private RamenService ramenService;

  public RamenController(RamenService ramenService) {
    this.ramenService = ramenService;
  }

  @GetMapping("/ramens")
  public List<RamenResponse> ramens(@RequestParam(value = "point", required = false) Integer point) {
    if (point != null) {
      return ramenService.getPoint(point).stream().map(RamenResponse::new).toList();
    } else {
      return ramenService.findAll().stream().map(RamenResponse::new).toList();
    }
  }
}
