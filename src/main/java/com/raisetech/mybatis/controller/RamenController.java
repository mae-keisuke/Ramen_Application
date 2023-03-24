package com.raisetech.mybatis.controller;

import com.raisetech.mybatis.entity.Ramen;
import com.raisetech.mybatis.service.RamenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RamenController {

  private RamenService ramenService;

  public RamenController(RamenService ramenService) {
    this.ramenService = ramenService;
  }

  @GetMapping("/ramens")
  public List<Ramen> ramens(@RequestParam(value = "point", required = false) Integer point) {
    return ramenService.getRamenList(point);
  }

  @DeleteMapping("/ramens/{id}")
  public ResponseEntity<Map<String, String>> deleteRamen(@PathVariable("id") int id) {
    ramenService.delete(id);
    return ResponseEntity.ok(Map.of("message", "data successfully deleted"));
  }
}
