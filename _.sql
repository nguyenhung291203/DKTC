create database manager_point;
use manager_point;

CREATE TABLE `users` (
  `id` bigint PRIMARY KEY,
  `email` varchar(255),
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
);

CREATE TABLE `roles` (
  `id` bigint PRIMARY KEY,
  `name` varchar(255)
);

CREATE TABLE `users_roles` (
  `user_id` bigint,
  `role_id` bigint,
  PRIMARY KEY (`user_id`, `role_id`)
);

CREATE TABLE `classes_student` (
  `id` char(10) PRIMARY KEY,
  `name` nvarchar(255) NOT NULL,
  `marjor_id` char(10)
);

CREATE TABLE `marjors` (
  `id` char(10) PRIMARY KEY,
  `name` nvarchar(255) NOT NULL,
  `university_id` char(10)
);

CREATE TABLE `classes_subject` (
  `id` char(10) PRIMARY KEY,
  `size` int NOT NULL,
  `start_date` date,
  `subject_id` char,
  `teacher_id` char
);

CREATE TABLE `subjects` (
  `id` char(10) PRIMARY KEY,
  `name` nvarchar(255) NOT NULL,
  `credit` int NOT NULL,
  `theory` int,
  `practice` int,
  `required` tinyint(1) DEFAULT 0
);

CREATE TABLE `students` (
  `id` char(8) PRIMARY KEY,
  `name` nvarchar(255) NOT NULL,
  `date_of_birth` datetime NOT NULL,
  `user_id` bigint UNIQUE,
  `class_student_id` char(10),
  `gpa` float
);

CREATE TABLE `universities` (
  `id` char(10) PRIMARY KEY,
  `name` nvarchar(255) NOT NULL,
  `address` nvarchar(255)
);

CREATE TABLE `teachers` (
  `id` char(8) PRIMARY KEY,
  `name` nvarchar(255) NOT NULL,
  `unit_id` int,
  `position` nvarchar(255),
  `user_id` bigint UNIQUE
);

CREATE TABLE `units` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` nvarchar(255) NOT NULL
);

CREATE TABLE `points` (
  `student_id` char(8),
  `classes_subjects_id` char(10),
  `score_number_one` float,
  `score_number_two` float,
  `score_number_three` float,
  `score_total` float,
  `score_letter` char(2),
  PRIMARY KEY (`student_id`, `classes_subjects_id`)
);

ALTER TABLE `users_roles` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `users_roles` ADD FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

ALTER TABLE `classes_student` ADD FOREIGN KEY (`marjor_id`) REFERENCES `marjors` (`id`);

ALTER TABLE `marjors` ADD FOREIGN KEY (`university_id`) REFERENCES `universities` (`id`);

ALTER TABLE `classes_subject` ADD FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

ALTER TABLE `classes_subject` ADD FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`class_student_id`) REFERENCES `classes_student` (`id`);

ALTER TABLE `teachers` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `teachers` ADD FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`);

ALTER TABLE `points` ADD FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

ALTER TABLE `points` ADD FOREIGN KEY (`classes_subjects_id`) REFERENCES `classes_subject` (`id`);

INSERT INTO universities (id, name, address) VALUES
('HUS', 'Trường Đại học Khoa học Tự nhiên', 'Số 334 Nguyễn Trãi, Thành Công, Ba Đình, Hà Nội'),
('USSH', 'Trường Đại học Khoa học Xã hội và Nhân văn', 'Số 336 Nguyễn Trãi, Thành Công, Ba Đình, Hà Nội'),
('ULIS', 'Trường Đại học Ngoại ngữ', 'Phạm Văn Đồng, Cầu Giấy, Hà Nội'),
('UET', 'Trường Đại học Công nghệ', 'Số 144 Xuân Thủy, Cầu Giấy, Hà Nội'),
('UEB', 'Trường Đại học Kinh tế', 'Số 144 Xuân Thủy, Cầu Giấy, Hà Nội'),
('UEd', 'Trường Đại học Giáo dục', 'Số 144 Xuân Thủy, Cầu Giấy, Hà Nội'),
('VJU', 'Trường Đại học Việt - Nhật', 'Số 912 Nguyễn Văn Linh, Long Biên, Hà Nội'),
('UMP', 'Trường Đại học Y Dược', 'Số 1A Tôn Thất Tùng, Đống Đa, Hà Nội'),
('UL', 'Trường Đại học Luật', 'Số 87 Nguyễn Chí Thanh, Đống Đa, Hà Nội');


