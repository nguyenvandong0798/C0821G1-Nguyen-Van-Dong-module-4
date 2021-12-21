drop database if exists customer;
create database customer;
use customer;

create table customer(
	id int primary key,
    name varchar(40),
    email  varchar(40),
    address varchar(40)
);
insert into customer
values(1, "dong", "nguyenvandong098@gmail.com", "quang nam");
insert into customer
values(2, "lanh", "lanh098@gmail.com", "quang nam");
insert into customer
values(3, "nghia", "nghia@gmail.com", "quang nam");
insert into customer
values(4, "du", "du098@gmail.com", "quang nam");
