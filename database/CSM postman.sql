drop database if exists cms;
create database cms;
use cms;
create table cms(
	id int primary key ,
    firstName varchar(40),
	lastName varchar(40)
);
insert into cms
values(1, "dong", "nguyen");
insert into cms
values(2, "ba", "la");
insert into cms
values(3, "tom", "cat");
insert into cms
values(4, "jerry", "smount");
select * from cms;