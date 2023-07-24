create table  Products(
id int  primary key auto_increment,
productCode varchar(50),
productName varchar(50),
productPrice double ,
productAmount int check(productAmount>0),
productDescription varchar(50),
productStatus varchar(50));
insert into  Products(`productCode`,`productName`,`productPrice`,`productAmount`,`productDescription`,`productStatus`) values ('12acb','fan',12,2,'quat mat', 'available')
,('12acb1','elec',13,4,'sang', 'available')
,('12acb2','lap',14,2,'usedd', 'available')
,('12acb3','huue',15,2,'huuuee', 'available');
select * from Products;
create index index_procduct_productscode on Products (productCode);
create index productName_productPrice on Products (productName,productPrice);
explain select * from Products where productCode ='12acb3';
create view view_product (productCode,productName,productPrice) as select productCode,productName,productPrice from Products;
update view_product set productName='ngann' where productCode='12acb1';
select * from view_product;
drop view view_product;
delimiter //
create procedure find_inf()
begin 
select * from Products ;
end //
delimiter ;
call find_inf;

delimiter //
create procedure add_new(productCode varchar(50), productName varchar(50), productPrice varchar(50),productAmount int, productDescription varchar(50),productStatus varchar(50))
begin 
insert into Products(`productCode`,`productName`,`productPrice`,`productAmount`,`productDescription`,`productStatus`) values (productCode,productName,productPrice,productAmount,productDescription,productStatus);
end //
delimiter ;
call add_new('12nghh1','haihiij',16,12,'hhgghhhgh','available');
select *from Products;

delimiter //
create procedure fix_inf( idIN int ,  productNameNew varchar(50))
begin
update Products set productName = `productNameNew` where id = idIN;
end //
delimiter ; 
call fix_inf(3, 'ngânnnn');

delimiter //
create procedure delete_id(idDelete int)
begin
delete from Products where Products.id = idDelete;
end //
delimiter ;
call delete_id(2);
select * from Products;

