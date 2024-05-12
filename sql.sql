create database dktc;
use dktc;

CREATE TABLE `users` (
  `id` bigint auto_increment PRIMARY KEY,
  `email` varchar(255),
  `password` varchar(255),
  `username` varchar(255)
);

CREATE TABLE `roles` (
  `id` bigint PRIMARY KEY,
  `name` varchar(255)
);

CREATE TABLE `users_roles` (
  `user_id` bigint,
  `role_id` bigint
);

ALTER TABLE users_roles
ADD CONSTRAINT fk_users_roles_user_id
FOREIGN KEY (user_id)
REFERENCES users(id)
ON DELETE CASCADE;

ALTER TABLE users_roles
ADD CONSTRAINT fk_users_roles_role_id
FOREIGN KEY (role_id)
REFERENCES roles(id)
ON DELETE CASCADE;

ALTER TABLE users_roles
ADD CONSTRAINT pk_users_roles PRIMARY KEY (user_id, role_id);

INSERT INTO roles (id, name)
VALUES (1, 'STUDENT'), (2, 'TEACHER');

INSERT INTO users (email, password, username)
VALUES
    ('user1@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user1'),
    ('user2@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user2'),
    ('user3@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user3'),
    ('user4@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user4'),
    ('user5@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user5'),
    ('user6@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user6'),
    ('user7@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user7'),
    ('user8@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user8'),
    ('user9@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user9'),
    ('user10@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user10');


INSERT INTO users_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1),
    (6, 1),
    (7, 1),
    (8, 2),
    (9, 2),
    (10, 2);

CREATE TABLE times (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);
INSERT INTO times (id, name)
VALUES
    (1, 'Thứ 2'),
    (2, 'Thứ 3'),
    (3, 'Thứ 4'),
    (4, 'Thứ 5'),
    (5, 'Thứ 6');

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(100),
    date_of_birth DATE,
    user_id bigint,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO students (id, name, address, date_of_birth, user_id)
VALUES
    (1, 'John Doe', '123 Main St', '2000-01-01', 1),
    (2, 'Jane Smith', '456 Elm St', '2001-02-02', 2),
    (3, 'David Johnson', '789 Oak St', '1999-03-03', 3),
    (4, 'Emily Davis', '321 Pine St', '2002-04-04', 4),
    (5, 'Michael Wilson', '654 Maple St', '1998-05-05', 5),
    (6, 'Sarah Brown', '987 Cedar St', '2003-06-06', 6),
    (7, 'Daniel Taylor', '135 Birch St', '1997-07-07', 7);
    
CREATE TABLE courses (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    credit INT,
    code_course VARCHAR(20)
);

INSERT INTO courses (id, name, credit, code_course)
VALUES
    (1, 'Thể chất 1', 3, 'TC1'),
    (2, 'Thể chất 2', 2, 'TC2'),
    (3, 'Thể chất 3', 4, 'TC3');
    
    
    CREATE TABLE majors (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

INSERT INTO majors (id, name)
VALUES
    (1, 'An toàn thông tin'),
    (2, 'Công nghệ thông tin'),
    (3, 'Điện tử viễn thông');
    
INSERT INTO majors (id, name)
VALUES
    (4, 'Đào tạo');

UPDATE students
SET major_id = 1
WHERE id IN (1, 2);

UPDATE students
SET major_id = 2
WHERE id IN (2, 3, 4);

UPDATE students
SET major_id = 3
WHERE id IN (5, 6, 7);

CREATE TABLE teachers (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    major_id INT,
    FOREIGN KEY (major_id) REFERENCES majors(id)
);

CREATE TABLE teachers (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    major_id INT,
    user_id bigint,
    FOREIGN KEY (major_id) REFERENCES majors(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO teachers (id, name, major_id, user_id)
VALUES (1, 'Son Goku', 4, 8),
       (2, 'Uzumaki Naruto', 4, 9),
       (3, 'Monkey .D Luffy', 4, 10);

CREATE TABLE courses (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    credit INT,
    code_course VARCHAR(20)
);

INSERT INTO courses (id, name, credit, code_course)
VALUES
    (1, 'Thể chất 1', 3, 'TC1'),
    (2, 'Thể chất 2', 2, 'TC2'),
    (3, 'Thể chất 3', 4, 'TC3');



CREATE TABLE classes (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(100),
    teacher_id INT,
    time_id INT,
    course_id INT,
    start_date DATE,
    end_date DATE,
    size INT,
    student_registered INT,
    FOREIGN KEY (teacher_id) REFERENCES teachers(id),
    FOREIGN KEY (time_id) REFERENCES times(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

INSERT INTO classes (id, name, address, teacher_id, time_id, course_id, start_date, end_date, size, student_registered)
VALUES
    (1, 'L01', 'Sân thể chất', 1, 1, 1, DATE_ADD(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 4 MONTH), 20, 0),
    (2, 'L02', 'Sân thể chất', 2, 2, 1, DATE_ADD(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 4 MONTH), 20, 0),
    (3, 'L03', 'Sân thể chất', 3, 3, 1, DATE_ADD(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 4 MONTH), 20, 0),
    (4, 'L04', 'Sân thể chất', 1, 4, 2, DATE_ADD(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 4 MONTH), 20, 0),
    (5, 'L05', 'Sân thể chất', 2, 5, 2, DATE_ADD(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 4 MONTH), 20, 0),
    (6, 'L06', 'Sân thể chất', 3, 1, 2, DATE_ADD(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 4 MONTH), 20, 0),
    (7, 'L07', 'Sân thể chất', 1, 2, 3, DATE_ADD(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 4 MONTH), 20, 0),
    (8, 'L08', 'Sân thể chất', 2, 3, 3, DATE_ADD(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 4 MONTH), 20, 0),
    (9, 'L09', 'Sân thể chất', 3, 4, 3, DATE_ADD(CURDATE(), INTERVAL 2 MONTH), DATE_ADD(CURDATE(), INTERVAL 4 MONTH), 20, 0);
    

CREATE TABLE results (
  student_id INT,
  course_id INT,
  primary key(student_id,course_id),
  score_number_one FLOAT,
  score_number_two FLOAT,
  score_number_three FLOAT,
  score_total float,
  score_letter VARCHAR(2),
  FOREIGN KEY (student_id) REFERENCES students(id),
  FOREIGN KEY (course_id) REFERENCES courses(id)
);



INSERT INTO results (student_id, course_id, score_number_one, score_number_two, score_number_three, score_letter, score_total)
VALUES
  ( 1, 1, 8.5, 7.2, 9.0, 'A', 0.3*(0.7*8.5 + 0.3*7.2) + 0.7*9.0),
  ( 1, 2, 7.2, 8.8, 9.5, 'B+', 0.3*(0.7*7.2 + 0.3*8.8) + 0.7*9.5),
  ( 2, 1, 8.0, 7.5, 8.3, 'A-', 0.3*(0.7*8.0 + 0.3*7.5) + 0.7*8.3),
  ( 3, 1, 6.8, 9.1, 7.9, 'B', 0.3*(0.7*6.8 + 0.3*9.1) + 0.7*7.9),
  ( 4, 1, 9.2, 8.9, 9.5, 'A+', 0.3*(0.7*9.2 + 0.3*8.9) + 0.7*9.5);

CREATE TABLE students_classes (
  student_id INT,
  class_id INT,
  primary key(student_id,class_id),
  FOREIGN KEY (student_id) REFERENCES students(id),
  FOREIGN KEY (class_id) REFERENCES classes(id)
);

ALTER TABLE classes
DROP COLUMN student_registered;