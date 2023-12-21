CREATE TABLE delivery
(delivery_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 order_id INTEGER UNIQUE NOT NULL,
 courier_id INTEGER NOT NULL,
 date_arrived TIMESTAMP UNIQUE,
     taken VARCHAR(3) NOT NULL,
payment_method VARCHAR(4),
FOREIGN KEY (order_id) REFERENCES orders(order_id),
FOREIGN KEY (courier_id) REFERENCES courier_info(courier_id));




INSERT INTO delivery VALUES
(1, 1, 3, '2023-02-26 17:59:15', 'Yes', 'Cash'),
(2, 2, 4, '2023-02-26 18:01:05', 'Yes', 'Card'),
(3, 3, 1, '2023-02-26 18:04:36', 'Yes', 'Cash'),
(4, 4, 2, '2023-02-26 18:03:11', 'Yes', 'Cash'),
(5, 5, 1, '2023-02-26 18:19:56', 'Yes', 'Cash'),
(6, 6, 3, '2023-02-26 18:18:44', 'Yes', 'Card'),
(7, 7, 2, '2023-02-26 18:50:11', 'No', 'NULL'),
(8, 8, 4, '2023-02-26 18:35:07', 'Yes', 'Card'),
(9, 9, 4, '2023-02-26 18:58:28', 'NO', 'NULL'),
(10, 10, 3, '2023-02-26 18:36:51', 'Yes', 'Card'),
(11, 11, 2, '2023-02-26 19:10:34', 'Yes', 'Cash'),
(12, 12, 1, NULL, 'NO', 'NULL'),
(13, 13, 2, '2023-02-26 19:17:04', 'Yes', 'Cash'),
(14, 14, 3, '2023-02-26 18:56:17', 'Yes', 'Card'),
(15, 15, 4, '2023-02-26 19:05:29', 'Yes', 'Card');

