CREATE DATABASE items_system;

CREATE TABLE rules(
	id serial PRIMARY KEY, 
	name varchar(50), 
	description varchar(100)
);
CREATE TABLE roles(
	id serial PRIMARY KEY, 
	name varchar(50), 
	description varchar(100)
);
CREATE TABLE rules_roles(
	rules_id int NOT NULL REFERENCES rules(id), 
	roles_id int NOT NULL REFERENCES roles(id)
);
CREATE TABLE users(
	id serial PRIMARY KEY, 
	name varchar(50), 
	roles_id int NOT NULL REFERENCES roles(id)
);
CREATE TABLE states(
	id serial PRIMARY KEY, 
	name varchar(50)
);
CREATE TABLE categories(
	id serial PRIMARY KEY, 
	name varchar(50)
);
CREATE TABLE items(
	id int PRIMARY KEY REFERENCES users(id), 
	description varchar(100), 
	states_id int NOT NULL REFERENCES states(id), 
	categories_id int NOT NULL REFERENCES categories(id)
);
CREATE TABLE attaches(
	id serial PRIMARY KEY, 
	filename text, 
	items_id int NOT NULL REFERENCES items(id)
);
CREATE TABLE comments(
	id serial PRIMARY KEY, 
	description varchar(50), 
	items_id int NOT NULL REFERENCES items(id)
);

INSERT INTO rules(name, description) VALUES
	('Add', 'for admin and advanceduser'),
	('Delete', 'for admin'),
	('Read', 'for all');
INSERT INTO roles(name, description) VALUES
	('Administrator', 'has full access to the system'),
	('Advanced_User', 'has the right to read and add'),
	('Simple_User', 'has the right to read');
INSERT INTO rules_roles(rules_id, roles_id) VALUES
	(1, 1), (2, 1), (3, 1),
	(1, 2), (3, 2),
	(3, 3);
INSERT INTO users(name, roles_id) VALUES
	('John', 1),
	('Sarah', 2),
	('Arni', 2), 
	('Den', 3);
INSERT INTO states(name) VALUES
	('Wait'),
	('Execution'),
	('Success');
INSERT INTO categories(name) VALUES
	('Correction'),
	('Request');
INSERT INTO items(id, states_id, categories_id, description) VALUES
	(2, 2, 1, 'to change the header text'),
	(1, 3, 2, 'checking files'),
	(3, 3, 1, 'come back'),
	(4, 1, 2, 'garbage removal');
INSERT INTO attaches(filename, items_id) VALUES
	('c/icon1.png', 1),
	('c/icon2.png', 2);
INSERT INTO comments(description, items_id) VALUES
	('to make a large print', 2),
	('checking file extension', 1),
	('take out early in the morning', 4);
