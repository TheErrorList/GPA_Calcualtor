create database GPA_Calculator;
show databases;
use GPA_Calculator;
create table Grade_Point_Table (
	Grade varchar(7),
	Grade_Point_Value float(3,2),
    primary key(Grade)
    );
insert into Grade_Point_Table values
	("A+",4.00),
	("A",4.00),
	("A-",3.70),
	("B+",3.30),
	("B",3.00),
	("B-",2.70),
	("C+",2.30),
	("C",2.00),
	("C-",1.70),
	("D+",1.30),
	("D",1.00),
	("E",0.00);

create table Result_Table (
Course_Code char(9) not null,
acadamic_year nchar(4),
Grade varchar(2),
Credits int);

select * from Grade_Point_Table;
select * from Result_Table;

drop table Result_Table;
insert into Result_Table values
('SENG11223',1,'A',3),
('SENG11213',1,'B',3),
('SENG21222',2,'A+',2);




