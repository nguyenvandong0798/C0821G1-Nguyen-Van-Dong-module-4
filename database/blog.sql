drop database if exists blog_manager;
create database blog_manager;
use blog_manager;

create table blog_manager(
	id int primary key ,
    name varchar(40),
	content varchar(40),
	note varchar(40)
);
insert into blog_manager values
(1, "dong", "nguyen", "abc"),
(2, "dong", "van", "abc1"),
(3, "ba", "tran", "abc2"),
(4, "tom", "dddd", "abc3");

select * from blog_manager;