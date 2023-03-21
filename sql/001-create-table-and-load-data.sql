DROP TABLE IF EXISTS names;

CREATE TABLE names (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  address VARCHAR(20),
  PRIMARY KEY(id)
);

INSERT INTO names (id, name, address) VALUES (1, "koyama","tokyo");
INSERT INTO names (id, name, address) VALUES (2, "tanaka","osaka");
INSERT INTO names (id, name, address) VALUES (3, "suzuki","hokkaido");

DROP TABLE IF EXISTS movies;

CREATE TABLE movies (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  published_year VARCHAR(20),
  PRIMARY KEY(id)
);

INSERT INTO movies (id, name, published_year) VALUES (1, "アルマゲドン",2000);
INSERT INTO movies (id, name, published_year) VALUES (2, "トイストーリー2",2000);
INSERT INTO movies (id, name, published_year) VALUES (3, "インセプション",2010);