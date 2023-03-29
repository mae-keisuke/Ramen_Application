package com.raisetech.mybatis.controller;

import com.raisetech.mybatis.entity.Ramen;
import com.raisetech.mybatis.service.RamenService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Validated
@RestController
public class RamenController {

  private RamenService ramenService;

  public RamenController(RamenService ramenService) {
    this.ramenService = ramenService;
  }

  @GetMapping("/ramens")
  public List<Ramen> getRamen(@RequestParam(value = "point", required = false) Integer point) {
    return ramenService.getRamenList(point);
  }

  @PostMapping("/ramens")
  public ResponseEntity<Map<String, String>> createRamen(@Validated @RequestBody Ramen ramen, UriComponentsBuilder uriBuilder) {
    ramenService.create(ramen.getName(), ramen.getAddress(), ramen.getAvePrice(), ramen.getPoint());
    URI url = uriBuilder.path("/ramens/" + ramen.getId()).build().toUri();
    return ResponseEntity.created(url).body(Map.of("message", "data successfully created"));
  }

  @PatchMapping("/ramens/id")
  public ResponseEntity<Map<String, String>> updateRamen(@PathVariable("id") int id, @Validated @RequestBody Ramen ramen) {
    ramenService.update(id, ramen.getName(), ramen.getAddress(), ramen.getAvePrice(), ramen.getPoint());
    return ResponseEntity.ok(Map.of("message", "data successfully updated"));
  }

  @DeleteMapping("/ramens/{id}")
  public ResponseEntity<Map<String, String>> deleteRamen(@PathVariable("id") int id) {
    ramenService.delete(id);
    return ResponseEntity.ok(Map.of("message", "data successfully deleted"));
  }
}
