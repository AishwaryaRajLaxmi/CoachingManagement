-- create a database
create database coaching_management_db;

-- go inside databae
use coaching_management_db;

-- Create a admin table
CREATE TABLE admin_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    mobile VARCHAR(10),
    password VARCHAR(255)
);
-- create a batch table
CREATE TABLE batch_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    time TIME,
    duration VARCHAR(255)
);

-- create a course table
CREATE TABLE course_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

-- create a student table
CREATE TABLE student_tbl (
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
-- attendace
CREATE TABLE attendance_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    is_attend BOOLEAN,
    a_date DATE,
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES student_tbl(id)
);

-- fees
CREATE TABLE fees_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fees INT,
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES student_tbl(id)
);