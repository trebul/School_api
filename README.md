# School Management System (Backend)

This is a backend application built with Java and Spring Boot for managing a school system. It handles students, teachers, classrooms, exams, grades, schedules, homeworks, subjects and authentication.

## Features
- Student and Teacher Management
- Classroom Assignments and Homeworks
- Exam Scheduling and Grading
- Authentication (Secure API Access)
- Integration and Unit Testing

## API Endpoints

### Authentication
- `POST api/auth/register` - register a new user
- `POST api/auth/authenticate` - authenticate an existing user

### Student
- `GET api/students` - get a list of all students
- `GET api/students/id` - get a specific student
- `GET api/students/id/exams` - get a list of upcoming exams for specified student 
- `PUT api/students/id` - edit an existing student
- `POST api/students` - add a new student
- `DELETE api/students/id` - delete a specific student

### Address
- `GET api/address` - get a list of all addresses
- `GET api/address/id` - get a specific address
- `PUT api/address/id` - edit an existing address
- `POST api/address` - add a new address
- `DELETE api/address/id` - delete a specific address

### Classroom
- `GET api/classroom` - get a list of all classrooms
- `GET api/classroom/id` - get a specific classroom
- `PUT api/classroom/id` - edit an existing classroom
- `POST api/classroom` - add a new classroom
- `DELETE api/classroom/id` - delete a specific classroom

### Exam
- `GET api/exam` - get a list of all exams
- `GET api/exam/id` - get a specific exam
- `GET api/exam/date/upcoming` - get a list of all exams after specific date
- `PUT api/exam/id` - edit an existing exan
- `POST api/exam` - add a new exan
- `DELETE api/exam/id` - delete a specific exam

### Grades
- `GET api/grades` - get a list of all grades
- `GET api/grades/id` - get a specific grade
- `PUT api/grades/id` - edit an existing grade
- `POST api/grades` - add a new grade
- `DELETE api/grades/id` - delete a specific grade

### Homework
- `GET api/homework` - get a list of all homeworks
- `GET api/homework/id` - get a specific homework
- `PUT api/homework/id` - edit an existing homework
- `POST api/homework` - add a new homework
- `DELETE api/homework/id` - delete a specific homework

### Schedules
- `GET api/schedule` - get a list of all schedules
- `GET api/schedule/id` - get a specific schedule
- `GET api/schedule/year/schoolYear` - get a list of schedules from specified year
- `PUT api/schedule/id` - edit an existing schedule
- `POST api/schedule` - add a new schedule
- `DELETE api/schedule/id` - delete a specific schedule

### Subject
- `GET api/subject` - get a list of all subjects
- `GET api/subject/id` - get a specific subject
- `PUT api/subject/id` - edit an existing subject
- `POST api/subject` - add a new subject
- `DELETE api/subject/id` - delete a specific subject

### Teacher
- `GET api/teachers` - get a list of all teachers
- `GET api/teachers/id` - get a specific teacher
- `PUT api/teachers/id` - edit an existing teacher
- `POST api/teachers` - add a new teacher
- `DELETE api/teachers/id` - delete a specific teacher

## Database schema
TBD

## Technologies used
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- JUnit & Mockito
- Lombok

## INSTALATION
1. clone the repository
2. configure the database in `application.properties`
  ```
  spring.datasource.url = jdbc:mysql://localhost:3306/school
  spring.datasource.username=root
  spring.datasource.password=
  ```
3. build and run the project
   ```
   mvn clean install
   mvn spring-boot:run
   ```
