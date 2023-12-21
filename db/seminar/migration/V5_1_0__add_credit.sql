CREATE TABLE credit
(credit_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 balance VARCHAR(35) NOT NULL,
 open_date timestamp NOT NULL,
 close_date timestamp NOT NULL,
 summ VARCHAR(35) NOT NULL,
 number VARCHAR(30) NOT NULL,
 status VARCHAR(30) NOT NULL,
 employee_id INT NOT NULL,
 client_id INT NOT NULL,
 FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
 FOREIGN KEY (client_id) REFERENCES client (client_id)
);

INSERT INTO credit(credit_id, balance, open_date, close_date, summ, status, number, employee_id, client_id)
values (1,  '1000 rub', '2023-02-01 00:00:00', '2050-02-01 00:00:00', '1000000000',  'открыт', '80950100000000000777', 2, 3);