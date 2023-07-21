use ss2_exercise;
create table PHIEUXUAT(
SoPX int primary key auto_increment,
NgayXuat date
);
create table VATTU(
MaVTU int primary key auto_increment,
TenVTU varchar(50)
);
create table PHIEUNHAP(
SoPN int primary key auto_increment,
NgayNhap date
);
create table DONDH(
SoDH int primary key auto_increment,
NgayDH date,
MaNCC_NHACC int,
foreign key (MaNCC_NHACC) references NHACC(MaNCC)
);
create table NHACC(
MaNCC int primary key auto_increment,
TenNCC varchar(50),
DiaChi varchar(50),
SDT varchar(50) unique
);
create table DONDH_VATTU(
SoDH_DonDH int,
MaVTU_VATTU int,
primary key(SoDH_DonDH,MaVTU_VATTU),
foreign key(SoDH_DonDH) references DONDH(SoDH),
foreign key(MaVTU_VATTU) references VATTU(MaVTU)
);
create table VATTU_PHIEUNHAP(
MaVTU_VATTU int ,
SoPN_PHIEUNHAP int,
DGNhap double(10,2),
SLNhap int,
primary key(MaVTU_VATTU,SoPN_PHIEUNHAP),
foreign key (MaVTU_VATTU) references VATTTU(MaVTU),
foreign key(SoPN_PHIEUNHAP) references PHIEUNHAP(SoPN)
);
create table VATTU_PHIEUXUAT(
SoPX_PHIEUXUAT int,
MaVTU_VATTU int,
primary key (SoPX_PHIEUXUAT,MaVTU_VATTU),
foreign key (SoPX_PHIEUXUAT) references PHIEUXUAT(SoPX),
foreign key(MaVTU_VATTU) references VATTU(MaVTU)
);