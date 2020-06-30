CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);

SELECT p.name, c.name FROM person p
INNER JOIN company c
ON p.company_id = c.id
WHERE company_id != 5;

SELECT c.name, COUNT(p.name) FROM company c
INNER JOIN person p
ON c.id = p.company_id
GROUP BY c.name
ORDER BY COUNT(p.name) DESC
LIMIT 1;