INSERT INTO `marjors` (`id`, `name`, `university_id`) VALUES
('QHT05', 'Công nghệ kỹ thuật hạt nhân', 'HUS'),
('QHT42', 'Công nghệ kỹ thuật hoá học**', 'HUS'),
('QHT46', 'Công nghệ kỹ thuật môi trường**', 'HUS'),
('QHT97', 'Công nghệ quan trắc và giám sát tài nguyên môi trường*', 'HUS'),
('QHT43', 'Hoá dược',  'HUS'),
  ('QHT06', 'Hoá học', 'HUS'),
  ('QHT41', 'Hoá học***', 'HUS'),
    ('QHT16', 'Khí tượng và khí hậu học', 'HUS'),
  ('QHT93', 'Khoa học dữ liệu*', 'HUS'),
  ('QHT98', 'Khoa học máy tính và thông tin*', 'HUS'),
  ('QHT13', 'Khoa học môi trường', 'HUS'),
  ('QHT91', 'Khoa học thông tin địa không gian*', 'HUS'),
  ('QHT96', 'Khoa học và công nghệ thực phẩm*', 'HUS') ,
  ('QHX01','Báo chí', 'USSH') ,
  ('QHX40', 'Báo chí - CTĐT CLC', 'USSH'),
  ('QHX02', 'Chính trị học', 'USSH'),
   ('QHX03', 'Công tác xã hội', 'USSH'),
  ('QHX06', 'Hán Nôm', 'USSH'),
  ('QHX26', 'Hàn Quốc học', 'USSH'),
  ('QHX07', 'Khoa học quản lý', 'USSH'),
  ('QHX41', 'Khoa học quản lý - CTĐT CLC', 'USSH'),
  ('QHX08', 'Lịch sử', 'USSH'),
  ('QHX09', 'Lưu trữ học', 'USSH'),
  ('QHX10', 'Ngôn ngữ học', 'USSH'),
  ('QHX11', 'Nhân học', 'USSH'),
  ('QHX12', 'Nhật Bản học', 'USSH'),
  ('7140231', 'Sư phạm tiếng Anh', 'USSH'),
  ('7140237', 'Sư phạm tiếng Hàn Quốc', 'USSH'),
  ('7140236', 'Sư phạm tiếng Nhật', 'USSH'),
  ('7140234', 'Sư phạm tiếng Trung Quốc', 'USSH'),
  ('7220202', 'Ngôn ngữ Nga', 'USSH'),
  ('7220209', 'Ngôn ngữ Nhật CTĐT CLC', 'USSH'),
  ('7220203', 'Ngôn ngữ Pháp CTĐT CLC', 'USSH'),
  ('7220204', 'Ngôn ngữ Trung Quốc CTĐT CLC', 'USSH'),
  ('7220205', 'Ngôn ngữ Đức CTĐT CLC', 'USSH'),
  ('CN4', 'Cơ kỹ thuật', 'UET'),
  ('CN7', 'Công nghệ Hàng không vũ trụ*', 'UET'),
  ('CN6', 'Công nghệ kỹ thuật cơ điện tử', 'UET'),
  ('CN5', 'Công nghệ kỹ thuật xây dựng', 'UET'),
  ('CN9', 'Công nghệ kỹ thuật điện tử - viễn thông', 'UET'),
  ('CN10', 'Công nghệ nông nghiệp', 'UET'),
  ('CN1', 'Công nghệ Thông tin', 'UET'),
  ('CN16', 'Công nghệ thông tin định hướng thị trường Nhật Bản', 'UET'),
  ('CN14', 'Hệ thống thông tin', 'UET'),
  ('CN8', 'Khoa học máy tính', 'UET'),
  ('CN2', 'Kỹ thuật máy tính', 'UET'),
  ('CN13', 'Kỹ thuật năng lượng', 'UET'),
  ('CN17', 'Kỹ thuật Robot', 'UET');
  
  


  INSERT INTO `subjects` (`id`, `name`, `credit`, `theory`, `practice`, `required`) VALUES
