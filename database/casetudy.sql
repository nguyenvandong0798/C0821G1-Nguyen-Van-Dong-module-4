drop database if exists casetudy;
create database casetudy;
use casetudy;


create table vi_tri(
ma_vi_tri int primary key ,
ten_vi_tri varchar(45)
);


create table trinh_do(
ma_trinh_do int primary key,
ten_trinh_do varchar(45)
);

create table loai_khach(
ma_loai_khach int primary key,
ten_loai_khach varchar(45)
);


create table bo_phan (
ma_bo_phan int primary key,
ten_bo_phan varchar(45)
);

create table kieu_thue(
ma_kieu_thue int primary key,
ten_kieu_thue varchar(45),
gia_thue double
);

create table dich_vu_di_kem (
ma_dich_vu_di_kem int primary key,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi int,
trang_thai varchar(45)
);

create table loai_dich_vu(
ma_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(45)
);

create table nhan_vien(
ma_nhan_vien int primary key,
ho_va_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
luong varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);

create table khach_hang(
ma_khach_hang int primary key,
ma_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh int,
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table dich_vu (
ma_dich_vu int primary key,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

create table hop_dong(
ma_hop_dong int primary key,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
tong_tien double,
ma_nhan_vien int,
ma_dich_vu int,
ma_khach_hang int,
foreign key (ma_nhan_vien) references nhan_vien (ma_nhan_vien),
foreign key (ma_dich_vu) references dich_vu (ma_dich_vu),
foreign key (ma_khach_hang) references khach_hang (ma_khach_hang)
);

create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int primary key,
ma_hop_dong int,
ma_dich_vu_di_kem int,
so_luong int,
foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);

insert into vi_tri
values (1,"Lễ tân");
insert into vi_tri
values (2,"phục vụ");
insert into vi_tri
values (3,"chuyên viên");
insert into vi_tri
values (4,"giám sát");
insert into vi_tri
values (5,"quản lý");
insert into vi_tri
values (6,"giám đốc");

insert into trinh_do
values (1,"cao dang");
insert into trinh_do
values (2,"dai hoc");
insert into trinh_do
values (3,"cao dang");
insert into trinh_do
values (4,"cao dang");
insert into trinh_do
values (5,"dai hoc");
insert into trinh_do
values (6,"dai hoc");

insert into loai_khach
values (1,"Diamond");
insert into loai_khach
values (2,"Gold");
insert into loai_khach
values (3,"Diamond");
insert into loai_khach
values (4,"Silver");
insert into loai_khach
values (5,"Diamond");
insert into loai_khach
values (6,"Member");

insert into bo_phan
values (1,"Sale – Marketing");
insert into bo_phan
values (2,"Hành Chính");
insert into bo_phan
values (3,"Sale – Marketing");
insert into bo_phan
values (4,"Phục vụ");
insert into bo_phan
values (5,"Phục vụ");
insert into bo_phan
values (6,"Quản lý");

insert into kieu_thue
values (1,"năm", 1000);
insert into kieu_thue
values (2,"tháng",2000);
insert into kieu_thue
values (3,"ngày",1000);
insert into kieu_thue
values (4,"năm",3000);
insert into kieu_thue
values (5,"ngay",1000);
insert into kieu_thue
values (6,"giờ",1000);


insert into dich_vu_di_kem
values(1, "massage",1000, 11, "dich vụ đi kèm" );
insert into dich_vu_di_kem
values(2, "karaoke",1000, 22, "dich vụ đi kèm" );
insert into dich_vu_di_kem
values(3, "thức ăn",1000, 33, "dich vụ đi kèm" );
insert into dich_vu_di_kem
values(4, "nước uống",1000, 44, "dich vụ đi kèm" );
insert into dich_vu_di_kem
values(5, "thuê xe ",1000, 55, "dich vụ đi kèm" );
insert into dich_vu_di_kem
values(6, "massage",1000, 66, "dich vụ đi kèm" );

insert into loai_dich_vu
values (1,"Villa");
insert into loai_dich_vu
values (2,"Room");
insert into loai_dich_vu
values (3,"House");
insert into loai_dich_vu
values (4,"Villa");
insert into loai_dich_vu
values (5,"Room");
insert into loai_dich_vu
values (6,"House");


insert into nhan_vien
values (1,"nguyen anh du","1990-12-12", "206123123",1234568, "098654321", "nguyenanhdu@gmail.com", "quảng nam", 1, 1, 1);
insert into nhan_vien
values (2,"nguyen anh tam","1991-11-03", "206123456",1234568, "098654246", "nanhtam@gmail.com", "đà nẳng", 2, 2, 2);
insert into nhan_vien
values (3,"nguyen van lanh","1996-10-08", "206123134",1234568, "098654123", "vanlanh@gmail.com", "quang trị", 3, 3, 3);
insert into nhan_vien
values (4,"nguyen thi thao","1998-09-09", "20612389",1234568, "098654322", "thithao@gmail.com", "quảng nam", 4, 4, 4);
insert into nhan_vien
values (5,"tran cong hau","1993-08-21", "206123234",1234568, "098654311", "conghau@gmail.com", "đà nẵng", 5, 5, 5);
insert into nhan_vien
values (6,"le van doan","1994-06-02", "20612380",1234568, "098654321", "vandoan@gmail.com", "vinh", 6, 6, 6);

insert into khach_hang
values (1, 1, "nguyen van doan","1990-12-12", 1,  "206123456", "098654321", "vandoan@gmail.com", "quảng nam");
insert into khach_hang
values (2, 4, "le van nhu","1990-02-11", 1,  "206123456", "098654321", "vannhu@gmail.com", "đà nẵng");
insert into khach_hang
values (3, 2, "nguyen anh tam","1990-02-12", 1,  "206123456", "098654321", "anhtam@gmail.com", "quảng trị");
insert into khach_hang
values (8, 3, "nguyen van phuong","1990-10-10", 1,  "206123456", "098654321", "vanphuong@gmail.com", "quảng nam");
insert into khach_hang
values (5, 5, "tran thi ly","1990-09-12", 0,  "206123456", "098654321", "thily@gmail.com", "vinh");
insert into khach_hang
values (7, 6, "tran anh da","1990-10-12", 1,  "206123456", "098654321", "anhsu@gmail.com", "quảng nam");
select * from khach_hang;


insert into dich_vu
values (1,"Villa",30, 1234568, 5, 1, 1, "3 star", "thoáng mát", 10, 1);
insert into dich_vu
values (2,"Villa",40, 1234568, 6, 2, 2, "4 star", "rộng rãi", 20, 2);
insert into dich_vu
values (3,"House",10, 1234568, 8, 3, 3, "3 star", "thoáng mát", null, 1);
insert into dich_vu
values (4,"House",40, 1234568, 6 ,4, 4, "4 star", "thoáng mát", null, 3);
insert into dich_vu
values (5,"Room",30, 1234568, 5, 5, null, null, null, null, null);
insert into dich_vu
values (6,"Room",20, 1234568, 4, 3, null, null, null, null, null);


insert into hop_dong
values (1, "2020-10-10", "2021-10-10", 10000000, 15000000,1,1,1);
insert into hop_dong
values (2, "2020-05-11", "2021-05-11", 20000000, 12000000,2,3,3);
insert into hop_dong
values (3, "2020-01-11", "2021-01-11", 20000000, 13000000,3,2,1);
insert into hop_dong
values (4, "2020-08-10", "2021-08-10", 30000000, 15000000,4,5,3);
insert into hop_dong
values (5, "2020-12-10", "2021-12-10", 40000000, 16000000,5,6,5);
insert into hop_dong
values (6, "2020-11-08", "2021-11-08", 20000000, 11000000,6,4,6);


insert into hop_dong_chi_tiet
values(1,1,1,3);
insert into hop_dong_chi_tiet
values(2,2,6,3);
insert into hop_dong_chi_tiet
values(3,4,4,2);
insert into hop_dong_chi_tiet
values(4,5,5,1);
insert into hop_dong_chi_tiet
values(5,3,2,5);
insert into hop_dong_chi_tiet
values(6,6,3,3);

SET FOREIGN_KEY_CHECKS=0;