CREATE TABLE client
(client_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 first_name VARCHAR(30) NOT NULL,
 last_name VARCHAR(35) NOT NULL,
 phone_number VARCHAR(20) NOT NULL,
 district VARCHAR(15) NOT NULL,
 street VARCHAR(25) NOT NULL,
 house INT NOT NULL,
 apartment INT NOT NULL);

INSERT INTO client(client_id, first_name, last_name, phone_number, district, street, house, apartment)
VALUES(1,'Иван','Иванов','+7 927 000001', 'Промышленный', 'Садовая', 20, 50);
INSERT INTO client(client_id, first_name, last_name, phone_number, district, street, house, apartment)
VALUES(2,'Петр','Петров','+7 927 000002', 'Первый', 'Средняя', 11, 2);
INSERT INTO client(client_id, first_name, last_name, phone_number, district, street, house, apartment)
VALUES(3,'Сидр','Сидоров','+7 927 000003', 'Центральный', 'Проспект', 250, 177);