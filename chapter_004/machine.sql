CREATE TABLE carcass(
	id serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE motor(
	id serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE transmission(
	id serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE machine(
	id serial PRIMARY KEY,
	name varchar(50),
	id_carcass int REFERENCES carcass(id),
	id_transmission int REFERENCES transmission(id),
	id_motor int REFERENCES motor(id)
);

INSERT INTO carcass (name)
VALUES
('carcass0001'),
('carcass0002'),
('carcass0100');

INSERT INTO motor (name)
VALUES
('motor001'),
('motor002'),
('motor003');

INSERT INTO transmission (name)
VALUES
('transmission-0'),
('transmission-2'),
('transmission-1');

INSERT INTO machine
VALUES
(DEFAULT, 'toyota-01', 1, 3, 1),
(DEFAULT, 'toyota-02', 2, 2, 2);

SELECT ma.name machine, c.name carcass, m.name motor, t.name transmission
FROM machine ma
INNER JOIN carcass c ON ma.id_carcass = c.id
INNER JOIN motor m ON ma.id_motor = m.id
INNER JOIN transmission t ON ma.id_transmission = t.id;

SELECT c.name
FROM carcass c
LEFT OUTER JOIN machine m
ON c.id = m.id_carcass
WHERE m.name IS NULL;

SELECT m.name
FROM motor m
LEFT OUTER JOIN machine ma
ON m.id = ma.id_motor
WHERE ma.name IS NULL;

SELECT t.name
FROM machine m
RIGHT OUTER JOIN transmission t
ON t.id = m.id_transmission
WHERE m.name IS NULL;