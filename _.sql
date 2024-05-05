CREATE TABLE `users` (
  `id` bigint PRIMARY KEY,
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
  `id` bigint PRIMARY KEY,
  `id_student` bigint,
  `score_number_one` int,
  `score_number_two` int,
  `score_test` int,
  `score_letter` varchar(2),
  `created_date` datetime
);

ALTER TABLE `users_roles` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `users_roles` ADD FOREIGN KEY (`user_id`) REFERENCES `roles` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`id_department`) REFERENCES `departments` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`id_generation`) REFERENCES `generations` (`id`);

ALTER TABLE `teachers` ADD FOREIGN KEY (`id_department`) REFERENCES `departments` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

ALTER TABLE `teachers` ADD FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

ALTER TABLE `courses` ADD FOREIGN KEY (`id_teacher`) REFERENCES `teachers` (`id`);

ALTER TABLE `coure_register` ADD FOREIGN KEY (`id_student`) REFERENCES `students` (`id`);
