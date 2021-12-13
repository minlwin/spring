-- Data Definitiion Language
drop table if exists MEMBER;

create table if not exists MEMBER (
	loginId varchar(8) primary key,
	password varchar(8) not null,
	name varchar(20) not null,
	phone varchar(12),
	email varchar(40)
);

