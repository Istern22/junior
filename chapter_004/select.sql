--1
SELECT * FROM product p
INNER JOIN type_product t
ON p.type_id = t.type_id
WHERE t.type_name = 'сыр';

--2
SELECT * FROM product
WHERE LOWER(product_name) LIKE LOWER('%мороженое%');

--3
SELECT * FROM product
WHERE date_part('month', expired_date) = date_part('month', CURRENT_DATE) + 1;

--4
SELECT * FROM product
WHERE price = (SELECT MAX(price) FROM product);

--5
SELECT SUM(amount) FROM product p
INNER JOIN type_product t
ON t.type_id = p.type_id
WHERE t.type_name = 'сыр';

--6
SELECT * FROM product p
INNER JOIN type_product t
ON t.type_id = p.type_id
WHERE t.type_name = 'сыр'
OR t.type_name = 'мороженое';

--7
SELECT * FROM product
WHERE amount < 10;

--8
SELECT p.product_name, t.type_name FROM product p
NATURAL JOIN type_product t;