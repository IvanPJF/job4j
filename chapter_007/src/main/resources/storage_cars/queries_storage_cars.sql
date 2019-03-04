
SELECT c.name, b.name body, e.name engine, t.name transmission FROM car c
LEFT OUTER JOIN body b ON c.body_id = b.id
LEFT OUTER JOIN engine e ON c.engine_id = e.id
LEFT OUTER JOIN transmission t ON c.transmission_id = t.id;

SELECT b.name FROM car c RIGHT OUTER JOIN body b ON c.body_id = b.id WHERE c.id IS NULL;
SELECT e.name FROM car c RIGHT OUTER JOIN engine e ON c.engine_id = e.id WHERE c.id IS NULL;
SELECT t.name FROM car c RIGHT OUTER JOIN transmission t ON c.transmission_id = t.id WHERE c.id IS NULL;
