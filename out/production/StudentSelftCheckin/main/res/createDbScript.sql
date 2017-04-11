CREATE DATABASE SelfCheckInDatabase;
USE SelfCheckInDatabase;

CREATE TABLE Account(
	UsrName varchar(10),
    PassWrd varchar(30),
    IsTheFisrtTime bit,
    primary key(UsrName)
);

CREATE TABLE Teacher(
	TeacherID varchar(10),
	TeacherName nvarchar(50),
    UsrName varchar(30),
    primary key(TeacherID)
);

CREATE TABLE Student(
	StudentID varchar(10),
    StudentName nvarchar (50),
    UsrName varchar(30),
    ClassName varchar(30),
    Sex nvarchar(10),
    DOB date,
    Address nvarchar(200),
    primary key(StudentID)
);

CREATE TABLE ClassSubject(
	SubjectID varchar(10),
    SubjectName nvarchar(50),
    primary key(SubjectID)
);

CREATE TABLE Attendance(
	StudentID varchar(10),
    SubjectID varchar(10),
    CheckInDate date,
    IsCheckedIn bit,
    primary key(StudentID, SubjectID, CheckInDate),
   foreign key(StudentID) references Student(StudentID),
   foreign key(SubjectID) references ClassSubject(SubjectID)
    
);



CREATE TABLE Student_Subject(
	StudentID varchar(10),
    SubjectID varchar(10),
    primary key(StudentID, SubjectID),
    foreign key(StudentID) references Student(StudentID),
    foreign key(SubjectID) references ClassSubject(SubjectID)
);

CREATE TABLE TimeTable(
	TimeTableID varchar(10),
    SubjectID varchar(10),
    StartDate date,
    EndDate date,
    WeekCount int,
    WeekDay nvarchar(10),
    StartTime time,
    EndTime time,
    ClassRoom varchar(20),
    primary key(TimeTableID),
    foreign key(SubjectID) references ClassSubject(SubjectID)
);
