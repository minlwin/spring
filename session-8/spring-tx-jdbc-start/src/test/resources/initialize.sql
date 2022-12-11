set foreign_key_checks = 0;

truncate table account;
truncate table account_history;
truncate table transfer_log;

set foreign_key_checks = 1;

insert into account(name, email, amount) values ('Aung Aung', 'aung@gmail.com', 100000);
insert into account(name, email, amount) values ('Thidar', 'thidar@gmail.com', 100000);
