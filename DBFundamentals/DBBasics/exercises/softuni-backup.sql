-- PS. I KNOW that I can just run selected segments of the queries but I like pressing the blue arrow .... ¯\_(ツ)_/¯


/*
CREATE TABLE passports(
passport INT PRIMARY KEY,
passport_number VARCHAR(50)
);

CREATE TABLE persons(
person_id INT PRIMARY KEY,
first_name VARCHAR(50),
salary DOUBLE,
passport_id INT,
CONSTRAINT FK_persons_passports FOREIGN KEY(passport_id) REFERENCES passports(passport)
);

INSERT INTO passports(passport, passport_number)
VALUES (101, 'N34FG21B'),
		 (102, 'K65LO4R7'),
		 (103, 'ZE657QP2');


INSERT INTO persons (person_id,first_name, salary, passport_id)
VALUES (1, 'Roberto', 43300.00, 102),
       (2, 'Tom', 56100.00, 103),
       (3, 'Yana', 60200.00, 101);
*/		 


/*
-- Problem 2.	One-To-Many Relationship
CREATE TABLE manufacturers(
manufacturer_id INT PRIMARY KEY,
name VARCHAR(50),
established_on DATE
);

CREATE TABLE models(
model_id INT PRIMARY KEY,
name VARCHAR(50),
manufacturer_id INT,
CONSTRAINT FK_models_manufacturers FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (manufacturer_id)
);

*/

-- Problem 3.	Many-To-Many Relationship
/*
CREATE TABLE students(
student_id INT PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE exams(
exam_id INT PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE students_exams(
student_id INT,
exam_id INT,
CONSTRAINT PK_students_exams PRIMARY KEY(student_id, exam_id),
CONSTRAINT FK_students_exams_students FOREIGN KEY(student_id) REFERENCES students(student_id),
CONSTRAINT FK_students_exams_exams FOREIGN KEY(exam_id) REFERENCES exams(exam_id)
);

*/

-- Problem 4.	Self-Referencing
/*
CREATE TABLE teachers(
teacher_id INT PRIMARY KEY,
name VARCHAR(50),
manager_id INT,
CONSTRAINT FK_teachers FOREIGN KEY(manager_id) REFERENCES teachers(teacher_id)
);

*/

/*
-- Problem 5.	Online Store Database

CREATE TABLE cities(
city_id INT PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE customers(
customer_id INT PRIMARY KEY,
name VARCHAR(50),
birthday DATE,
city_id INT,
CONSTRAINT fk_customers_cities FOREIGN KEY(city_id) REFERENCES cities(city_id)
);

CREATE TABLE orders(
order_id INT PRIMARY KEY,
customer_id INT,
CONSTRAINT fk_orders_customers FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE item_types(
item_type_id INT PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE items(
item_id INT PRIMARY KEY,
name VARCHAR(50),
item_type_id INT,
CONSTRAINT fk_items_item_types FOREIGN KEY(item_type_id) REFERENCES item_types(item_type_id)
);

CREATE TABLE order_items(
order_id INT,
item_id INT,
CONSTRAINT PK_order_items PRIMARY KEY(order_id,item_id),
CONSTRAINT fk_order_items_orders FOREIGN KEY(order_id) REFERENCES orders(order_id),
CONSTRAINT fk_order_items_items FOREIGN KEY(item_id) REFERENCES items(item_id)
);

*/

/*
-- DOESNT RUN in judge, foreign key issue
-- Problem 6.	University Database
#DROP TABLE agenda, majors,payments,students,subjects;

CREATE TABLE majors
(
	major_id INT PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE students
(
	student_id INT PRIMARY KEY,
	student_number VARCHAR(12),
	student_name VARCHAR(50),
	major_id INT,
	CONSTRAINT fk_students_majors FOREIGN KEY (major_id) REFERENCES majors(major_id)
);


CREATE TABLE subjects
(
	subject_id INT PRIMARY KEY,
	subject_name VARCHAR(50)
);


CREATE TABLE agenda
(
	student_id INT,
	subject_id INT, 
	CONSTRAINT PK_agenda PRIMARY KEY (student_id,subject_id),
	CONSTRAINT fk_agenda_students FOREIGN KEY (student_id) REFERENCES students(student_id),
	CONSTRAINT fk_agenda_subjects FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)
);




CREATE TABLE payments
(
	payment_id INT PRIMARY KEY,
	payment_date DATE,
	payment_amount DECIMAL(8,2),
	student_id INT,
	CONSTRAINT fk_payments_students FOREIGN KEY (student_id) REFERENCES students(student_id)
);


*/


/*
-- Problem 9.	Employee Address

SELECT e.employee_id, e.job_title, e.address_id, a.address_text FROM employees as e
INNER JOIN addresses as a 
ON e.address_id = a.address_id
ORDER BY e.address_id
LIMIT 5
*/

-- Problem 10.	Employee Departments
/*
SELECT e.employee_id, e.first_name, e.salary, d.name as 'department_name' FROM employees as e
INNER JOIN departments as d 
ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY e.department_id ASC
LIMIT 5
*/
/*
-- Problem 11.	Employees Without Project
SELECT e.employee_id, e.first_name FROM employees as e
LEFT OUTER JOIN employees_projects as ep
ON e.employee_id = ep.employee_id
WHERE ep.employee_id IS NULL
ORDER BY e.employee_id ASC
LIMIT 3

*/

/*
-- Problem 12.	Employees with Project

SELECT e.employee_id,  e.first_name , p.name 
FROM  employees AS e
INNER JOIN employees_projects AS ep ON e.employee_id= ep.employee_id
INNER JOIN projects AS p on p.project_id = ep.project_id
WHERE  start_date > '2002-08-13'
AND end_date IS NULL
ORDER BY e.employee_id
LIMIT 5

*/
/*
-- Problem 13.	Employee 24

SELECT e.employee_id, e.first_name,
	CASE
		WHEN p.start_date > '20050101' THEN NULL
		ELSE p.name
	END AS project_name
FROM employees AS e
INNER JOIN employees_projects AS ep
ON e.employee_id = ep.employee_id
INNER JOIN projects AS p
ON ep.project_id = p.project_id
WHERE e.employee_id = 24

*/
-- Problem 13.	Employee 24
/*
SELECT e.employee_id, e.first_name, p.name AS project_name
FROM employees AS e
INNER JOIN employees_projects AS ep
ON e.employee_id = ep.employee_id
LEFT OUTER JOIN projects AS p
ON ep.project_id = p.project_id
AND p.start_date < '20050101'
WHERE e.employee_id = 24

*/

-- Problem 14.	Employee Manager

SELECT
e.employee_id, 
e.first_name, 
m.employee_id as manager_id,
m.first_name as manager_name
FROM employees as e
JOIN employees as m
ON m.employee_id = e.manager_id
WHERE e.manager_id IN (3,7)
ORDER BY e.employee_id ASC

