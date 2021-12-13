--no es necesario crear la clase entity

CREATE TABLE person (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  age INTEGER NOT NULL,
  weight DOUBLE NOT NULL
);

INSERT INTO person (name, age, weight) VALUES
  ('Abi', 34, 67.5);