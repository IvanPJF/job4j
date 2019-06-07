--Remove duplicate cities from the table.
DELETE FROM cities
WHERE NOT id IN (
SELECT min(id) AS id FROM cities
GROUP BY name
ORDER BY id);
--Create a unique value constraint for the name attribute in the cities table.
ALTER TABLE cities ADD UNIQUE(name);