insert into account (name, role, email, password) values ('Alex', 'Student', 'alex@gmail.com', '12345');
insert into account (name, role, email, password) values ('Bo Bo', 'Student', 'bobo@gmail.com', '12345');
insert into account (name, role, email, password) values ('Thein Thein', 'Student', 'thein@gmail.com', '12345');

insert into account (name, role, email, password) values ('Aung Aung', 'Teacher', 'aung@gmail.com', '12345');
insert into account (name, role, email, password) values ('Maung Maung', 'Teacher', 'maung@gmail.com', '12345');

insert into student values (1, '0911112222', 'BEHS');
insert into student values (2, '0911112223', 'Master');
insert into student values (3, '0911112224', 'BEHS');

insert into teacher values (4, '0911112225', '2022-09-01');
insert into teacher values (5, '0911112226', '2022-09-10');

insert into classes (teacher_id, start_date, months, description) values (4, '2022-10-28', 4, 'Java Basic Center Class');
insert into classes (teacher_id, start_date, months, description) values (5, '2022-11-03', 4, 'Java Basic Online Class');

insert into registration values (1, 1, '2022-09-20');
insert into registration values (1, 2, '2022-09-21');
insert into registration values (2, 3, '2022-09-22');
