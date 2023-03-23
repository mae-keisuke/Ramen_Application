package com.raisetech.mybatis.controller;

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
  public List<RamenResponse> ramens(@RequestParam(value = "point", required = false) Integer point) {
    if (point != null) {
      return ramenService.findByPoint(point).stream().map(RamenResponse::new).toList();
    } else {
      return ramenService.findAll().stream().map(RamenResponse::new).toList();
    }
  }

  @DeleteMapping("/ramens/{id}")
  public ResponseEntity<Map<String, String>> deleteRamen(@PathVariable("id") int id) {
    ramenService.delete(id);
    return ResponseEntity.ok(Map.of("message", "data successfully deleted"));
  }
}