('PES1003', 'Giáo dục thể chất cơ bản', 1, 1, 12, 1),
('PES1005', 'Thể dục Aerobic 1', 1, 1, 12, 1),
('PES1006', 'Thể dục Aerobic 2', 1, 1, 12, 0),
('PES1007', 'Thể dục Aerobic 3', 1, 1, 12, 0),
('PES1010', 'Bơi lội 1', 1, 1, 12, 1),
('PES1011', 'Bơi lội 2', 1, 1, 12, 0),
('PES1012', 'Bơi lội 3', 1, 1, 12, 0),
('PES1015', 'Bóng chuyền 1', 1, 1, 12, 1),
('PES1016', 'Bóng chuyền 2', 1, 1, 12, 0),
('PES1017', 'Bóng chuyền 3', 1, 1, 12, 0),
('PES1020', 'Bóng rổ 1', 1, 1, 12, 1),
('PES1021', 'Bóng rổ 2', 1, 1, 12, 0),
('PES1022', 'Bóng rổ 3', 1, 1, 12, 0),
('PES1025', 'Bóng đá 1', 1, 1, 12, 1),
('PES1026', 'Bóng đá 2', 1, 1, 12, 0),
('PES1027', 'Bóng đá 3', 1, 1, 12, 0),
('PES1030', 'Bóng bàn 1', 1, 1, 12, 1),
('PES1031', 'Bóng bàn 2', 1, 1, 12, 0),
('PES1032', 'Bóng bàn 3', 1, 1, 12, 0),
('PES1035', 'Cầu lông 1', 1, 1, 12, 1),
('PES1036', 'Cầu lông 2', 1, 1, 12, 0),
('PES1037', 'Cầu lông 3', 1, 1, 12, 0),
('PES1040', 'Quần vợt 1', 1, 1, 12, 1),
('PES1041', 'Quần vợt 2', 1, 1, 12, 0),
('PES1042', 'Quần vợt 3', 1, 1, 12, 0);
  
  
  INSERT INTO `roles` VALUES (1,'ROLE_STUDENT'),(2,'ROLE_TEACHER');
  
  -- Create the `users` table
CREATE TABLE `users` (
  `id` bigint PRIMARY KEY,
  `email` varchar(255),
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
);

-- Insert 10 sample data rows
INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
(1, 'user1@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user1'),
(2, 'user2@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user2'),
(3, 'user3@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user3'),
(4, 'user4@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user4'),
(5, 'user5@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user5'),
(6, 'user6@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user6'),
(7, 'user7@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user7'),
(8, 'user8@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user8'),
(9, 'user9@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user9'),
(10, 'user10@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'user10');


INSERT INTO `users` (`id`, `email`, `username`) VALUES
(11,'user10@example.com',  'user11'),
(12, 'user12@example.com', 'user12'),
(13, 'user13@example.com', 'user13'),
(14, 'user14@example.com', 'user14'),
(15, 'user15@example.com', 'user15'),
(16, 'user16@example.com', 'user16'),
(17, 'user17@example.com', 'user17'),
(18, 'user18@example.com', 'user18'),
(19, 'user19@example.com', 'user19');
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(15, 2),
(16, 2),
(17, 2),
(18, 2),
(19, 2);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 2),
(10, 2);



INSERT INTO `classes_student` (`id`, `name`, `marjor_id`)
    SELECT CONCAT(m.id, 'C'), CONCAT(m.name, 'C'), m.id
    FROM `marjors` m;
    
    INSERT INTO `units` (`name`) VALUES
  ('Bộ môn Lý luận'),
  ('Các môn Thể thao Cá nhân'),
  ('Khối Hành chính'),
  ('Bộ môn Các môn Thể thao Tập thể');



INSERT INTO `students` (`id`, `name`, `date_of_birth`, `user_id`, `class_student_id`, `gpa`) VALUES
('USSH0001', N'Nguyễn Văn Hưng', '2005-01-01 00:00:00', 1, '7140231A', 3.5),
('USSH0002', N'Nguyễn Hương Giang', '2005-02-15 00:00:00', 2, '7140231A', 3.7),
('USSH0003', N'Trần Minh Hải', '2004-07-20 00:00:00', 3, '7140231A', 3.2),
('USSH0004', N'Lê Thị Thanh Nhàn', '2006-04-05 00:00:00', 4, '7140231C', 3.9),
('USSH0005', N'Phạm Quang Vinh', '2005-11-12 00:00:00', 5, '7140231C', 3.6),
('USSH0006', N'Đỗ Thị Bích Ngọc', '2004-08-30 00:00:00', 6, '7140231C', 3.8),
('USSH0007', N'Hoàng Văn Dũng', '2005-06-18 00:00:00', 7, '7140234C', 3.4),
('USSH0008', N'Bùi Thị Minh Anh', '2006-02-27 00:00:00', 8, '7140234C', 3.1);



INSERT INTO `classes_subject` (`id`, `subject_id`, `teacher_id`)
    SELECT CONCAT(s.id, 'A'),s.id, 'GD023'
    FROM `subjects` s;
    
    
    INSERT INTO `classes_subject` (`id`, `subject_id`, `teacher_id`)
    SELECT CONCAT(s.id, 'B'),s.id, 'GD033'
    FROM `subjects` s;
    

SHOW CREATE TABLE marjors;

ALTER TABLE marjors
ADD CONSTRAINT `marjors_ibfk_1` FOREIGN KEY (`university_id`) REFERENCES `universities` (`id`);

ALTER TABLE manager_point.marjor
DROP FOREIGN KEY FK1m78rb14cgowu32imxnynvmhk;

ALTER TABLE marjors
DROP FOREIGN KEY marjors_ibfk_1;