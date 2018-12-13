
-- Drop Database ----------------------------------------

DROP DATABASE IF EXISTS southpark_db;



-- Create Database, Connect, Create Schema and Extensions -----------------

CREATE DATABASE southpark_db;

\c southpark_db;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;





-- Students -----------------

CREATE TABLE students (
  -- student_id uuid NOT NULL PRIMARY KEY unique DEFAULT uuid_generate_v4(),
  student_id SERIAL PRIMARY KEY,
  first_name VARCHAR (300) NOT NULL,
  last_name VARCHAR (300) NOT NULL,
  grade VARCHAR (300) NOT NULL,
  email VARCHAR (300) NOT NULL UNIQUE
);


INSERT INTO students (first_name, last_name, grade, email) VALUES
  ('Eric', 'Cartman', 4, 'eric@mail.com'),
  ('Kenny', 'McCormick', 4, 'kenny@mail.com'),
  ('Kyle', 'Broflovski', 4, 'kyle@mail.com'),
  ('Stan', 'Marsh', 4, 'stan@mail.com'),
  ('Luke', 'Skywalker', 4, 'luke@mail.com'),
  ('Darth', 'Vader', 4, 'anakin@mail.com'),
  ('Liea', 'Organa', 4, 'liea@mail.com'),
  ('Han', 'Solo', 4, 'han@mail.com'),
  ('Lando', 'Calrissian', 4, 'lando@mail.com'),
  ('Jabba', 'Hut', 4, 'jabba@mail.com'),
  ('Boba', 'Fett', 4, 'boba@mail.com'),
  ('Obi-Wan', 'Kenobi', 4, 'obi@mail.com');



-- COURSES ----------------------------------

CREATE TABLE courses (
  course_id uuid NOT NULL PRIMARY KEY unique DEFAULT uuid_generate_v4(),
  title VARCHAR NOT NULL,
  room VARCHAR NOT NULL,
  course_time VARCHAR NOT NULL
  -- teacher_id uuid NOT NULL
);


INSERT INTO courses (title, room, course_time) VALUES
-- INSERT INTO courses (title, room, course_time, teacher_id) VALUES
  ('English', '1A', '8:00'),
  ('Chemistry', '1B', '12:15'),
  ('History', '1C', '13:00'),
  ('Statistics', '1D', '10:30'),
  ('Algebra', '2A', '9:20'),
  ('Literature', '2B', '10:30'),
  ('Social Studies', '2C', '8:00'),
  ('Biology', '2D', '9:20');



-- TEACHERS ----------------------------------

CREATE TABLE teachers (
  teacher_id uuid NOT NULL PRIMARY KEY unique DEFAULT uuid_generate_v4(),
  name VARCHAR NOT NULL,
  email VARCHAR (300) NOT NULL UNIQUE
);

INSERT INTO teachers (name, email) VALUES
  ('Mr Garrison', 'garrison@mail.com'),
  ('Mr Hand', 'hand@mail.com'),
  ('Mr Mackey', 'mackey@mail.com');



-- ENROLLMENTS --------------------------------

-- CREATE TABLE enrollments (
--   enrollment_id uuid NOT NULL PRIMARY KEY unique DEFAULT uuid_generate_v4(),
--   course_id uuid NOT NULL,
--   student_id uuid NOT NULL
--   -- FOREIGN KEY (course_id) REFERENCES courses(course_id),
--   -- FOREIGN KEY (student_id) REFERENCES students(student_id)
-- );
--
-- INSERT INTO enrollments (course_id, student_id) VALUES
--   (1, 1),
--   (2, 1),
--   (3, 1),
--   (1, 2),
--   (2, 2),
--   (1, 3),
--   (2, 3),
--   (3, 3),
--   (4, 4),
--   (5, 4),
--   (4, 5),
--   (5, 5),
--   (6, 6),
--   (6, 7),
--   (7, 7),
--   (7, 8),
--   (8, 8);




-- Confirm Inserts -----------------------------

SELECT * FROM students;




-- END
