package com.raisetech.mybatis.integrationtest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RamenRestApiIntegrationTest {
  @Autowired
  MockMvc mockMvc;

  @Test
  @DataSet(value = "datasets/itRamen.yml")
  @Transactional
  void it_全データが取得できること() throws Exception {
    String response = mockMvc.perform(MockMvcRequestBuilders.get("/ramens"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

    JSONAssert.assertEquals("""
        [
            {
                "id": 1,
                "name": "カドヤ食堂",
                "address": "大阪 西長堀",
                "avePrice": 980,
                "point": 9
            },
            {
                "id": 2,
                "name": "人類みな麺類",
                "address": "大阪 西中島南方",
                "avePrice": 800,
                "point": 10
            },
            {
                "id": 3,
                "name": "NOROMA",
                "address": "奈良 帯解",
                "avePrice": 850,
                "point": 10
            },
            {
                "id": 4,
                "name": "88",
                "address": "奈良 天理",
                "avePrice": 850,
                "point": 6
            },
            {
                "id": 5,
                "name": "たけ井",
                "address": "京都 城陽",
                "avePrice": 800,
                "point": 10
            },
            {
                "id": 6,
                "name": "俺のラーメンあっぱれ屋",
                "address": "京都 山城",
                "avePrice": 1000,
                "point": 8
            },
            {
                "id": 7,
                "name": "麺魚",
                "address": "東京 錦糸町",
                "avePrice": 1000,
                "point": 10
            },
            {
                "id": 8,
                "name": "一燈",
                "address": "東京 新小岩",
                "avePrice": 1000,
                "point": 10
            },
            {
                "id": 9,
                "name": "風神",
                "address": "東京 品川",
                "avePrice": 640,
                "point": 2
            },
            {
                "id": 10,
                "name": "千華",
                "address": "京都 福知山",
                "avePrice": 700,
                "point": 5
            }
        ]
        """, response, JSONCompareMode.STRICT
    );
  }

  @Test
  @DataSet(value = "datasets/itRamen.yml")
  @Transactional
  void it_ラーメンデータが登録できること() throws Exception {
    String result = mockMvc.perform(MockMvcRequestBuilders.post("/ramens")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content("""
                {
                    "id": 11,
                    "name": "天天有",
                    "address": "京都 一乗寺",
                    "avePrice": 600,
                    "point": 7
                }
                """))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

    JSONAssert.assertEquals("""
        {
            "message": "data successfully created"
        }
        """, result, JSONCompareMode.STRICT);
  }

  @Test
  @DataSet(value = "datasets/itRamen.yml")
  @Transactional
  void 指定したidのラーメンデータを更新できること() throws Exception {
    String result = mockMvc.perform(MockMvcRequestBuilders.patch("/ramens/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                "id": 1,
                "name": "kadoya食堂",
                "address": "大阪 西長堀",
                "avePrice": 980,
                "point": 9
                }
                """)).andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

    JSONAssert.assertEquals("""
        {
            "message": "data successfully updated"
        }
        """, result, JSONCompareMode.STRICT);
  }

  @Test
  @DataSet(value = "datasets/itRamen.yml")
  @Transactional
  void 指定したidのラーメンデータを削除できること() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/ramens/{id}", 2))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
