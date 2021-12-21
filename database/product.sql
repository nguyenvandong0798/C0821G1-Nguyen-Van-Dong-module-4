drop database if exists product;
create database product;
use product;

create table product(
	id int primary key,
    name varchar(40),
    price  varchar(40),
    description varchar(40),
    nation varchar(40)
);
insert into product
values(1, "coca", "1000", "drink", "VN");
insert into product
values(2, "Pessi", "1500", "drink", "VN");
insert into product
values(3, "candy", "1000", "food", "VN");
insert into product
values(4, "cake", "1900", "food", "VN");
insert into product
values(5, "mango", "1000", "drink", "VN");
select * from product;