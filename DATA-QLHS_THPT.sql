create database dataset_qtdl;
use dataset_qtdl;

drop table if exists chunhiem;
drop table if exists diem;
drop table if exists giaovien;
drop table if exists hocsinh;
drop table if exists monhoc;
drop table if exists phonghoc;
drop table if exists taikhoan;
drop table if exists thongkehs;

CREATE TABLE TaiKhoan (
TenTK VARCHAR(50) PRIMARY KEY,
MatKhauTK VARCHAR(50)
);

CREATE TABLE Lop (
MaLop VARCHAR(8) PRIMARY KEY,
TenLop VARCHAR(50),
NienKhoa VARCHAR(12)
);

CREATE TABLE GiaoVien (
MaGV VARCHAR(8) PRIMARY KEY,
HoTenGV VARCHAR(50),
NgaySinhGV DATE,
DiaChiGV VARCHAR(200),
SoDienThoaiGV VARCHAR(15)
);

CREATE TABLE HocSinh (
MaHS VARCHAR(8) PRIMARY KEY,
HoTenHS VARCHAR(50),
NgaySinhHS DATE,
DiaChiHS VARCHAR(200),
SDTPhuHuynhHS VARCHAR(15),
MaLop VARCHAR(8),
FOREIGN KEY (MaLop) REFERENCES Lop(MaLop)
);

CREATE TABLE ChuNhiem (
MaGV VARCHAR(8),
MaLop VARCHAR(8),
NamHoc VARCHAR(12),
PRIMARY KEY (MaGV, MaLop),
FOREIGN KEY (MaGV) REFERENCES GiaoVien(MaGV),
FOREIGN KEY (MaLop) REFERENCES Lop(MaLop)
);

CREATE TABLE PhongHoc (
MaPhong VARCHAR(8) PRIMARY KEY,
SoPhong INT,
SoChoToiDa INT
);

CREATE TABLE PhongLop (
MaPhong VARCHAR(8),
MaLop VARCHAR(8),
HocKyNamHoc VARCHAR(20),
PRIMARY KEY (MaPhong, MaLop),
FOREIGN KEY (MaPhong) REFERENCES PhongHoc(MaPhong),
FOREIGN KEY (MaLop) REFERENCES Lop(MaLop)
);

CREATE TABLE MonHoc (
MaMonHoc VARCHAR(8) PRIMARY KEY,
TenMonHoc VARCHAR(50),
Khoi INT
);

CREATE TABLE Diem (
MaHS VARCHAR(8),
MaMonHoc VARCHAR(8),
DiemMieng FLOAT,
Diem15Phut FLOAT,
Diem1Tiet FLOAT,
DiemHocKy FLOAT,
PRIMARY KEY (MaHS, MaMonHoc),
FOREIGN KEY (MaHS) REFERENCES HocSinh(MaHS),
FOREIGN KEY (MaMonHoc) REFERENCES MonHoc(MaMonHoc)
);

INSERT INTO Lop (MaLop, TenLop, NienKhoa) VALUES
('A001', 'Lớp A001', '2022-2023'),
('A002', 'Lớp A002', '2022-2023'),
('A003', 'Lớp A003', '2022-2023'),
('A004', 'Lớp A004', '2021-2022'),
('A005', 'Lớp A005', '2022-2023'),
('B001', 'Lớp B001', '2022-2023'),
('B002', 'Lớp B002', '2021-2022'),
('B003', 'Lớp B003', '2020-2021'),
('C003', 'Lớp C003', '2023-2024'),
('C001', 'Lớp C001', '2022-2023'),
('C002', 'Lớp C002', '2022-2023');

-- Thêm 10 thể hiện cho bảng GiaoVien
INSERT INTO GiaoVien (MaGV, HoTenGV, NgaySinhGV, DiaChiGV, SoDienThoaiGV) VALUES
('GV001', 'Nguyễn Anh Tuân', '1980-05-20', 'Hà Nội', '0987654321'),
('GV002', 'Trần Thị Mỹ Duyên', '1975-03-15', 'Thành Phố Hồ Chí Minh', '0901234567'),
('GV003', 'Lê Văn Có', '1982-08-10', 'Đà Nẵng', '0912345678'),
('GV004', 'Phạm Thị Dung', '1978-12-25', 'Huế', '0976543210'),
('GV005', 'Hoàng Thái Tuấn', '1985-02-28', 'Cần Thơ', '0954321098'),
('GV006', 'Nguyễn Thị Ngọc Châu', '1984-07-19', 'Cần Thơ', '0923456789'),
('GV007', 'Nguyễn Thanh Tùng', '1981-11-30', 'Lâm Đồng', '0943210987'),
('GV008', 'Nguyễn Việt Hoàng', '1979-06-17', 'Khánh Hòa', '0965432109'),
('GV009', 'Pham Văn Kiên', '1983-09-05', 'Hà Nội', '0932109876'),
('GV010', 'Mai Thị Kim Ngân', '1980-04-12', 'Thành Phố Hồ Chí Minh', '0998765432');

