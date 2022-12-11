create database transfer_db;
create user 'transfer'@'localhost' identified by 'transfer';
grant all privileges on transfer_db.* to 'transfer'@'localhost';

use transfer_db

create table account (
	id int primary key auto_increment,
	name varchar(20) not null,
	email varchar(255) not null,
	amount int,
	check(amount >= 0)
);

create table transfer_log (
	id int primary key auto_increment,
	account_from int not null,
	account_to int not null,
	amount int not null,
	transfer_at timestamp default CURRENT_TIMESTAMP,
	status boolean default false,
	message varchar(255),
	foreign key (account_from) references account(id),
	foreign key (account_to) references account(id)
);

create table account_history (
	id int primary key auto_increment,
	transfer_id int not null,
	account_id int not null,
	type varchar(20) not null,
	before_amount int not null,
	amount int not null,
	foreign key (transfer_id) references transfer_log(id),
	foreign key (account_id) references account(id)
);