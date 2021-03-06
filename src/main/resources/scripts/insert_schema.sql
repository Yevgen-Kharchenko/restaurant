﻿use restaurant;

insert into `user` (`name`, `phone`,`login`, `password`, `role`) values
('Сергій', '11234567','admin@g.com', '$2a$12$BzcrGYG77xPP4EtfdV1WtOCb67RtnTAvUmSPyOuB74ADsUeRsIlGW', 'ADMIN'),
('Іван', '11234568','chef@g.com', '$2a$12$GTu0O1ULT5P8ABNLG6/Pe.TPfkOIMCC3AkfzY2fVJhj8CGuMhNMKW', 'CHEF'),
('Папа', '11234560','user1@g.com', '$2a$12$LrhyEt833iv1Yhz356BOyu0oRlIxaeypIaunQsckiRtlonmSB21oK', 'GUEST'),
('Буратіно', '11234571','user2@g.com', '$2a$12$LrhyEt833iv1Yhz356BOyu0oRlIxaeypIaunQsckiRtlonmSB21oK', 'GUEST'),
('Федір', '11234572','user3@g.com', '$2a$12$LrhyEt833iv1Yhz356BOyu0oRlIxaeypIaunQsckiRtlonmSB21oK', 'GUEST'),
('Дженіфер', '11234573','user4@g.com', '$2a$12$LrhyEt833iv1Yhz356BOyu0oRlIxaeypIaunQsckiRtlonmSB21oK', 'GUEST');

insert into `dish_menu` (`dishType`, `name_UK`, `name_EN`, `ingredients_UK`, `ingredients_EN`,`price`,`photo`)values
		 ('MAIN','Яловичина на грилі з картоплею', 'Grilled Beef with potatoes', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',10.0,'dish-1.jpg'),
		 ('MAIN','Фруктове ванільне морозиво', 'Fruit Vanilla Ice Cream', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',11.0,'dish-2.jpg'),
		 ('MAIN','Азіатська свиняча свинина', 'Asian Hoisin Pork', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',12.0,'dish-3.jpg'),
		 ('MAIN','Пряний смажений рис і бекон', 'Spicy Fried Rice & Bacon', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',13.0,'dish-4.jpg'),
		 ('MAIN','Манго чилі Чатні', 'Mango Chili Chutney', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',14.0,'dish-5.jpg'),
		 ('MAIN','Китайські млинці смачні крес-салати', 'Savory Watercress Chinese Pancakes', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',15.0,'dish-6.jpg'),
		 ('MAIN','Суп з овочами та м`ясом', 'Soup With Vegetables And Meat', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',16.0,'dish-7.jpg'),
		 ('MAIN','Локшина Удон з овочами', 'Udon Noodles With Vegetables', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',17.0,'dish-8.jpg'),
		 ('MAIN','Запечений омар з гарніром', 'Baked Lobster With A Garnish', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',18.0,'dish-9.jpg'),
		 ('MAIN','Восьминіг з овочами', 'Octopus with Vegetables', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',19.0,'dish-10.jpg'),

		 ('DESSERT','Яловичина на грилі з картоплею', 'Grilled Beef with potatoes', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',20.0,'dish-11.jpg'),
		 ('DESSERT','Восьминіг з овочами', 'Octopus with Vegetables', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',21.0,'dish-12.jpg'),
		 ('DESSERT','Восьминіг з овочами', 'Octopus with Vegetables', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',22.0,'dish-13.jpg'),
		 ('DESSERT','Восьминіг з овочами', 'Octopus with Vegetables', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',23.0,'dish-14.jpg'),
		 ('DESSERT','Восьминіг з овочами', 'Octopus with Vegetables', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',24.0,'dish-15.jpg'),
		 ('DESSERT','Тирамісу', 'Tiramisu', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',25.0,'dish-16.jpg'),
		 ('DESSERT','Шоколадний крем', 'Chocolate Cream', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',26.0,'dish-17.jpg'),
		 ('DESSERT','Пиріг для піци', 'Pizza Pie', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',27.0,'dish-18.jpg'),
		 ('DESSERT','Сицилійська Рікотта', 'Sicilian Ricotta', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',28.0,'dish-19.jpg'),
		 ('DESSERT','Манго FLOat', 'Mango FLoat', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',29.0,'dish-20.jpg'),

         ('DRINKS','Лимонний сік', 'Lemon Juice', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',7.5,'dish-21.jpg'),
		 ('DRINKS','Сік Гуави', 'Guava Juice', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',6.4,'dish-22.jpg'),
		 ('DRINKS','Спрайт', 'Sprite', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',5.9,'dish-23.jpg'),
		 ('DRINKS','Кола', 'Cola', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',4.2,'dish-24.jpg'),
		 ('DRINKS','Вино', 'Wine', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',9.9,'dish-25.jpg'),
		 ('DRINKS','Пиво', 'Beer', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',10.1,'dish-26.jpg'),
		 ('DRINKS','Сік манго', 'Mango Juice', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',3.3,'dish-27.jpg'),
		 ('DRINKS','Яблучний сік', 'Apple Juice', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',8.6,'dish-28.jpg'),
		 ('DRINKS','Полуничний сік', 'Strawberry Juice', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',7.7,'dish-29.jpg'),
		 ('DRINKS','Помаранчевий сік', 'Orange Juice', 'М`ясо, Картопля, Рис, Помідори', 'Meat, Potatoes, Rice, Tomatoes',20.8,'dish-30.jpg');

insert into `order` (`date`, `total`, `userId`, `status`)
		values ('2019-08-20 10:00:00',68.0,4,'CLOSED'), ('2019-08-23 10:00:00',112.0,5,'COMPLETED'), ('2019-08-25 10:00:00',128.0,6,'IN_PROGRESS'),
		('2019-09-02 10:00:00',117.0,6,'CANCELED'), ('2019-09-12 10:00:01',149.8,4,'IN_PROGRESS'), ('2019-09-22 10:00:02',33.4,5,'IN_PROGRESS'),
		('2019-09-30 10:00:03',37.6,6,'CLOSED'), ('2019-10-02 10:00:04',71,6,'NEW'), ('2019-10-02 11:00:05',10,4,'NEW');

insert into `order_dish` (`orderId`, `dishId`, `quantity`)
		values (1,1,1), (1,2,2), (1,3,3),
		(2,4,1), (2,5,6), (2,6,1),
		(3,7,1), (3,8,2), (3,9,1),(3,10,1), (3,11,2), (3,12,1),
		(4,13,1), (4,14,2), (4,15,1),(4,16,1),
		(5,17,1), (5,18,2), (5,19,1),(5,20,1), (5,22,2),
		(6,21,1), (6,23,2), (6,24,1),(6,25,1),
		(7,26,1), (7,27,6), (7,29,1),
		(8,28,1), (8,30,3),
		(9,1,1);

