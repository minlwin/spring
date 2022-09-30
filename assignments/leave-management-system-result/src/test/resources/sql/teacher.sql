insert into account (name, role, email, password) values ('Maung Maung', 'Teacher', 'maung@gmail.com', 'pass');
insert into account (name, role, email, password) values ('Aung Aung', 'Teacher', 'aung@gmail.com', 'pass');
insert into account (name, role, email, password) values ('Thidar', 'Teacher', 'thidar@gmail.com', 'pass');

insert into teacher values (1, '09782929282', '2022-08-01');
insert into teacher values (2, '0972626827', '2022-09-01');
insert into teacher values (3, '08928282711', '2022-10-01');

insert into classes (teacher_id, start_date, months, description) values (1, '2022-08-10', 3, 'Demo Class');
insert into classes (teacher_id, start_date, months, description) values (1, '2022-09-10', 3, 'Demo Class');
insert into classes (teacher_id, start_date, months, description) values (2, '2022-09-10', 3, 'Demo Class');

