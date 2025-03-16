CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL PRIMARY KEY,
  `city` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `street_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `teacher` (
  `teacherid` int(11) NOT NULL PRIMARY KEY,
  `age` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `classroom` (
  `id` int(11) NOT NULL PRIMARY KEY,
  `floor` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `teacher_fk` int(11) DEFAULT NULL,
  FOREIGN KEY (`teacher_fk`) REFERENCES `teacher` (`teacherid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `schedule` (
  `id` int(11) NOT NULL PRIMARY KEY,
  `school_year` varchar(255) DEFAULT NULL,
  `classroom_fk` int(11) DEFAULT NULL,
  FOREIGN KEY (`classroom_fk`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL PRIMARY KEY,
  `age` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `address_fk` int(11) DEFAULT NULL,
  `student_fk` int(11) DEFAULT NULL,
  `schedule_fk` int(11) DEFAULT NULL,
  FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`),
  FOREIGN KEY (`student_fk`) REFERENCES `classroom` (`id`),
  FOREIGN KEY (`schedule_fk`) REFERENCES `schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `grades` (
  `id` int(11) NOT NULL PRIMARY KEY,
  `date_of_grade` varchar(255) DEFAULT NULL,
  `grade` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacherid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `subject` (
  `id` int(11) NOT NULL PRIMARY KEY,
  `end_of_subject` datetime(6) DEFAULT NULL,
  `start_of_subject` datetime(6) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  `subject_fk` int(11) DEFAULT NULL,
  FOREIGN KEY (`subject_fk`) REFERENCES `schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL PRIMARY KEY,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;