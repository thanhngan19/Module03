create database Product123;
create table product(
id int primary key auto_increment,
name_pro nvarchar(50) not null,
price float,
quantity int ,
color nvarchar(50),
description nvarchar(50),
id_category int(50),
foreign key (id_category) references category(id)
);
insert into product set name_pro="Iphone11",price="799.0",quantity=12,color="purple,yellow,green",description="phone",id_category=1;
insert into product set name_pro="Iphone11 pro ",price="111.0",quantity=12,color="purple,yellow,green",description="phone",id_category=1;
insert into product set name_pro="IphoneX",price="749.0",quantity=12,color="purple,yellow,green",description="phone",id_category=1;
insert into product set name_pro="Smart TV",price="100000.0",quantity=5,color="black",description="tele",id_category=2;
insert into product set name_pro="SmartTV012",price ="123",quantity=3,color="red",description="television",id_category=2;
create table category(
id int primary key auto_increment,
category nvarchar(50));
insert into category set category="Phone";
insert into category set category="Television";
select* from category;

select product.name_pro, product.price,product.quantity,product.color,category.category from
product  join category 
on product.id_category=category.id;
update product set name_pro="Iphone12",price="122.00",quantity=12,color="black" where id=2;
select product.id,product.name_pro, product.price,product.quantity,product.color,category.category from 
               product  join category 
               on product.id_category=category.id ;
               select* from product;
			select* from product;
            select category.id from category where category.category="Television";