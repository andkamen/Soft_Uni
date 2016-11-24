-- 1

SELECT 	c.employee_id,
c.hire_date,
c.salary,
c.branch_id
FROM employees AS e
WHERE e.salary > 2000
AND e.hire_date > '2009-06-05'

-- 2

SELECT 
	c.first_name,
	c.date_of_birth,
	FLOOR(DATEDIFF('2016-10-01', c.date_of_birth)/360) AS age
FROM customers AS c
WHERE DATEDIFF('2016-10-01', c.date_of_birth)/360 BETWEEN 40 AND 50;


-- 3

SELECT
	cu.customer_id,
	cu.first_name,
	cu.last_name,
	cu.gender,
	ci.city_name
FROM customers as cu
INNER JOIN cities as ci
	ON cu.city_id = ci.city_id
WHERE (cu.last_name LIKE 'Bu%'
	OR RIGHT(cu.first_name,1) = 'a')
  AND LENGTH(ci.city_name) > 7
  ORDER BY cu.customer_id ASC;






