CREATE TABLE IF NOT EXISTS employee_info
(id integer PRIMARY KEY,
first_name text NOT NULL,
last_name text NOT NULL,
phone_number text NOT NULL);

INSERT INTO employee_info(id, first_name, last_name, phone_number) VALUES(1,'Иван','Иванов','+7 927 000001');
INSERT INTO employee_info(id, first_name, last_name, phone_number) VALUES(2,'Петр','Петров','+7 927 000002');
INSERT INTO employee_info(id, first_name, last_name, phone_number) VALUES(3,'Сидр','Сидоров','+7 927 000003');

