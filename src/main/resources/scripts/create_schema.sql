drop schema if exists restaurant;
create schema restaurant character set utf8 collate utf8_general_ci;
use restaurant;

create table user (
id bigint auto_increment,
name varchar(255),
phone varchar(255),
login varchar(255) unique,
password varchar(255) not null,
role enum("GUEST", "ADMIN", "CHEF"),
primary key (id));

create table dish_menu (
id bigint auto_increment,
`dishType` enum("MAIN", "DESSERT", "DRINKS"),
`name_UK` varchar(255) not null,
`name_EN` varchar(255) not null,
`ingredients_UK` varchar(255) not null,
`ingredients_EN` varchar(255) not null,
`price` DECIMAL(5,2) default 0,
`photo` mediumblob,
primary key (id));

create table `order`(
id bigint auto_increment,
`date` datetime, 
total DECIMAL(5,2) default 0,
userId bigint,
status enum("NEW", "OFFER", "APPROVED",
	"CANCELED", "IN_PROGRESS",
    "COMPLETED", "CLOSED"),
primary key(id),
foreign key (userId) references user(id));

create table order_dish (
id bigint auto_increment,
orderId bigint,
dishId bigint,
quantity int,
primary key (id),
foreign key (orderId) references `order`(id),
foreign key (dishId) references dish_menu(id));

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