CREATE DATABASE PRJ
DROP DATABASE PRJ_Final
USE PRJ

CREATE TABLE Customer (
  customer_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
  username VARCHAR(255) NOT NULL UNIQUE,
  [name] NVARCHAR(255),
  email VARCHAR(255) NOT NULL UNIQUE,
  phone_number CHAR(10) NOT NULL,
  [password] VARCHAR(255) NOT NULL,
  created_at DATETIME DEFAULT GETDATE() NOT NULL,
  is_driver BIT default(0)
);

CREATE TABLE Car(
	car_id INT PRIMARY KEY IDENTITY(1,1),
	customer_id INT NOT NULL,
	model VARCHAR(255),
	plate VARCHAR(255),
	img VARBINARY(MAX),
	FOREIGN KEY (customer_id) REFERENCES [Customer](customer_id),
)
CREATE TABLE Book (
    book_id INT PRIMARY KEY IDENTITY(1,1),
    [customer_id] INT NOT NULL,
    car_id INT NOT NULL,
	pick_location nVARCHAR(255) NOT NULL,
	drop_location nvarchar(255) NOT NULL,
	pick_time DATETIME NOT NULL,
	price DECIMAL(9,2),
	created_at DATETIME DEFAULT GETDATE() NOT NULL,
    FOREIGN KEY ([customer_id]) REFERENCES Customer(customer_id),
    FOREIGN KEY (car_id) REFERENCES [Car](car_id)
);
CREATE TABLE History (
  history_id INT PRIMARY KEY IDENTITY(1,1),
  book_id INT FOREIGN KEY REFERENCES Book(book_id)
);