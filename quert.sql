-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS hotelmanagementsystem;

-- Use the database
USE hotelmanagementsystem;

-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS login (
    username VARCHAR(25) PRIMARY KEY, 
    password VARCHAR(25) NOT NULL
);

-- Insert data (prevents duplicate entry errors)
INSERT INTO login (username, password) 
VALUES ('admin', '12345')
ON DUPLICATE KEY UPDATE password = VALUES(password);

-- Display data
SELECT * FROM login;

-- Create employee table with proper constraints
CREATE TABLE IF NOT EXISTS employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    age INT CHECK (age > 0), 
    gender VARCHAR(15) CHECK (gender IN ('Male', 'Female', 'Other')),
    job VARCHAR(30) NOT NULL,
    salary DECIMAL(10,2) CHECK (salary >= 0),
    email VARCHAR(50) UNIQUE
);
