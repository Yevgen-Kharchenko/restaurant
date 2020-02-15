# JDBC Restaurant App

Tема: "Система Ресторан" 

ТЗ: Кліент робить замовлення з Меню. 
Адміністратор підтверджує Замовлення і відправляє його на кухню для виконання.
Адміністратор виставляє Рахунок. Клієнт здійснює його оплату.   
Рівні доступу: GUEST, CHEF, ADMIN.

## Технологіі
- DB - MySql 8.x
- Java version 8 or higher
- Maven

## Встановлення та запуск проекту

1. Clone project with 'git clone' command from command line
2. Install plugin for Lombok library in your IDEA
3. Run create_schema.sql from src/main/resources/scripts folder
4. Run insert_into_schema.sql from src/main/resources/script folder
5. Update DB username and password in scr/main/webapp/META_INF/context.xml (and in db.properties from src/main/resources folder)
6. Start mysql service with 'service mysql start' (http://www.mysqltutorial.org/mysql-adminsitration/start-mysql/)
7. Go to project root ../restaurant directory and run in terminal command 'mvn clean tomcat7:run' or 'mvn tomcat7:run -f pom.xml'
8. Go to link localhost:8880/restaurant and have fan 
9. Use login:admin@g.com password:admin to check up admin functional,
    login:chef@g.com password:chef for chef functional,
    user1@g.com password:password to check up guest functional (or create your own account)

## Доступний функціонал

- #### Рівень доступу - будь-який:

1.  Головна сторінка
2.  Вхід в систему
3.  Реєстрація
4.  Вибір мови
5.  Відвідати інформаційні сторінки (загалом 7 сторінок)

- ####  Рівень доступу - GUEST та будь-який користувач, що зайшов в систему:

6.  Можливість вийти з системи
7.  Зробити замовлення з меню
8.  Переглянути/відмінити зроблене замовлення
9.  Повторити будь-яке попередньо зроблене замовлення
10. Отримати рахунок на виконане замовлення
11. Сплатити рахунок 

- #### Рівень доступу - CHEF:

12. Особистий адміністративний інтерфейс (для кухаря)
12. Переглянути затверджені замовлення для виконання
13. Виконати замовлення

- #### Рівень доступу - ADMIN:

14.  Особистий адміністративний інтерфейс (для адміна)
15.  Перегляд списку замовлень відповідно до статусу
16.  Перегляд кожного окремого замовлення і в залежності від статусу є можливість
17.  Скасувати замовлення
18.  Коригувати замовлення (видалити, додати страви або змінити кількість)
19.  Відмінити замовлення
20.  Схвалити замовлення і відправити на кухню
21.  Виконати замовлення
22.  Виставити рахунок
23.  Отримати рахунок
24.  Скасувати рахунок
25.  Позначити рахунок сплаченим
26.  Можливість коригувати меню (виправляти, додавати та видаляти страви)
27.  Доступ до інтерфейсу кухаря
