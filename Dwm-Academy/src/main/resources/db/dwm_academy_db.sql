-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2021 at 11:51 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dwm_academy_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`, `photo`) VALUES
(1, 'Machine learning', NULL),
(2, 'English', NULL),
(3, 'IA', NULL),
(4, 'Web technologies', NULL),
(5, 'Soft skills', NULL),
(6, 'Big Datag', NULL),
(7, 'Science', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `contents`
--

CREATE TABLE `contents` (
  `id` bigint(20) NOT NULL,
  `duration` date DEFAULT NULL,
  `source` longtext NOT NULL,
  `title` varchar(255) NOT NULL,
  `course_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `admin_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `date`, `description`, `photo`, `title`, `admin_id`, `category_id`, `teacher_id`, `duration`) VALUES
(1, '2021-07-21', 'Web technologies: HTML5, CSS3, JS ES6', NULL, 'Web technologies 101', 1, 1, 1, '30h'),
(2, NULL, 'Machine learning for starters', NULL, 'Machine learning', 1, 1, 1, '1h 30'),
(3, '2021-07-10', 'New ways of learning', NULL, 'New ways of learning', 1, 2, 3, '6h 30');

-- --------------------------------------------------------

--
-- Table structure for table `course_student`
--

CREATE TABLE `course_student` (
  `course_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course_student`
--

INSERT INTO `course_student` (`course_id`, `student_id`) VALUES
(1, 1),
(2, 2),
(2, 1),
(3, 1),
(1, 3),
(1, 1),
(2, 2),
(2, 1),
(3, 1),
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `id` bigint(20) NOT NULL,
  `content` longtext DEFAULT NULL,
  `date` date NOT NULL,
  `student_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `students_courses`
--

CREATE TABLE `students_courses` (
  `id` bigint(20) NOT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `date_birth` date DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `introduction` longtext DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `active`, `date_birth`, `email`, `first_name`, `last_name`, `password`, `photo`, `title`, `type`, `gender`, `introduction`) VALUES
(1, b'1', NULL, 'aziz@dwm.ma', 'Aziz', 'Daaif', '$2a$10$tQSejRVjxWWHBZN0h1.G/OiZKvCpYNjmkuVUKR106YA8Dqfo0UOHS', NULL, 'Analyst', 'ADMIN', NULL, 'Hi I\'m your friend from DWM-Academy'),
(2, b'0', NULL, 'mail@mail.com', 'Ahmed', 'Hassnaoui', '$2a$10$ZwDEUwho6LrdubSulCZ6ReHmyp3PgkxmbVMPb3ydcj8nItwTQJ9Xu', NULL, 'Web analyst', 'TEACHER', NULL, 'Hi I\'m your friend from DWM-Academy'),
(3, b'0', NULL, 'mail@mail.com', 'Fatima', 'Raachid', '$2a$10$ZwDEUwho6LrdubSulCZ6ReHmyp3PgkxmbVMPb3ydcj8nItwTQJ9Xu', NULL, 'Economics expert', 'STUDENT', NULL, 'Hi I\'m your friend from DWM-Academy'),
(4, b'0', NULL, 'mail@mail.com', 'Jihane', 'Arfi', '$2a$10$ZwDEUwho6LrdubSulCZ6ReHmyp3PgkxmbVMPb3ydcj8nItwTQJ9Xu', NULL, 'Web analyst', 'TEACHER', NULL, 'Hi I\'m your friend from DWM-Academy'),
(5, b'0', NULL, 'mail@mail.com', 'Yussra', 'Hassani', '$2a$10$ZwDEUwho6LrdubSulCZ6ReHmyp3PgkxmbVMPb3ydcj8nItwTQJ9Xu', NULL, 'Technical exppert', 'STUDENT', NULL, 'Hi I\'m your friend from DWM-Academy'),
(6, b'0', NULL, 'mail@mail.com', 'Abderrahim', 'Machlou', '$2a$10$ZwDEUwho6LrdubSulCZ6ReHmyp3PgkxmbVMPb3ydcj8nItwTQJ9Xu', NULL, 'Java developer', 'TEACHER', NULL, 'Hi I\'m your friend from DWM-Academy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contents`
--
ALTER TABLE `contents`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK26ra050idh8wetyhulbictirv` (`course_id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp8k8u77nf521mtkpaumuy4nho` (`admin_id`),
  ADD KEY `FK72l5dj585nq7i6xxv1vj51lyn` (`category_id`),
  ADD KEY `FKt4ba5fab1x56tmt4nsypv5lm5` (`teacher_id`);

--
-- Indexes for table `course_student`
--
ALTER TABLE `course_student`
  ADD KEY `FK9sk6xtb4f28j2wjoxwicwljlm` (`student_id`),
  ADD KEY `FKanllvyoexhcxohcqcq4vjgrca` (`course_id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq8b6ve6amab6qc6fin7ywa19k` (`student_id`);

--
-- Indexes for table `students_courses`
--
ALTER TABLE `students_courses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcc42107lsifo5rjyjlhdu6i6u` (`course_id`),
  ADD KEY `FKsx7wif6ufiapmcnk1fnubk9sk` (`student_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `contents`
--
ALTER TABLE `contents`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `students_courses`
--
ALTER TABLE `students_courses`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
