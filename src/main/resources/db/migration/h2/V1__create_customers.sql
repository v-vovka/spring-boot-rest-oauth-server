CREATE TABLE customers
(
	ID NUMBER(19) NOT NULL AUTO_INCREMENT,
	name VARCHAR2(255) NOT NULL,
	email VARCHAR2(255) NOT NULL,
	phone VARCHAR2(255) NOT NULL,
	PRIMARY KEY (ID)
);