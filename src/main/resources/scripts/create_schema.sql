drop schema if exists restaurant;
create schema restaurant character set utf8 collate utf8_general_ci;
use restaurant;

create table user (
id long auto_increment,
name varchar(255),
phone varchar(255),
login varchar(255) unique,
password varchar(255) not null,
role enum("GUEST", "ADMIN", "CHEF"),
primary key (id));

create table repairs_types (
id int auto_increment,
title varchar(255) not null,
primary key (id));

create table `order`(
id int auto_increment,
`date` datetime, 
price double default 0,
repairsTypesId int,
userId int,
status enum("NEW", "OFFER", "APPROVED",
	"CANCELED", "IN_PROGRESS",
    "COMPLETED", "CLOSED"),
primary key(id),
foreign key (repairsTypesId) references repairs_types(id),
foreign key (userId) references user(id));

create table comments(
id int auto_increment,
`date` datetime,
`comment` varchar(1000) not null,
userId int,
orderId int,
primary key (id),
foreign key (userId) references user(id),
foreign key (orderId) references `order`(id));

create table feedback(
id int auto_increment,
`date` datetime,
feedback varchar(2000) not null,
userId int,
primary key (id),
foreign key (userId) references user(id)
);