insert into account(name, email, password, role, version) values ('Admin User', 'admin@gmail.com', 'admin', 0, 0);

insert into profile(account_code, version, dob, image) values (1, 0, '2000-01-01', 'profile.jpg');
insert into address(account_code, version, address_type, building, street, zipcode) values (1, 0, 0, 'No 11', 'San Yeik Nyein 6th Street', '11111');

insert into account(name, email, password, role, version) values ('Aung Aung', 'aung@gmail.com', 'aung', 1, 0);
