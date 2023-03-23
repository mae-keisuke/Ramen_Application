DROP TABLE IF EXISTS ramens;

CREATE TABLE ramens (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  address VARCHAR(20) NOT NULL,
  ave_price int NOT NULL,
  point int NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO ramens (id, name, address, ave_price, point) VALUES (1, "カドヤ食堂","大阪 西長堀",980,9);
INSERT INTO ramens (id, name, address, ave_price, point) VALUES (2, "人類みな麺類","大阪 西中島南方",800, 10);
INSERT INTO ramens (id, name, address, ave_price, point) VALUES (3, "NOROMA","奈良 帯解",850,10);
INSERT INTO ramens (id, name, address, ave_price, point) VALUES (4, "88","奈良 天理",850,6);
INSERT INTO ramens (id, name, address, ave_price, point) VALUES (5, "たけ井","京都 城陽",800,10);
INSERT INTO ramens (id, name, address, ave_price, point) VALUES (6, "俺のラーメンあっぱれ屋","京都 山城",1000,8);
INSERT INTO ramens (id, name, address, ave_price, point) VALUES (7, "麺魚","東京 錦糸町",1000,10);
INSERT INTO ramens (id, name, address, ave_price, point) VALUES (8, "一燈","東京 新小岩",1000,10);
INSERT INTO ramens (id, name, address, ave_price, point) VALUES (9, "風神","東京 品川",640,2);
INSERT INTO ramens (id, name, address, ave_price, point) VALUES (10, "千華","京都 福知山",700,5);
