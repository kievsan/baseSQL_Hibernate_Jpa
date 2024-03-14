create table if not exists persons (
    name varchar(20) not null ,
    surname varchar(30) not null ,
    age int not null ,
    phone_number varchar(12),
    city_of_living varchar(30),
    primary key (name, surname, age)
);

insert into persons (name, surname, age, phone_number, city_of_living)
VALUES ('Вася', 'Пупкин', 20, '79614005530', 'MOSCOW'),
       ('Сеня', 'Гоцман', 41, '79223334455', 'MOSCOW'),
       ('Мэри', 'Ред', 15, '79376584421', 'VOLGOGRAD'),
       ('alexey', 'Bom', 54, '79326355784', 'EKB'),
       ('Serg', 'Green', 33, '79216320122', 'St.Petersburg');
