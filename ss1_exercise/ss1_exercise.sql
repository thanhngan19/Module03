create table class(
id int primary key auto_increment,
name varchar(50)
);
insert into class(name)
value("ngân"),
("thanh");
delete from class where(id=1);
insert into class(name)
values ("thanh"),("ngân"),("hải");
update class
set name="mỳ"
where id=6;
alter table class
add number_phone varchar(50) after id;
insert into class(number_phone)
values ("0987773733");
delete from class where (id=7);
alter table class
rename column number_phone  TO email ;
-- select*from class
create table teacher(
id int primary key auto_increment,
age int,
country varchar(50),
teacher_name varchar(50)
);
