package com.raisetech.mybatis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

  private NameService nameService;

  public NameController(NameService nameService) {
    this.nameService = nameService;
  }

  @GetMapping("/names")
  public List<NameResponse> names() {
    return nameService.findAll().stream().map(NameResponse::new).toList();
  }


}
