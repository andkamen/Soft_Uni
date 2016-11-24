-- Section 1: Data Definition


CREATE TABLE flights
(
flight_id INT PRIMARY KEY,
departure_time DATETIME NOT NULL,
arrival_time DATETIME NOT NULL,
status ENUM('Departing', 'Delayed', 'Arrived', 'Cancelled'),
origin_airport_id INT,
destination_airport_id INT,
airline_id INT,
CONSTRAINT fk_flights_airports_1 FOREIGN KEY (origin_airport_id) REFERENCES airports (airport_id),
CONSTRAINT fk_flights_airports_2 FOREIGN KEY (destination_airport_id) REFERENCES airports (airport_id),
CONSTRAINT fk_flights_airlines FOREIGN KEY (airline_id) REFERENCES airlines (airline_id)
);

CREATE TABLE tickets
(
ticket_id INT PRIMARY KEY,
price DECIMAL(8,2) NOT NULL,
class ENUM('First', 'Second', 'Third'),
seat VARCHAR(5) NOT NULL,
customer_id INT,
flight_id INT,
CONSTRAINT fk_tickets_flights FOREIGN KEY (flight_id) REFERENCES flights (flight_id),
CONSTRAINT fk_tickets_customers FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);



-- Section 2: Database Manipulations
-- 1.  DATA INSERTION

INSERT INTO flights
VALUES (1,'2016-10-13 06:00','2016-10-13 10:00','Delayed',1,4,1),
(2,'2016-10-12 12:00','2016-10-12 12:01','Departing',1,3,2),
(3,'2016-10-14 15:00','2016-10-20 04:00','Delayed',4,2,4),
(4,'2016-10-12 13:24','2016-10-12 16:31','Departing',3,1,3),
(5,'2016-10-12 08:11','2016-10-12 23:22','Departing',4,1,1),
(6,'1995-06-21 12:30','1995-06-22 20:30','Arrived',2,3,5),
(7,'2016-10-12 23:34','2016-10-13 03:00','Departing',2,4,2),
(8,'2016-11-11 13:00','2016-11-12 22:00','Delayed',4,3,1),
(9,'2015-10-01 12:00','2015-12-01 01:00','Arrived',1,2,1),
(10,'2016-10-12 19:30','2016-10-13 12:30','Departing',2,1,7);


INSERT INTO tickets
VALUES (1,3000.00,	'First',	'233-A',	3,	8),
(2,1799.90,	'Second','123-D',	1,	1),
(3,1200.50,	'Second','12-Z',	2,	5),
(4,410.68,'Third','45-Q',2,	8),
(5,560.00,'Third','201-R',	4,	6),
(6,2100.00,	'Second','13-T',	1,	9),
(7,5500.00,	'First',	'98-O',	2,	7);


-- Task 2: Update Arrived Flights


UPDATE flights as f
SET f.airline_id = 1
WHERE f.status = 'Arrived';


-- Task 3: Update Tickets

UPDATE tickets 
SET price = price*1.5
WHERE flight_id IN (SELECT f.flight_id FROM flights as f
						 INNER JOIN airlines as a
							ON f.airline_id = a.airline_id
							WHERE a.airline_id = (SELECT a.airline_id FROM airlines as a
															WHERE a.rating = (SELECT MAX(a.rating) 
																						FROM airlines as a)))

-- 4. Table Creation

CREATE TABLE customer_reviews
(
review_id INT PRIMARY KEY,
review_content VARCHAR(255) NOT NULL,
review_grade ENUM ('0','1','2','3','4','5','6','7','8','9','10'),
airline_id INT,
customer_id INT,
CONSTRAINT fk_customer_reviews_airlines FOREIGN KEY (airline_id) REFERENCES airlines (airline_id),
CONSTRAINT fk_customer_reviews_customers FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);


CREATE TABLE customer_bank_accounts
(
account_id INT PRIMARY KEY,
account_number VARCHAR(10) NOT NULL UNIQUE,
balance DECIMAL(10,2) NOT NULL, 
customer_id INT,
CONSTRAINT fk_customer_bank_accounts_customers FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);



-- Task 5: Fill the new Tables with Data

INSERT INTO customer_reviews
VALUES (1,'Me is very happy. Me likey this airline. Me good.	','10',	1,	1),
(2,'Ja, Ja, Ja... Ja, Gut, Gut, Ja Gut! Sehr Gut!','10',	1,	4),
(3,'Meh...','5',	4,	3),
(4,'Well Ive seen better, but Ive certainly seen a lot worse...','7',	3,	5);

INSERT INTO customer_bank_accounts
VALUES (1,'123456790',2569.23,1),
(2,'18ABC23672',14004568.23,2),
(3,'F0RG0100N3',19345.20,5);




--- Section 3: Querying
-- Task 1: Extract All Tickets


