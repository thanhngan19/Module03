create database CaseStudy;
create table if not exists vi_tri(
ma_vi_tri int auto_increment primary key not null,
ten_vi_tri varchar(50) not null unique
);

create table if not exists trinh_do(
ma_trinh_do int auto_increment primary key not null,
ten_trinh_do varchar(45) not null unique 
);

create table if not exists bo_phan(
ma_bo_phan int auto_increment primary key not null,
ten_bo_phan varchar(45) not null unique
);

create table if not exists nhan_vien(
ma_nhan_vien int auto_increment primary key not null,
ho_ten varchar(45) not null,
ngay_sinh date not null,
so_cmnd varchar(45) not null unique,
luong double not null,
so_dien_thoai varchar(45) not null unique,
email varchar(45) unique,
dia_chi varchar(45),
ma_vi_tri int not null,
ma_trinh_do int not null,
ma_bo_phan int not null,
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan)
);

create table if not exists loai_khach(
ma_loai_khach int auto_increment primary key not null,
ten_loai_khach varchar(45) not null
);

create table if not exists khach_hang(
ma_khach_hang int auto_increment primary key not null,
ma_loai_khach int not null,
ho_ten varchar(45) not null,
ngay_sinh date not null,
gioi_tinh bit not null,
so_cmnd varchar(45) not null unique,
so_dien_thoai varchar(45) not null unique,
email varchar(45) unique,
dia_chi varchar(45),
foreign key(ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table if not exists kieu_thue(
ma_kieu_thue int primary key auto_increment not null,
ten_kieu_thue varchar(45) not null unique
);

create table if not exists loai_dich_vu(
ma_loai_dich_vu int primary key auto_increment not null,
ten_loai_dich_vu varchar(45) not null unique
);
select dv.ma_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,dv.so_nguoi_toi_da,kt.ten_kieu_thue,
ldv.ten_loai_dich_vu,dv.tieu_chuan_phong,dv.mo_ta_tien_nghi_khac,dv.dien_tich_ho_boi,dv.so_tang
from dich_vu dv
join kieu_thue kt
on dv.ma_kieu_thue= kt.ma_kieu_thue
join loai_dich_vu ldv
on dv.ma_loai_dich_vu= ldv.ma_loai_dich_vu;
select tkt.ma_kieu_thue   from kieu_thue tkt where tkt.ten_kieu_thue like ?;
select ldv.ma_loai_dich_vu from loai_dich_vu ldv where ldv.ten_loai_dich_vu like "Villa";
insert into ma_dich_vu  (ma_dich_vu,ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,ma_kieu_thue,
tieu_chuan_thue,mo_ta_tien_ich_khac,dien_tich_ho_boi,so_tang) values(?,?
select * from dich_vu;

create table if not exists dich_vu(
ma_dich_vu int primary key auto_increment not null,
ten_dich_vu varchar(45) not null,
dien_tich varchar(45) not null,
chi_phi_thue double not null,
so_nguoi_toi_da int not null,
ma_kieu_thue int not null,
ma_loai_dich_vu int not null,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi varchar(45),
so_tang int,
foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);
select 


create table if not exists hop_dong(
ma_hop_dong int primary key auto_increment not null,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc datetime not null,
tien_dat_coc double not null,
ma_nhan_vien int not null,
ma_khach_hang int not null,
ma_dich_vu int not null,
foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key(ma_dich_vu) references dich_vu(ma_dich_vu)
);

create table if not exists dich_vu_di_kem(
ma_dich_vu_di_kem int auto_increment primary key not null,
ten_dich_vu_di_kem varchar(45) not null unique,
gia double not null,
don_vi varchar(45) not null,
trang_thai varchar(45) not null
);

create table if not exists hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int primary key auto_increment not null,
so_luong int not null,
ma_hop_dong int not null,
ma_dich_vu_di_kem int not null,
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_dich_kem)
);

INSERT INTO vi_tri (ten_vi_tri)
VALUE('Quản Lý'),
	 ('Nhân Viên');
     
INSERT INTO trinh_do (ten_trinh_do)
VALUE('Trung Cấp'),
     ('Cao Đẳng'),
     ('Đại Học'),
     ('Sau Đại Học');
     
INSERT INTO bo_phan (ten_bo_phan)
VALUE('Sale-Marketing'),
	 ('Hành chính'),
     ('Phục vụ'),
     ('Quản lý');

INSERT INTO nhan_vien(ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
VALUE('Nguyễn Văn An', '1970-11-07',	'456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng',	1, 3, 1),
     ('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
     ('Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
     ('Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
     ('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
     ('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
     ('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
     ('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
     ('Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
     ('Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
 
INSERT INTO loai_khach (ten_loai_khach)
VALUE('Diamond'),
     ('Platinium'),
     ('Gold'),
     ('Silver'),
     ('Member');
     
INSERT INTO khach_hang
VALUE(1, 5, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng'),
     (2, 3, 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
     (3, 1, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh'),
     (4, 1, 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng'),
     (5, 4, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai'),
     (6, 4, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng'),
     (7, 1, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh'),
     (8, 3, 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum'),
     (9, 1, 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi'),
     (10, 2, 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng');
     
INSERT INTO kieu_thue (ten_kieu_thue)
VALUE('year'),
     ('month'),
     ('day'),
     ('hour');
     
INSERT INTO loai_dich_vu (ma_loai_dich_vu, ten_loai_dich_vu)
VALUE(1, 'Villa'),
     (2, 'House'),
     (3, 'Room');
    
INSERT INTO dich_vu
VALUE(1, 'Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'Có hồ bơi', 500, 4),
     (2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'Có thêm bếp nướng', null, 3),
     (3, 'Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'Có tivi', null, null),
     (4, 'Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'Có hồ bơi', 300, 3),
     (5, 'House Princess 02', 10000, 4000000, 5, 3, 2, 'normal', 'Có thêm bếp nướng', null, 2),
     (6, 'Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'Có tivi', null, null);

INSERT INTO dich_vu_di_kem
VALUE(1, 'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
     (2, 'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
     (3, 'Thuê xe đạp', 20000, 'chiếc', 'tốt'),
     (4, 'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
     (5, 'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
     (6, 'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
     
INSERT INTO hop_dong
VALUE(1, '2020-12-08', '2020-12-08', 0, 3, 1, 3),
     (2, '2020-07-14', '2020-07-21', 200000, 7, 3, 1),
     (3, '2021-03-15', '2021-03-17', 50000, 3, 4, 2),
     (4, '2021-01-14', '2021-01-18', 100000, 7, 5, 5),
     (5, '2021-07-14', '2021-07-15', 0, 7, 2, 6),
     (6, '2021-06-01', '2021-06-03', 0, 7, 7, 6),
     (7, '2021-09-02', '2021-09-05', 100000, 7, 4, 4),
     (8, '2021-06-17', '2021-06-18', 150000, 3, 4, 1),
     (9, '2020-11-19', '2020-11-19', 0, 3, 4, 3),
     (10, '2021-04-12', '2021-04-14', 0, 10, 3, 5),
     (11, '2021-04-25', '2021-04-25', 0, 2, 2, 1),
     (12, '2021-05-25', '2021-05-27', 0, 7, 10, 1);
     
INSERT INTO hop_dong_chi_tiet
VALUE(1,  2, 4, 5),
     (2, 2, 5, 8),
     (3, 2, 6, 15),
     (4, 3, 1, 1),
     (5, 3, 2, 11),
     (6, 1, 3, 1),
     (7, 1, 2, 2),
     (8, 12, 2, 2);
     select * from nhan_vien;
     select* from vi_tri;
     select nv.ma_nhan_vien,nv.ho_ten,nv.ngay_sinh,nv.so_cmnd,nv.luong,nv.so_dien_thoai,nv.email,nv.dia_chi,vt.ten_vi_tri,td.ten_trinh_do,bp.ten_bo_phan
     from nhan_vien nv 
     join vi_tri vt
     on nv.ma_vi_tri=vt.ma_vi_tri
     join trinh_do td
     on nv.ma_trinh_do= td.ma_trinh_do
     join bo_phan bp
     on nv.ma_bo_phan= bp.ma_bo_phan; 
     select * from vi_tri;
     insert into nhan_vien set ma_nhan_vien=100,ho_ten="Thanh Ngân",ngay_sinh="2003-08-19",so_cmnd="1234567666",luong=20000000,so_dien_thoai="937364587",email="thanhgan198@gmail.com",dia_chi="22 Yên Bái, Đà Nẵng",ten_vi_tri;
  select vi_tri.ma_vi_tri from vi_tri where vi_tri.ten_vi_tri="Nhân Viên";
  select trinh_do.ma_trinh_do from trinh_do where trinh_do.ma_trinh_do=;
  select * from class;
  select * from khach_hang;
  select* from nhan_vien;
  select kh.ma_khach_hang, lk.ten_loai_khach,kh.ho_ten,kh.ngay_sinh,kh.gioi_tinh,kh.so_cmnd,kh.so_dien_thoai,kh.email,kh.dia_chi
  from khach_hang kh
  join loai_khach lk
  on kh.ma_loai_khach= lk.ma_loai_khach;
  select* from hop_dong;
  delete from  khach_hang where khach_hang.ma_khach_hang=2;
  
ALTER USER 'root'@'localhost' IDENTIFIED BY '12345678';
select * from dich_vu;