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
    assertThat(ramens).hasSize(10).contains(new Ramen(1, "カドヤ食堂", "大阪 西長堀", 980, 9), new Ramen(2, "人類みな麺類", "大阪 西中島南方", 800, 10), new Ramen(3, "NOROMA", "奈良 帯解", 850, 10), new Ramen(4, "88", "奈良 天理", 850, 6), new Ramen(5, "たけ井", "京都 城陽", 800, 10), new Ramen(6, "俺のラーメンあっぱれ屋", "京都 山城", 1000, 8), new Ramen(7, "麺魚", "東京 錦糸町", 1000, 10), new Ramen(8, "一燈", "東京 新小岩", 1000, 10), new Ramen(9, "風神", "東京 品川", 640, 2), new Ramen(10, "千華", "京都 福知山", 700, 5));
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
