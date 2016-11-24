INSERT INTO deposit_types
VALUES (1,'Time Deposit'),
		 (2, 'Call Deposit'),
       (3,'Free Deposit');
       
INSERT INTO deposits(amount, start_date, end_date, deposit_type_id, customer_id)
SELECT 
	CASE
		WHEN c.date_of_birth > '1980-01-01' THEN 1000
		ELSE 1500
	END
	+
	CASE 
		WHEN c.gender = 'm' THEN 100
		ELSE 200
	END AS amount,
	NOW() as start_date,
	NULL as end_date,
	CASE 
		WHEN c.customer_id > 15 THEN 3
		ELSE
			CASE 
				WHEN c.customer_id % 2 = 0 THEN 2
			ELSE 1
			END
	END AS deposit_type_id,
	c.customer_id 
FROM customers as c
WHERE c.customer_id <20;

INSERT INTO employees_deposits (employee_id, deposit_id)
VALUES (15,	4),
(20,15),
(8,7),
(4,8),
(3,13),
(3,8),
(4,10),
(10,1),
(13,4),
(14,9);


-- update employees


UPDATE employees AS e
SET e.manager_id = CASE
							WHEN e.employee_id BETWEEN 2 AND 10 THEN 1
							WHEN e.employee_id BETWEEN 12 AND 20 THEN 11
							WHEN e.employee_id BETWEEN 22 AND 30 THEN 21
							WHEN e.employee_id IN (11,21) THEN 1
						END

-- Delete records
DELETE FROM employees_deposits 
WHERE deposit_id = 9
	OR employee_id = 3;













    
       
