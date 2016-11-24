CREATE TABLE deposit_types
(
deposit_type_id INT PRIMARY KEY,
name VARCHAR(20)
);

CREATE TABLE deposits
(
deposit_id INT PRIMARY KEY AUTO_INCREMENT,
amount DECIMAL(10,2),
start_date DATE,
end_date DATE,
deposit_type_id INT,
customer_id INT,

CONSTRAINT fk_deposits_deposit_types FOREIGN KEY(deposit_type_id) REFERENCES deposit_types(deposit_type_id),
CONSTRAINT fk_deposits_customers FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE employees_deposits
(
employee_id INT,
deposit_id INT,
CONSTRAINT pk_employee_id_deposit_id PRIMARY KEY(employee_id,deposit_id),
CONSTRAINT fk_employees_deposits_employees_deposits FOREIGN KEY(employee_id) REFERENCES employees(employee_id),
CONSTRAINT fk_employees_deposits_deposits FOREIGN KEY(deposit_id) REFERENCES deposits(deposit_id)
);


CREATE TABLE credit_history
(
credit_history_id INT PRIMARY KEY,
mark CHAR(1),
start_date DATE,
end_date DATE,
customer_id INT,
CONSTRAINT fk_credit_history_customers FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE payments
(
payement_id INT PRIMARY KEY,
date DATE,
amount DECIMAL(10,2),
loan_id INT,
CONSTRAINT fk_payments_loans FOREIGN KEY(loan_id) REFERENCES loans(loan_id)
);

CREATE TABLE users
(
user_id INT PRIMARY KEY,
user_name VARCHAR(20),
password VARCHAR(20),
customer_id INT UNIQUE,
CONSTRAINT fk_users_customers FOREIGN KEY(customer_id) REFERENCES customers (customer_id)
);

ALTER TABLE employees
ADD manager_id INT, 
ADD CONSTRAINT fk_employees_employees FOREIGN KEY(manager_id) REFERENCES employees (employee_id);