SELECT ticket_id, price, class, seat FROM tickets
ORDER BY ticket_id ASC;



-- Task 2: Extract All Customers 

SELECT 
c.customer_id,
CONCAT(c.first_name, ' ', c.last_name) as 'full_name',
c.gender
FROM customers AS c
ORDER BY full_name, c.customer_id ASC

-- Task 3: Extract Delayed Flights 


SELECT f.flight_id, f.departure_time, f.arrival_time FROM flights as f
WHERE status = 'Delayed'
ORDER BY f.flight_id ASC


-- 4: Extract Top 5 Most Highly Rated Airlines which have any Flights


SELECT a.airline_id, a.airline_name, a.nationality, a.rating FROM airlines as a
LEFT OUTER JOIN flights as f
ON a.airline_id = f.airline_id
GROUP BY airline_id
HAVING COUNT(f.flight_id) > 0
ORDER BY a.rating DESC
LIMIT 5




-- 5 Extract all Tickets with price below 5000, for First Class

SELECT 
t.ticket_id,
ai.airport_name,
CONCAT(c.first_name,' ', c.last_name) AS 'full_name'
FROM tickets as t
LEFT OUTER JOIN customers as c
ON t.customer_id = c.customer_id
LEFT OUTER JOIN flights as f
ON t.flight_id = f.flight_id
LEFT OUTER JOIN airports as ai 
ON f.destination_airport_id = ai.airport_id
WHERE t.price < 5000 AND t.class = 'First'
ORDER BY t.ticket_id 


-- 6. Extract all Customers which are departing from their Home Town


SELECT 
c.customer_id,
CONCAT(c.first_name,' ', c.last_name) AS 'full_name',
tw.town_name as 'home_town'
FROM flights as f
INNER JOIN tickets as t 
ON f.flight_id = t.flight_id
INNER JOIN customers as c
ON t.customer_id = c.customer_id
INNER JOIN towns as tw
ON c.home_town_id = tw.town_id 
WHERE f.`status` = 'Departing'
	AND f.origin_airport_id = c.home_town_id;
ORDER BY c.customer_id ASC




--  7: Extract all Customers which will fly


SELECT 
c.customer_id,
CONCAT(c.first_name,' ', c.last_name) AS 'full_name',
FLOOR(2016-YEAR(c.date_of_birth)) AS 'age'
FROM flights as f
INNER JOIN tickets as t 
ON f.flight_id = t.flight_id
INNER JOIN customers as c
ON t.customer_id = c.customer_id
WHERE f.`status` = 'Departing'
GROUP BY c.customer_id
ORDER BY age ASC, c.customer_id ASC



-- Task 8: Extract Top 3 Customers which have Delayed Flights


SELECT 
c.customer_id,
CONCAT(c.first_name,' ', c.last_name) AS 'full_name',
t.price as 'ticket_price',
ai.airport_name as 'destination'
FROM tickets as t
INNER JOIN flights as f 
ON f.flight_id = t.flight_id
INNER JOIN customers as c
ON t.customer_id = c.customer_id
INNER JOIN airports as ai
ON f.destination_airport_id = ai.airport_id 
WHERE f.`status` = 'Delayed'
ORDER BY t.price DESC, c.customer_id
LIMIT 3


--  9: Extract the Last 5 Flights, which are departing.



SELECT 
f.flight_id,
f.departure_time,
f.arrival_time,
origin.airport_name as 'origin',
dest.airport_name as 'destination'
FROM flights as f
INNER JOIN airports as dest
	ON f.destination_airport_id = dest.airport_id
INNER JOIN airports as origin
	ON f.origin_airport_id = origin.airport_id
WHERE f.`status` = 'Departing'	
ORDER BY f.departure_time ASC, f.flight_id ASC
LIMIT 5




-- 10: Extract all Customers below 21 years, which have already flew at least once


SELECT
c.customer_id,
CONCAT(c.first_name,' ', c.last_name) AS 'full_name',
FLOOR(2016-YEAR(c.date_of_birth)) AS 'age'
FROM customers as c
INNER JOIN tickets as t
	ON c.customer_id = t.customer_id
INNER JOIN flights as f
	ON t.flight_id = f.flight_id
WHERE f.`status` = 'Arrived' AND FLOOR(2016-YEAR(c.date_of_birth)) < 21
ORDER BY age DESC, c.customer_id ASC 



-- Task 11: Extract all Airports and the Count of People departing from them

SELECT 
ai.airport_id,
ai.airport_name,
COUNT(t.ticket_id) as 'passengers'
FROM tickets as t
INNER JOIN flights as f
	ON t.flight_id = f.flight_id
INNER JOIN airports as ai
	ON f.origin_airport_id = ai.airport_id
