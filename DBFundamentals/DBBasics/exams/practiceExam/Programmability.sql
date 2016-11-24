DELIMITER $$

CREATE FUNCTION udf_concat_string(first_string VARCHAR(255), second_string VARCHAR(255))
RETURNS VARCHAR(255)
BEGIN
	DECLARE first_string_reversed VARCHAR(255);
	DECLARE second_string_reversed VARCHAR(255);
	SET first_string_reversed := REVERSE (first_string);
	SET second_string_reversed := REVERSE (second_string);
	RETURN CONCAT (first_string_reversed,second_string_reversed);	
	
END $$

DELIMITER ;

SELECT udf_concat_string('Soft', 'Uni');


DELIMITER $$

CREATE PROCEDURE usp_customers_with_unexpired_loans(customer_id INT)
BEGIN
	SELECT c.customer_id, 
			 c.first_name,
			 l.loan_id
		FROM customers AS c
		INNER JOIN loans as l
			ON c.customer_id = l.customer_id
		WHERE c.customer_id = customer_id
		AND l.expiration_date IS NULL;	

END $$


CALL usp_customers_with_unexpired_loans(9);

DELIMITER $$
CREATE PROCEDURE usp_take_loan(customer_id INT, loan_amount DECIMAL(10,2),interest DECIMAL(10,2), start_date DATE)
BEGIN
	START TRANSACTION;
	
	INSERT INTO loans(start_date, amount,interest,customer_id)
	VALUES (start_date, loan_amount, interest, customer_id);
	
	IF(loan_amount NOT BETWEEN 0.01 AND 100000 ) THEN
	SIGNAL SQLSTATE '45000' SET Message_Text = 'Invalid Loan Amount.';
	ROLLBACK;
	ELSE
		COMMIT;
	END IF;	
END $$


DELIMITER $$
CREATE TRIGGER tr_hire_employee
AFTER INSERT
ON employees_loans
FOR EACH ROW
BEGIN

	UPDATE employee_loans AS e
		SET e.employee_id = new.employee_id
	 WHERE e.employee_id + 1 = new.employee_id;

END $$




