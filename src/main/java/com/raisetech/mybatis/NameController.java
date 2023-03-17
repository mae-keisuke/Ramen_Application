package com.raisetech.mybatis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

  private final NameMapper nameMapper;

  public NameController(NameMapper nameMapper) {
    this.nameMapper = nameMapper;
  }

  @GetMapping("/names")
  public List<Name> names() {
    return nameMapper.findAll();
  }


}
