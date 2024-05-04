create database dktc;
use dktc;

INSERT INTO `user` VALUES
(1,'ramesh@gmail.com','ramesh','$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em','ramesh'),
(2,'admin@gmail.com','admin','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','admin');

INSERT INTO `role` VALUES (1,'ROLE_TEACHER'),(2,'ROLE_STUDENT');

INSERT INTO `users_roles` VALUES (2,1),(1,2);