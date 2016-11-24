CREATE TABLE IF NOT EXISTS towns(
  town_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  country VARCHAR(50)
 );

CREATE TABLE IF NOT EXISTS  minions(
  minion_id INT AUTO_INCREMENT PRIMARY KEY,
  minion_name VARCHAR(50),
  age INT,
  town_id INT,
  CONSTRAINT fk_minions_towns FOREIGN KEY (town_id) REFERENCES towns (town_id)
);

CREATE TABLE IF NOT EXISTS villains(
  villain_id INT AUTO_INCREMENT PRIMARY KEY,
  villain_name VARCHAR(50),
  evilness_factor ENUM ('good', 'bad', 'evil', 'super evil')
);

CREATE TABLE IF NOT EXISTS villains_minions(
  villain_id INT,
  minion_id INT,
  CONSTRAINT PK_villains_minions PRIMARY KEY (villain_id,minion_id),
  CONSTRAINT FK_villains_minions_villains FOREIGN KEY(villain_id) REFERENCES villains(villain_id),
  CONSTRAINT FK_villains_minions_minions FOREIGN KEY (minion_id) REFERENCES minions(minion_id)
);



INSERT INTO towns(name,country)
VALUES ('Sofia','Bulgaria'),
  ('Plovdiv','Bulgaria'),
  ('Varna','Bulgaria'),
  ('Ruse','Bulgaria'),
  ('London','England'),
  ('Glasgow','Scotland'),
  ('Dundee','Scotland');

INSERT INTO  minions (minion_name, age, town_id)
VALUES ('One',10,1),
  ('Two',20,1),
  ('Three',30,1),
  ('Four',40,2),
  ('Five',50,3),
  ('Six',60,3),
  ('Seven',70,4),
  ('Eight',80,5);


INSERT INTO villains(villain_name, evilness_factor)
VALUES ('Gru','good'),
  ('Victor','evil'),
  ('Jilly','super evil');

INSERT INTO
