CREATE TABLE IF NOT EXISTS employee (
id integer PRIMARY KEY,
name text NOT NULL,
capacity real,
info_id integer NOT NULL
);

INSERT INTO employee(id, name, capacity, info_id) VALUES(1,'max',100, 1);
INSERT INTO employee(id, name, capacity, info_id) VALUES(2,'leo',200,2);
INSERT INTO employee(id, name, capacity, info_id) VALUES(3,'jack',300,3);