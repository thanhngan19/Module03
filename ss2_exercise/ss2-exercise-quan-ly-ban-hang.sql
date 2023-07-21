create table customer(
cID int primary key auto_increment,
Name varchar(50),
Age int 
);
create table dat_hang(
oID int primary key auto_increment,
cID int,
oDAte date,
oTotalPrice double,
foreign key (cID) references customer(cID)
);
create table dat_hang_detail(
oID int,
pID int,
odQTY int check(odQTY>0),
primary key(oID,pID),
foreign key (oID) references dat_hang(oID),
foreign key (pID) references Product(pID)
);
create table  Product(
pID int primary key auto_increment,
pName varchar(50),
pPrice double
);
