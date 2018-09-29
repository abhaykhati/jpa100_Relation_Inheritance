-- Course insertion
insert into course (id, name, updaed_Date, created_Date,is_deleted) 
values (10001,'JPA IN 50 STEPS', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),false);

insert into course (id, name,updaed_Date, created_Date,is_deleted) 
values (10002,'Spring IN 100 STEPS', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),false);

insert into course (id, name,updaed_Date, created_Date,is_deleted) 
values (10003,'spring boot IN 50 STEPS', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),false);

insert into course (id, name,updaed_Date, created_Date,is_deleted) 
values (10004,'Unit test IN 10 STEPS', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),false);


--Review insertion
insert into review (id, rating, description, course_id) values (50001,5,'good course ',10001);
insert into review (id, rating, description, course_id) values (50002,4,'best course ',10003);
insert into review (id, rating, description, course_id) values (50003,3,'normal course ',10002);
insert into review (id, rating, description, course_id) values (50004,2,'very bad course ',10004);
insert into review (id, rating, description, course_id) values (50005,1,'very bad course ',10004);



--Passport insertion
insert into Passport (id, number) values (40001,'A2399398');
insert into Passport (id, number) values (40002,'B88372f9');
insert into Passport (id, number) values (40003,'C8383895');
insert into Passport (id, number) values (40004,'T8277373');


--Student insertion
insert into Student (id, name, passport_id) values (20001,'Abhay',40001);
insert into Student (id, name, passport_id) values (20002,'Anand',40002);
insert into Student (id, name, passport_id) values (20003,'Bhagyashree',40003);
insert into Student (id, name, passport_id) values (20004,'prachi',40004);


insert into student_course(student_id, course_id) values(20001,10001);
insert into student_course(student_id, course_id) values(20002,10001);
insert into student_course(student_id, course_id) values(20003,10001);
insert into student_course(student_id, course_id) values(20001,10003);



/*  student without passport id
 * insert into Student (id, name) values (20001,'Abhay');
insert into Student (id, name) values (20002,'Anand');
insert into Student (id, name) values (20003,'Bhagyashree');
insert into Student (id, name) values (20004,'prachi');
 */
