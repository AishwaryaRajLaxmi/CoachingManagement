-- Insert dummy data into admin_tbl
INSERT INTO admin_tbl (name, email, mobile, password)
VALUES
    ('Admin 1', 'admin1@example.com', '9876543210', 'admin@123'),
    ('Admin 2', 'admin2@example.com', '1234567890', 'admin@456');

-- Insert dummy data into batch_tbl
INSERT INTO batch_tbl (name, time, duration)
VALUES
    ('Morning Batch', '09:00:00', '3 months'),
    ('Evening Batch', '18:00:00', '4 months');

-- Insert dummy data into course_tbl
INSERT INTO course_tbl (name)
VALUES
    ('Mathematics'),
    ('Physics'),
    ('Chemistry');

-- Insert dummy data into student_tbl
INSERT INTO student_tbl (batch_id, course_id, name, mobile, email, dob, fathers_name, address)
VALUES
    (1, 1, 'John Doe', '9876543210', 'john.doe@example.com', '2000-05-15', 'Michael Doe', '123 Main St, City'),
    (2, 2, 'Jane Smith', '9876543211', 'jane.smith@example.com', '2001-02-28', 'David Smith', '456 Elm St, Town');

-- Insert dummy data into attendance_tbl
INSERT INTO attendance_tbl (is_attend, a_date, student_id)
VALUES
    (1, '2024-06-01', 1),
    (0, '2024-06-01', 2),
    (1, '2024-06-02', 1),
    (1, '2024-06-02', 2);

-- Insert dummy data into fees_tbl
INSERT INTO fees_tbl (fees, student_id)
VALUES
    (5000, 1),
    (6000, 2);
