-- (1) Problem 1.	Employees with Salary Above 35000

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
SELECT e.first_name, e.last_name
FROM employees AS e
WHERE e.salary > 35000;

END $$

CALL usp_get_employees_salary_above_35000();

-- (2) Employees with Salary Above Number

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(criteria DECIMAL(19,4))
BEGIN
SELECT e.first_name, e.last_name
FROM employees AS e
WHERE e.salary >= criteria;
END $$

CALL usp_get_employees_salary_above(48100);

-- (3) Town Names Starting With

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(start_symbols VARCHAR(50))
BEGIN
SELECT t.name
FROM towns AS t
WHERE LEFT(t.name,LENGTH(start_symbols)) = start_symbols;

END $$

CALL usp_get_towns_starting_with('b');

-- (4) Employees from Town

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town (town_name VARCHAR(50))
BEGIN
SELECT e.first_name,e.last_name
FROM employees AS e 
JOIN addresses AS a 
ON a.address_id = e.address_id
JOIN towns AS t 
ON a.town_id = t.town_id
WHERE t.name = town_name;
END $$

CALL usp_get_employees_from_town('Sofia');

-- (5) Salary Level Function

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(employee_salary DECIMAL(19,4))
RETURNS VARCHAR(50)
BEGIN
	DECLARE salary_level VARCHAR(50);
	IF employee_salary < 30000 THEN
		SET salary_level = 'Low';
	ELSEIF employee_salary <= 50000 THEN
		SET salary_level = 'Average';
	ELSE
		SET salary_level = 'High';
	END IF;
	
	RETURN salary_level;
END $$

SELECT e.salary, ufn_get_salary_level(e.salary) AS salary_Level
FROM employees AS e;

-- (6) Employees by Salary Level

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(50))
BEGIN
SELECT e.first_name, e.last_name
FROM employees AS e
WHERE  ufn_get_salary_level(e.salary) = salary_level;
END $$

CALL usp_get_employees_by_salary_level('High');
 
-- (7) Define Function
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR (50))
RETURNS TINYINT
BEGIN
	DECLARE result TINYINT;
	DECLARE char_index INT;
	SET result := 1;
	SET char_index := 0;
	WHILE char_index < LENGTH(word) DO
		IF LOCATE(SUBSTRING(word, char_index, 1), set_of_letters, 1) = 0 THEN
			RETURN 0;
		END IF;
		SET char_index = char_index + 1;
	END WHILE;
	
	RETURN result;
END $$

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia');
SELECT ufn_is_word_comprised('oistmiahf', 'halves');

-- (9) Find Full Name
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name ()
BEGIN
	SELECT CONCAT(first_name, ' ', last_name) 
	FROM account_holders;
END $$

DELIMITER ;

CALL usp_get_holders_full_name;

-- (10) People with Balance Higher Than

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than (target_number DECIMAL(19,4))
BEGIN
	SELECT first_name, last_name
	FROM account_holders
	INNER JOIN accounts
		ON account_holders.id = accounts.account_holder_id
	GROUP BY first_name, last_name
	HAVING SUM(balance) > target_number;
END$$

DELIMITER ;

-- (11) Future Value Function
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DOUBLE, yearly_interest_rate DOUBLE, number_of_years DOUBLE)
RETURNS DOUBLE
BEGIN
	RETURN initial_sum * POW(1 + yearly_interest_rate,number_of_years);
END$$ 

-- (13) Deposit Money
-- Mine
DELIMITER $$
CREATE PROCEDURE usp_deposit_money (account_id INT, money_amount DECIMAL)
BEGIN
	START TRANSACTION;
	
	UPDATE accounts
	SET balance = balance + money_amount
	WHERE id = account_id;
	
	IF (SELECT COUNT(*)
			FROM accounts
			WHERE id = account_id) <> 1
	THEN
		ROLLBACK;
	END IF;
	
	COMMIT;
END$$

-- (14) Withdraw Money

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money (account_id INT, money_amount DECIMAL)
BEGIN
	START TRANSACTION;
	
	UPDATE accounts
	SET balance = balance - money_amount
	WHERE id = account_id;
	
	IF (SELECT COUNT(*)
			FROM accounts
			WHERE id = account_id) <> 1
	THEN
		ROLLBACK;
	END IF;
	
	COMMIT;
END$$

-- (20) Number of Users for Email Provider
SELECT RIGHT(u.email, CHAR_LENGTH(u.email) - LOCATE('@', u.email)) AS 'email_provider', COUNT(*) AS 'number_of_users'
FROM users AS u
GROUP BY email_provider
ORDER BY number_of_users DESC, email_provider;

-- (27) Peaks and Mountains
SELECT p.peak_name, m.mountain_range, p.elevation
FROM mountains AS m
INNER JOIN peaks AS p
	ON m.id = p.mountain_id
ORDER BY p.elevation DESC, p.peak_name;

-- (28) Peaks with Their Mountain, Country and Continent
SELECT p.peak_name, m.mountain_range, c.country_name, cont.continent_name
FROM continents AS cont
INNER JOIN countries AS c
	ON cont.continent_code = c.continent_code
INNER JOIN mountains_countries AS mc
	ON c.country_code = mc.country_code
INNER JOIN mountains AS m
	ON mc.mountain_id = m.id
INNER JOIN peaks AS p
	ON m.id = p.mountain_id
ORDER BY p.peak_name, c.country_name;

-- (29) Rivers by Country












