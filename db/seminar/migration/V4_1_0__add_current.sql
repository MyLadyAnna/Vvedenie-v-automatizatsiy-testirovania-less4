CREATE TABLE current
(current_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 balance VARCHAR(35) NOT NULL,
 open_date timestamp NOT NULL,
 number VARCHAR(30) NOT NULL,
 employee_id INT NOT NULL,
 client_id INT NOT NULL,
 FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
 FOREIGN KEY (client_id) REFERENCES client (client_id)
);

INSERT INTO current(current_id, balance, open_date, number, employee_id, client_id)
values (1, '2000 rub', '2023-01-01 00:00:00', '80950100000000000099', 2, 2);