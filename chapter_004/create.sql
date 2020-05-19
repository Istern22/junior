CREATE DATABASE items_system;

CREATE TABLE roles(
	role_id serial PRIMARY KEY,
	role_name varchar(50)
);
CREATE TABLE rules(
	rule_id serial PRIMARY KEY,
	rule_name varchar(50)
);
CREATE TABLE roles_rules(
	role_id int REFERENCES rules(rule_id),
	rule_id int REFERENCES roles(role_id)
);
CREATE TABLE users(
	user_id serial PRIMARY KEY,
	user_name varchar(50),
	role_id int REFERENCES roles(role_id)
);
CREATE TABLE status(
	status_id serial PRIMARY KEY,
	status varchar(50)
);
CREATE TABLE categories(
	category_id serial PRIMARY KEY,
	category varchar(50)
);
CREATE TABLE items(
	item_id serial PRIMARY KEY,
	item_name varchar(50),
	user_id int REFERENCES users(user_id),
	category_id int REFERENCES categories(category_id),
	status_id int REFERENCES status(status_id)
);
CREATE TABLE attachments(
	item_id int REFERENCES items(item_id),
	attachment varchar(50)
);
CREATE TABLE comments_base(
	item_id int REFERENCES items(item_id),
	comment_text text
);

INSERT INTO roles
VALUES
(DEFAULT, 'administrator'),
(DEFAULT, 'manager');

INSERT INTO rules
VALUES
(DEFAULT, 'create item'),
(DEFAULT, 'delete user');

INSERT INTO roles_rules
VALUES
(1, 1),
(1, 2),
(2, 1);

INSERT INTO users
VALUES
(DEFAULT, 'ALeksandr', 2),
(DEFAULT, 'Anna', 1);

INSERT INTO categories
VALUES
(DEFAULT, 'Renovation'),
(DEFAULT, 'Deletion');

INSERT INTO status
VALUES
(DEFAULT, 'In the process'),
(DEFAULT, 'Done');

INSERT INTO items
VALUES
(DEFAULT, 'Repair database', 1, 1, 1),
(DEFAULT, 'Remove user', 2, 2, 2);

INSERT INTO attachments
VALUES
(1, 'attachment1'),
(2, 'attachment1');

INSERT INTO comments_base
VALUES
(1, 'Do as soon as possible'),
(2, 'Do during this week');
