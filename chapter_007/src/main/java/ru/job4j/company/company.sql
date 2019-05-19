-- 1) Retrieve in a single query:
-- - names of all persons that are NOT in the company with id = 5
-- - company name for each person
select p.name, c.name from company as c
inner join person as p on c.id = p.company_id
where c.id != 5
;

-- 2) Select the name of the company with the maximum number of persons + number of persons in this company
select c.name, count(*) from company as c
inner join person as p on c.id = p.company_id
group by c.name
having c.count = (select max(count) from (select count(*) from person as p
group by p.company_id) as m)
;