WHERE f.`status` = 'Departing'
GROUP BY ai.airport_id
HAVING COUNT(t.ticket_id)>0
ORDER BY ai.airport_id ASC


--  Section 4: Programmability

-- Task 1: Review Registering Procedure

DELIMITER $$
CREATE PROCEDURE usp_submit_review ( customer_id INT,
												 review_content VARCHAR(255),
												 review_grade ENUM ('0','1','2','3','4','5','6','7','8','9','10'), 
												 airline_name VARCHAR(255))
BEGIN

	DECLARE review_id INT;
	DECLARE airline_id INT DEFAULT NULL;
	SET review_id = (SELECT COUNT(*) FROM customer_reviews) + 1;
	SET airline_id = (SELECT ai.airline_id FROM airlines as ai
										WHERE ai.airline_name = airline_name);								
	
	START TRANSACTION;
	INSERT INTO customer_reviews(review_id, review_content, review_grade, airline_id,customer_id)
	VALUES (review_id, review_content, review_grade, airline_id,customer_id);
	
	IF (airline_id IS NULL) THEN 
		ROLLBACK;
		SIGNAL SQLSTATE '45000' SET Message_Text = 'Airline does not exist.'; 
	ELSE
		COMMIT;
	END IF;
END $$

DELIMITER ;
CALL usp_submit_review (1,'ok', '5','bla');
CALL usp_submit_review (1,'ok', '5','Royal Airline');


-- Task 2:  Ticket Purchase Procedure

DELIMITER $$
CREATE PROCEDURE usp_purchase_ticket ( customer_id INT,
												   flight_id INT,
												   ticket_price DECIMAL(8,2),
											  	   class ENUM('First', 'Second', 'Third'),
												   seat VARCHAR(5))
BEGIN
	
	DECLARE next_ticket_id INT;
	DECLARE new_customer_balance DECIMAL(8,2);
	SET next_ticket_id = (SELECT COUNT(*) FROM tickets) + 1;
	SET new_customer_balance = (SELECT cb.balance FROM customer_bank_accounts as cb
										  WHERE cb.customer_id = customer_id) - ticket_price;

	START TRANSACTION;
	
	INSERT INTO tickets(ticket_id,price,class,seat,customer_id,flight_id)
	VALUES (next_ticket_id,ticket_price, class, seat, customer_id ,flight_id);
	
	UPDATE customer_bank_accounts as cba
	SET balance = new_customer_balance
	WHERE cba.customer_id = customer_id;
	
	IF (new_customer_balance < 0) THEN
		ROLLBACK;
		SIGNAL SQLSTATE '45000' SET Message_Text = 'Insufficient bank account balance for ticket purchase.'; 
	ELSE
		COMMIT;
	END IF;
END $$



CALL usp_purchase_ticket (1,1,1000,'Third', '42-WC');
CALL usp_purchase_ticket (1,1,3000,'Third', '43-WC');


-- ---------------------------------------------------------

-- Section 5 (BONUS): Update Trigger



CREATE TABLE arrived_flights
(
flight_id INT PRIMARY KEY,
arrival_time DATETIME NOT NULL,
origin VARCHAR(50) NOT NULL,
destination VARCHAR(50) NOT NULL,
passengers INT NOT NULL
);


DELIMITER $$

CREATE TRIGGER tr_arrived_flights_update
AFTER UPDATE
ON flights
FOR EACH ROW
BEGIN
	DECLARE origin_airport VARCHAR(50);
	DECLARE destination_airport VARCHAR(50);
	DECLARE fl_passanger_count INT;
	SET fl_passanger_count = (SELECT 
								COUNT(t.ticket_id) as 'passengers'
								FROM tickets as t
								INNER JOIN flights as f
									ON t.flight_id = f.flight_id
								WHERE f.flight_id = old.flight_id);
								
	SET origin_airport = (SELECT	
								origin.airport_name as 'origin'
								FROM flights as f	
								INNER JOIN airports as origin
									ON f.origin_airport_id = origin.airport_id
								WHERE f.flight_id = old.flight_id);		
								
	SET destination_airport = 	(SELECT
										dest.airport_name as 'destination'
										FROM flights as f
										INNER JOIN airports as dest
											ON f.destination_airport_id = dest.airport_id
										WHERE f.flight_id =  old.flight_id);					
								
								

	IF( old.`status` != new.`status` AND new.`status` = 'Arrived') THEN
		INSERT INTO arrived_flights(flight_id,arrival_time,origin,destination,passengers)
		VALUES(old.flight_id, old.arrival_time,origin_airport,destination_airport, fl_passanger_count);
	END IF;
END $$


UPDATE flights as fl
SET fl.`status`='Delayed'
WHERE fl.flight_id = 2;

UPDATE flights as fl
SET fl.`status`='Arrived'
WHERE fl.flight_id = 8;







