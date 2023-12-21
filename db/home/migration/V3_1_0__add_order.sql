CREATE TABLE orders
(order_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 customer_id INT NOT NULL,
 date_get TIMESTAMP NOT NULL,
     FOREIGN KEY (customer_id) REFERENCES customers (customer_id));

INSERT INTO orders(customer_id, date_get) VALUES
(1, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(2, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(3, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(4, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(5, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(6, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(7, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(8, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(9, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(10, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(11, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(12, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(13, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(14, date('now'));
INSERT INTO orders(customer_id, date_get) VALUES
(15, date('now'));
