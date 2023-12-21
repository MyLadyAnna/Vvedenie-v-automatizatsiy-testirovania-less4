CREATE TABLE debit
(debit_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 type_name VARCHAR(30) NOT NULL,
 balance VARCHAR(35) NOT NULL,
 open_date timestamp NOT NULL,
 percent INT NOT NULL,
 status VARCHAR(30) NOT NULL,
 number VARCHAR(30) NOT NULL,
 employee_id INT NOT NULL,
 client_id INT NOT NULL,
 FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
 FOREIGN KEY (client_id) REFERENCES client (client_id)
);

INSERT INTO debit(debit_id, type_name, balance, open_date, percent, status, number, employee_id, client_id)
values (1, 'Повышенный', '1000 rub', '2023-02-01 00:00:00', '10',  'открыт', '80350100000000000017', 1, 1);