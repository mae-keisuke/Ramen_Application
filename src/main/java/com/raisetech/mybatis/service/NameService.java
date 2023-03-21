package com.raisetech.mybatis.service;

import com.raisetech.mybatis.entity.Name;

import java.util.List;


public interface NameService {

  List<Name> findAll();
}