-- Thêm 10 thể hiện cho bảng HocSinh
INSERT INTO HocSinh (MaHS, HoTenHS, NgaySinhHS, DiaChiHS, SDTPhuHuynhHS, MaLop) VALUES
('HS001', 'Nguyễn Văn An', '2005-01-10', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0987123456', 'A001'),
('HS002', 'Trần Thị Huyền Trân', '2006-02-15', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0909876543', 'A002'),
('HS003', 'Lê Tuấn Khải', '2005-03-20', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0971234567', 'A001'),
('HS004', 'Phạm Minh Hường', '2007-04-25', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0912345678', 'A002'),
('HS005', 'Hoàng Nam', '2006-05-30', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0987654321', 'A002'),
('HS006', 'Nguyễn Thu Cúc', '2007-06-10', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0904321098', 'B001'),
('HS007', 'Ngô Ngọc Ánh', '2005-07-15', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0976543210', 'B001'),
('HS008', 'Lê Thủy Tiên', '2006-08-20', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0912345678', 'B002'),
('HS009', 'Phạm Kim Khánh', '2007-09-25', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0987654321', 'A001'),
('HS010', 'Võ Văn Thưởng', '2006-10-30', 'Đường 3/2, Ninh Kiều, Cần Thơ', '0903210987', 'A001');

-- Thêm 1 thể hiện cho bảng ChuNhiem
INSERT INTO ChuNhiem (MaGV, MaLop, NamHoc) VALUES
('GV001', 'A001', '2022-2023'),
('GV002', 'A001', '2021-2022'),
('GV003', 'A002', '2020-2021'),
('GV004', 'B001', '2023-2024'),
('GV005', 'A001', '2022-2023'),
('GV006', 'B002', '2021-2022'),
('GV007', 'B001', '2020-2021'),
('GV008', 'A001', '2023-2024'),
('GV009', 'B001', '2022-2023'),
('GV010', 'A002', '2021-2022');


-- Thêm 10 thể hiện cho bảng PhongHoc
INSERT INTO PhongHoc (MaPhong, SoPhong, SoChoToiDa) VALUES
('P101', 101, 50),
('P102', 102, 50),
('P103', 103, 50),
('P104', 104, 50),
('P105', 105, 50),
('P106', 106, 50),
('P107', 107, 50),
('P108', 108, 70),
('P109', 109, 70),
('P110', 110, 70);

-- Thêm 10 thể hiện cho bảng PhongLop
INSERT INTO PhongLop (MaPhong, MaLop, HocKyNamHoc) VALUES
('P101', 'A001', 'HK1-2022-2023'),
('P102', 'A001', 'HK2-2021-2022'),
('P103', 'A002', 'HK1-2020-2021'),
('P104', 'A003', 'HK2-2023-2024'),
('P105', 'A002', 'HK1-2022-2023'),
('P106', 'B001', 'HK2-2021-2022'),
('P107', 'A001', 'HK1-2020-2021'),
('P108', 'B001', 'HK1-2023-2024'),
('P109', 'B001', 'HK1-2022-2023'),
('P110', 'B002', 'HK2-2021-2022');

-- Thêm 10 thể hiện cho bảng MonHoc
INSERT INTO MonHoc (MaMonHoc, TenMonHoc, Khoi) VALUES
('TOAN10', 'Toán 10', '10'),
('VAN10', 'Ngữ Văn 10', '10'),
('AV10', 'Ngoại Ngữ 10', '10'),
('TOAN11', 'Toán 11', '11'),
('AV11', 'Ngoại Ngữ 11', '11'),
('VAN11', 'Ngữ Văn 11', '11'),
('TOAN12', 'Toán 12', '12'),
('VAN12', 'Ngữ Văn 12', '12'),
('AV12', 'Ngoại Ngữ 12', '12');

-- Thêm 10 thể hiện cho bảng Diemtaikhoan
INSERT INTO Diem (MaHS, MaMonHoc, DiemMieng, Diem15Phut, Diem1Tiet, DiemHocKy) VALUES
('HS001', 'TOAN10', 8.5, 7.0, 9.0, 8.0),
('HS002', 'TOAN11', 7.0, 6.5, 8.5, 7.5),
('HS003', 'TOAN12', 9.0, 8.0, 9.5, 8.5),
('HS004', 'TOAN10', 6.5, 7.0, 7.5, 7.0),
('HS001', 'VAN10', 8.0, 8.5, 9.0, 8.5),
('HS002', 'VAN11', 7.5, 7.0, 8.0, 7.5),
('HS007', 'VAN12', 9.0, 8.5, 9.5, 8.5),
('HS002', 'AV11', 6.0, 6.5, 7.0, 6.5),
('HS001', 'AV10', 8.5, 8.0, 9.0, 8.0),
('HS010', 'TOAN11', 7.0, 7.5, 8.0, 7.5);


