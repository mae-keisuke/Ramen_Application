package com.raisetech.mybatis.service;

import com.raisetech.mybatis.entity.Ramen;
import com.raisetech.mybatis.mapper.RamenMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RamenServiceImplTest {

  @InjectMocks
  RamenServiceImpl ramenServiceImpl;

  @Mock
  RamenMapper ramenMapper;

  @Test
  public void findallで全データが取得されること() {
    List<Ramen> ramenList = new ArrayList<>();
    ramenList.add(new Ramen(1, "カドヤ食堂", "大阪 西長堀", 980, 9));
    ramenList.add(new Ramen(2, "人類みな麺類", "大阪 西中島南方", 800, 10));
    ramenList.add(new Ramen(3, "NOROMA", "奈良 帯解", 850, 10));
    ramenList.add(new Ramen(4, "88", "奈良 天理", 850, 6));
    ramenList.add(new Ramen(5, "たけ井", "京都 城陽", 800, 10));
    ramenList.add(new Ramen(6, "俺のラーメンあっぱれ屋", "京都 山城", 1000, 8));
    ramenList.add(new Ramen(7, "麺魚", "東京 錦糸町", 1000, 10));
    ramenList.add(new Ramen(8, "一燈", "東京 新小岩", 1000, 10));
    ramenList.add(new Ramen(9, "風神", "東京 品川", 640, 2));
    ramenList.add(new Ramen(10, "千華", "京都 福知山", 700, 5));
    doReturn(ramenList).when(ramenMapper).findAll();
    List<Ramen> actual = ramenServiceImpl.findAll();
    assertThat(actual).isEqualTo(ramenList);
  }

  @Test
  public void FindByPointで特定のポイントのデータが取得されること() {
    List<Ramen> ramenList = new ArrayList<>();
    ramenList.add(new Ramen(1, "カドヤ食堂", "大阪 西長堀", 980, 9));
    when(ramenMapper.getPoint(9)).thenReturn(ramenList);
    List<Ramen> actual = ramenServiceImpl.findByPoint(9);
    assertThat(actual).isEqualTo(ramenList);
  }

  @Test
  public void FindByPointで該当するデータがないときに空のリストが取得されること() {
    when(ramenMapper.getPoint(11)).thenReturn(Collections.emptyList());
    List<Ramen> actual = ramenServiceImpl.findByPoint(11);
    assertThat(actual).isEmpty();
  }

  @Test
  public void ラーメンデータが登録できること() {
    Ramen ramenEntity = Ramen.newInstance("カドヤ食堂", "大阪 西長堀", 980, 9);
    doNothing().when(ramenMapper).create(ramenEntity);
    ramenServiceImpl.create(ramenEntity);
    verify(ramenMapper).create(ramenEntity);
  }


  @Test
  public void ラーメンデータが更新できること() {
    int ramenId = 1;
    String ramenName = "カドヤ食堂";
    String ramenAddress = "大阪 西長堀";
    int ramenAvePrice = 980;
    int ramenPoint = 9;
    Ramen updatedRamen = new Ramen(ramenId, ramenName, ramenAddress, ramenAvePrice, ramenPoint);
    doNothing().when(ramenMapper).update(ramenId, ramenName, ramenAddress, ramenAvePrice, ramenPoint);
    ramenServiceImpl.update(ramenId, ramenName, ramenAddress, ramenAvePrice, ramenPoint);
    verify(ramenMapper).update(ramenId, ramenName, ramenAddress, ramenAvePrice, ramenPoint);
  }

  @Test
  public void ラーメンデータが消去できること() {
    int ramenId = 1;
    doNothing().when(ramenMapper).delete(ramenId);
    ramenServiceImpl.delete(ramenId);
    verify(ramenMapper).delete(ramenId);
  }
}



