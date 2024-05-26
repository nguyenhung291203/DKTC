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
  `id` char PRIMARY KEY,
  `name` nvarchar NOT NULL
);

CREATE TABLE `marjors` (
  `id` char PRIMARY KEY,
  `name` nvarchar NOT NULL,
  `university_id` char(10)
);

CREATE TABLE `classes_subject` (
  `id` char PRIMARY KEY,
  `size` int NOT NULL,
  `start_date` date,
  `subject_id` char,
  `teacher_id` char
);

CREATE TABLE `subjects` (
  `id` char PRIMARY KEY,
  `name` nvarchar NOT NULL,
  `credit` int NOT NULL,
  `theory` int,
  `practice` int,
  `required` tinyint(1) DEFAULT 0
);

CREATE TABLE `students` (
  `id` char(8) PRIMARY KEY,
  `name` nvarchar NOT NULL,
  `date_of_birth` datetime NOT NULL,
  `marjor_id` char,
  `user_id` bigint UNIQUE,
  `class_student_id` int,
  `gpa` float
);

CREATE TABLE `universities` (
  `id` char(10) PRIMARY KEY,
  `name` nvarchar NOT NULL,
  `address` nvarchar
);

CREATE TABLE `teachers` (
  `id` char PRIMARY KEY,
  `name` nvarchar NOT NULL,
  `unit_id` int,
  `position` nvarchar,
  `user_id` bigint UNIQUE
);

CREATE TABLE `units` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` nvarchar NOT NULL
);

CREATE TABLE `points` (
  `student_id` char,
  `classes_subjects_id` char,
  `score_number_one` float,
  `score_number_two` float,
  `score_number_three` float,
  `score_total` float,
  `score_letter` char(2),
  PRIMARY KEY (`student_id`, `classes_subjects_id`)
);

ALTER TABLE `users_roles` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `users_roles` ADD FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

ALTER TABLE `marjors` ADD FOREIGN KEY (`university_id`) REFERENCES `universities` (`id`);

ALTER TABLE `classes_subject` ADD FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

ALTER TABLE `classes_subject` ADD FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`marjor_id`) REFERENCES `marjors` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`class_student_id`) REFERENCES `classes_student` (`id`);

ALTER TABLE `teachers` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `teachers` ADD FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`);

ALTER TABLE `points` ADD FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

ALTER TABLE `points` ADD FOREIGN KEY (`classes_subjects_id`) REFERENCES `classes_subject` (`id`);
