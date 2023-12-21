CREATE TABLE customers
(customer_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 first_name VARCHAR(30) NOT NULL,
 last_name VARCHAR(35) NOT NULL,
 phone_number VARCHAR(20) NOT NULL,
 district VARCHAR(15) NOT NULL,
 street VARCHAR(25) NOT NULL,
 house INT NOT NULL,
 apartment INT NOT NULL);


INSERT INTO customers(first_name, last_name, phone_number, district, street, house, apartment) VALUES
('Penny', 'Smith', '+ 7 927 572 3771', 'Южный', 'Первая', 1, 10),
('Randy', 'Brown', '+ 7 927 568 8452', 'Восточный', 'Третья', 2, 35),
('Oliver', 'Thompson', '+ 7 927 782 5648', 'Восточный', 'Третья', 77, 14),
('James', 'Twist', '+ 7 927 752 1224', 'Южный', 'Третья', 24, 89),
('Hellen', 'Bellora', '+ 7 927 555 4568', 'Южный', 'Вторая', 11, 85),
('Kate', 'Evans', '+ 7 927 321 3211', 'Восточный', 'Третья', 123, 52),
('Jennifer', 'Radriges', '+ 7 927 321 1232', 'Южный', 'Третья', 76, 44),
('Mario', 'Gordon', '+ 7 927 122 4554', 'Восточный', 'Первая', 21, 91),
('Bella', 'Lorenson', '+ 7 927 758 1667', 'Северный', 'Четвертая', 23, 67),
('Erica', 'Visputchu', '+ 7 927 765 8582', 'Южный', 'Вторая', 62, 44),
('Henry', 'Smith', '+ 7 927 657 5528', 'Восточный', 'Четвертая', 15, 56),
('Oscar', 'Rild', '+ 7 927 624 3643', 'Южный', 'Первая', 5, 13),
('William', 'Frankston', '+ 7 927 303 8181', 'Южный', 'Вторая', 18, 88),
('Peter', 'Hall', '+ 7 927 466 7562', 'Северный', 'Первая', 17, 7),
('Ada', 'Watson', '+ 7 927 114 7812', 'Южный', 'Вторая', 18, 9);
