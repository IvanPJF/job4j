
CREATE TABLE body (
	id serial PRIMARY KEY,
	name varchar(50)
);
CREATE TABLE engine (
	id serial PRIMARY KEY,
	name varchar(50)
);
CREATE TABLE transmission (
	id serial PRIMARY KEY,
	name varchar(50)
);
CREATE TABLE car(
	id serial PRIMARY KEY,
	name varchar(50),
	body_id int NOT NULL REFERENCES body(id),
	engine_id int NOT NULL REFERENCES engine(id),
	transmission_id int NOT NULL REFERENCES transmission(id)
);

INSERT INTO body (name) VALUES ('sedan'), ('station wagon'), ('hatchback'), ('coupe'), ('fastback');
INSERT INTO engine (name) VALUES ('diesel'), ('petrol'), ('fuel injection'), ('electromotor');
INSERT INTO transmission (name) VALUES ('manual'), ('automatica'), ('other');
INSERT INTO car (name, body_id, engine_id, transmission_id) VALUES
	('MITSUBISHI LANCER', 1, 3, 2),
	('MAZDA 3', 3, 3, 2),
	('Audi A5', 4, 1, 1),
	('Tesla Model S', 5, 4, 2);
