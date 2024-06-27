-- Create database if not exists
CREATE DATABASE IF NOT EXISTS coaching_management_db;

USE coaching_management_db;

-- Create admin table
CREATE TABLE IF NOT EXISTS admin_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    mobile VARCHAR(10),
    password VARCHAR(255)
);

-- Create batch table
CREATE TABLE IF NOT EXISTS batch_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    time TIME,
    duration VARCHAR(255)
);

-- Create course table
CREATE TABLE IF NOT EXISTS course_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

-- Create student table
CREATE TABLE IF NOT EXISTS student_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    batch_id INT,
    course_id INT,
    name VARCHAR(255),
    mobile VARCHAR(255),
    email VARCHAR(255),
    dob DATE,
    fathers_name VARCHAR(255),
    address VARCHAR(255),
    FOREIGN KEY (batch_id) REFERENCES batch_tbl(id),
    FOREIGN KEY (course_id) REFERENCES course_tbl(id)
);

-- Create attendance table
CREATE TABLE IF NOT EXISTS attendance_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    is_attend BOOLEAN,
    a_date DATE,
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES student_tbl(id)
);

-- Create fees table
CREATE TABLE IF NOT EXISTS fees_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fees INT,
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES student_tbl(id)
);
