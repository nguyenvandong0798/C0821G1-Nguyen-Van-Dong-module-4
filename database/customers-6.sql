drop database if exists customers;
create database customers;
use customers;

create table customers(
	id int primary key,
    firstName varchar(40),
	lastName varchar(40)
);
insert into customers
values(1, "dong", "nguyen");
insert into customers
values(2, "ba", "la");
insert into customers
values(3, "tom", "cat");
insert into customers
values(4, "jerry", "smount");
select * from customers;