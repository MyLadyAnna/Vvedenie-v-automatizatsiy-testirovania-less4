CREATE TABLE employee
(employee_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 first_name VARCHAR(30) NOT NULL,
 last_name VARCHAR(35) NOT NULL,
 phone_number VARCHAR(20) NOT NULL,
 portion VARCHAR(30) NOT NULL
 );

INSERT INTO employee(employee_id, first_name, last_name, phone_number, portion)
VALUES(1,'Кирил','Денисов','+7 900 000001', 'Менеджер');
INSERT INTO employee(employee_id, first_name, last_name, phone_number, portion)
VALUES(2,'Владимир','Махлин','+7 900 000002', 'Главный Менеджер');