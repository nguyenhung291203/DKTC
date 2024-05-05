create database dktc;
use dktc;

CREATE TABLE `users` (
  `id` bigint auto_increment PRIMARY KEY,
  `email` varchar(255),
  `name` varchar(255),
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

CREATE TABLE `departments` (
  `id` bigint PRIMARY KEY,
  `name` nvarchar(255)
);

CREATE TABLE `generations` (
  `id` bigint PRIMARY KEY,
  `name` nvarchar(255)
);

CREATE TABLE `students` (
  `id` bigint PRIMARY KEY,
  `name` varchar(255),
  `phone` varchar(20),
  `address` varchar(255),
  `date_of_birth` DATE,
  `id_user` bigint,
  `id_department` bigint,
  `id_generation` bigint
);

CREATE TABLE `teachers` (
  `id` bigint PRIMARY KEY,
  `name` varchar(255),
  `phone` varchar(20),
  `address` varchar(255),
  `date_of_birth` DATE,
  `expertise` VARCHAR(255),
  `id_user` bigint,
  `id_department` bigint
);

CREATE TABLE `courses` (
  `id` bigint PRIMARY KEY,
  `name` nvarchar(255),
  `id_teacher` bigint,
  `address` nvarchar(255),
  `date_of_week` nvarchar(255),
  `course_size` int,
  `coures_registered` int,
  `start_date` datetime,
  `credit` int
);

CREATE TABLE `coure_register` (
  `id` bigint auto_increment PRIMARY KEY,
  `id_student` bigint,
  `score_number_one` int,
  `score_number_two` int,
  `score_test` int,
  `score_letter` varchar(2),
  `created_date` datetime
);

ALTER TABLE `users_roles` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
ALTER TABLE `users_roles` ADD FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`id_department`) REFERENCES `departments` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`id_generation`) REFERENCES `generations` (`id`);

ALTER TABLE `teachers` ADD FOREIGN KEY (`id_department`) REFERENCES `departments` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

ALTER TABLE `teachers` ADD FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

ALTER TABLE `courses` ADD FOREIGN KEY (`id_teacher`) REFERENCES `teachers` (`id`);

ALTER TABLE `coure_register` ADD FOREIGN KEY (`id_student`) REFERENCES `students` (`id`);

INSERT INTO `roles` VALUES (1,'ROLE_TEACHER'),(2,'ROLE_STUDENT');
INSERT INTO `users` VALUES
(1,'admin@gmail.com','admin','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','admin'),
(2,'nguyenvana@gmail.com','nguyenvana','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','nguyenvana'),
(3,'nguyenvanb@gmail.com','nguyenvanb','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','nguyenvanb'),
(4,'nguyenvanc@gmail.com','nguyenvanc','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','nguyenvanc'),
(5,'nguyenvand@gmail.com','nguyenvand','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','nguyenvand'),
(6,'tranthie@gmail.com','tranthie','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','tranthie'),
(7,'lethif@gmail.com','lethif','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','lethif');
ALTER TABLE departments MODIFY COLUMN name NVARCHAR(255);
INSERT INTO `users_roles` VALUES (1,1);
INSERT INTO `users_roles` VALUES (2,2);
INSERT INTO `users_roles` VALUES (3,2);
INSERT INTO `users_roles` VALUES (4,2);
INSERT INTO `users_roles` VALUES (5,2);
INSERT INTO `users_roles` VALUES (6,1);
INSERT INTO `users_roles` VALUES (7,2);

INSERT INTO `departments` values (1,N'An toàn thông tin'),(2,N'Công nghệ thông tin'),(3,'Điện tử viễn thông');
INSERT INTO `generations` values (1,'AT18'),(2,'AT17'),(3,'CT6'),(4,'DT5');


 

INSERT INTO `students` values (1,N'Nguyễn Văn A','0123456789',N'Hà Nội','2003-1-1',2,1,1),
(2,N'Nguyễn Văn B','0123456789',N'Hà Nội','2002-1-1',3,1,2),
(3,N'Nguyễn Văn C','0123456789',N'Hà Nam','2003-1-1',4,2,3),
(4,N'Nguyễn Văn D','0123456789',N'Hải Phòng','2003-1-1',5,3,4);