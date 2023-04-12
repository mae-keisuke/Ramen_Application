package com.raisetech.mybatis.mapper;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import com.raisetech.mybatis.entity.Ramen;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RamenMapperTest {

  @Autowired
  RamenMapper ramenMapper;

  @Test
  @DataSet(value = {"datasets/ramen.yml"})
  @Transactional
  public void findallで全データが取得されること() {
    List<Ramen> ramens = ramenMapper.findAll();
    List<Ramen> ramenList = List.of(ramens.get(0), ramens.get(1), ramens.get(2), ramens.get(3), ramens.get(4), ramens.get(5), ramens.get(6), ramens.get(7), ramens.get(8), ramens.get(9));
    assertThat(ramens).hasSize(10).isEqualTo(ramenList);
  }

  @Test
  @DataSet(value = {"datasets/ramen.yml"})
  @Transactional
  public void FindByPointで特定のポイントのデータが取得されること() {
    List<Ramen> ramens = ramenMapper.getPoint(9);
    assertNotNull(ramens);
    assertEquals(1, ramens.size());
  }

  @Test
  @DataSet(cleanBefore = true)
  public void ラーメンデータが登録できること() {
    Ramen ramen = new Ramen(1, "カドヤ食堂", "大阪 西長堀", 980, 9);
    ramenMapper.create(ramen);
    assertNotNull(ramen.getId());
  }

  @Test
  @DataSet(value = {"datasets/update.yml"})
  @ExpectedDataSet(value = "expectedAfterUpdateRamens.yml")
  public void ラーメンデータが更新できること() {
    ramenMapper.update(1, "カドヤ食堂", "大阪 西長堀", 980, 9);
  }

  @Test
  @DataSet(value = {"datasets/ramen.yml"})
  @ExpectedDataSet(value = "expectedAfterDeleteRamens.yml")
  public void ラーメンデータが消去できること() {
    assertThat(ramenMapper.findAll()).hasSize(10);
    ramenMapper.delete(1);
    assertThat(ramenMapper.findAll()).hasSize(9);
  }
}
