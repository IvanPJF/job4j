
--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT p.name FROM product p
INNER JOIN type t ON p.type_id = t.id AND t.name = 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT p.name FROM product p
WHERE p.name LIKE '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT p.name, p.expired_date FROM product p
WHERE p.expired_date
	BETWEEN DATE_TRUNC('MONTH', NOW()) + '1 MONTH' AND DATE_TRUNC('MONTH', NOW()) + '2 MONTH';
	
--4. Написать запрос, который выводит самый дорогой продукт.
SELECT p.name, p.price FROM product p
WHERE p.price = (SELECT MAX(price) FROM product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT t.name, count(*) FROM product p
INNER JOIN type t ON p.type_id = t.id
GROUP BY t.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT p.name, t.name FROM product p
INNER JOIN type t ON p.type_id = t.id
WHERE t.name IN('СЫР', 'МОЛОКО');

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT * FROM
	(SELECT t.name, count(*) count FROM product p
	INNER JOIN type t ON p.type_id = t.id
	GROUP BY t.name) p_t
WHERE p_t.count < 10;

--8. Вывести все продукты и их тип.
SELECT p.name, t.name FROM product p
INNER JOIN type t ON p.type_id = t.id;
