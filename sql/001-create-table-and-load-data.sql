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
