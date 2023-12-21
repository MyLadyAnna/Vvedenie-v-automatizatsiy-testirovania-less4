CREATE TABLE courier_info
(courier_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 first_name VARCHAR(30) NOT NULL,
 last_name VARCHAR(35) NOT NULL,
 phone_number VARCHAR(20) NOT NULL,
 delivery_type VARCHAR(5) NOT NULL);

INSERT INTO courier_info(first_name, last_name, phone_number, delivery_type) VALUES
('John', 'Rython', '+ 7 960 655 0954', 'foot'),
('Kate', 'Looran', '+ 7 960743 0146', 'car'),
('Bob', 'Kolaris', '+ 7 960 107 7798', 'car'),
('Michael', 'Frontal', '+ 7 960 566 5516', 'car');