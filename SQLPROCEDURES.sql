delimiter $$
drop procedure if exists Xoa_Giao_Vien $$
create procedure Xoa_Giao_Vien(
	in magv char(8))
begin 
	delete from chunhiem
    where chunhiem.MaGV =  magv;
    delete from giaovien
    where giaovien.MaGV = magv;
end; $$
delimiter ;

-- Tà đạo
#Xóa Học sinh
delimiter $$
drop procedure if exists Xoa_Hoc_Sinh $$
create procedure Xoa_Hoc_Sinh(
	in mahs char(8))
begin 
	delete from diem
    where diem.MaHS = mahs;
    delete from hocsinh
    where hocsinh.MaHS = mahs;
end; $$
delimiter ;


delimiter $$
drop procedure if exists LayDiemTheoMonLop $$
create procedure LayDiemTheoMonLop(
	in maMon varchar(8),
     in maLop varchar(8))
begin
	select d.MaHS, d.MaMonHoc, h.MaLop, d.DiemMieng, d.Diem15Phut, d.Diem1Tiet, d.DiemHocKy
    from diem d join hocsinh h on h.MaHS = D.MaHS
	where (d.MaMonHoc = maMon and h.MaLop = maLop) or
		(maMon = '' and h.MaLop = maLop) or
		(d.MaMonHoc = maMon and maLop = '') or
        (maMon = '' and maLop = '');
end; $$
delimiter ;

delimiter $$
drop procedure if exists Bang_Nhap_Diem $$
create procedure Bang_Nhap_Diem()
begin
	INSERT INTO Diem (mahs, mamonhoc)
	SELECT hs.mahs, mh.mamonhoc
	FROM HocSinh hs
	INNER JOIN MonHoc mh ON 1=1 where hs.mahs = mahs
	ON duplicate key update mahs = values(mahs);
    end $$
delimiter ;

-- Xoá học sinh => xoá điểm
delimiter $$
drop procedure if exists Xoa_Hoc_Sinh $$
create procedure Xoa_Hoc_Sinh(
	in mahs char(8))
begin 
	delete from diem
    where diem.MaHS = mahs;
    delete from hocsinh
    where hocsinh.MaHS = mahs;
end; $$
delimiter ;



-- Xoá phòng học => xoá phòng lớp
delimiter $$
drop procedure if exists Xoa_Phong_Hoc $$
create procedure Xoa_Phong_Hoc(
	IN maph varchar(8))
begin 
	delete from phonglop 
    where phonglop.MaPhong = maph;
	delete from phonghoc 
    where phonghoc.MaPhong = maph;
end $$
delimiter ;


-- Xoá lớp => xoá phòng lớp + hs nào có mã lớp là lớp bị xoá thì mã lớp = null
DELIMITER $$
DROP PROCEDURE IF EXISTS Xoa_Lop $$
CREATE PROCEDURE Xoa_Lop(
    IN malop VARCHAR(8)
)
BEGIN
    -- Xoá phòng lớp
    DELETE FROM phonglop WHERE phonglop.MaLop = malop;

	-- Xoá chủ nhiệm
    DELETE FROM chunhiem WHERE chunhiem.MaLop = malop;
    
    -- Cập nhật học sinh có mã lớp tương ứng thành NULL
    UPDATE hocsinh SET MaLop = NULL WHERE hocsinh.MaLop = malop;

    -- Xoá lớp
    DELETE FROM lop WHERE lop.MaLop = malop;
END $$
DELIMITER ;

-- Cách 2
-- DELIMITER $$
-- CREATE FUNCTION Xoa_Lop(
-- 	 malop VARCHAR(8))
-- RETURNS VARCHAR(255)
-- BEGIN
--     -- Xoá phòng lớp
--     DELETE FROM phonglop WHERE phonglop.MaLop = malop;

-- 	-- Xoá chủ nhiệm
--     DELETE FROM chunhiem WHERE chunhiem.MaLop = malop;
--     
--     -- Cập nhật học sinh có mã lớp tương ứng thành NULL
--     UPDATE hocsinh SET MaLop = NULL WHERE hocsinh.MaLop = malop;

--     -- Xoá lớp
--     DELETE FROM lop WHERE lop.MaLop = malop;

--     RETURN 'Xoá lớp và cập nhật học sinh thành công';
-- END$$
-- DELIMITER ;


DELIMITER $$
DROP FUNCTION IF EXISTS TinhDiemTB $$
CREATE FUNCTION TinhDiemTB (mahs CHAR(8), maMon CHAR(8))
RETURNS FLOAT
BEGIN
    DECLARE diemtb FLOAT;

    SELECT COALESCE((SUM(COALESCE(d.DiemMieng, 0)) + SUM(COALESCE(d.Diem15Phut, 0)) 
                            + SUM(COALESCE(d.Diem1Tiet, 0)) * 2 + SUM(COALESCE(d.DiemHocKy, 0)) * 3) / 7, 0)
    INTO diemtb
    FROM hocsinh h 
    LEFT JOIN diem d ON h.MaHS = d.MaHS
    WHERE h.MaHS LIKE CONCAT('%', mahs, '%') AND d.MaMonHoc LIKE CONCAT('%', maMon, '%');

    RETURN diemtb;
END$$
DELIMITER ;

USE dataset_qtdl;
DELIMITER $$

DROP PROCEDURE IF EXISTS LayDSThongKe $$
CREATE PROCEDURE LayDSThongKe (IN lop VARCHAR(8), nienkhoa VARCHAR(20))
BEGIN
    SELECT MaHS AS maHS, HoTenHS AS TenHS,
           ROUND((SELECT TinhDiemTB(MaHS, CONCAT('VAN', lop))), 2) AS tbVan,
           ROUND((SELECT TinhDiemTB(MaHS, CONCAT('TOAN', lop))), 2) AS tbToan,
           ROUND((SELECT TinhDiemTB(MaHS, CONCAT('AV', lop))), 2) AS tbNN,
           ROUND(((SELECT TinhDiemTB(MaHS, CONCAT('VAN', lop))) + (SELECT TinhDiemTB(MaHS, CONCAT('TOAN', lop))) + (SELECT TinhDiemTB(MaHS, CONCAT('AV', lop)))) / 3, 2) AS tbMon
    FROM hocsinh
    WHERE MaHS IN (SELECT hocsinh.MaHS
                    FROM hocsinh 
                    LEFT JOIN diem ON hocsinh.MaHS = diem.MaHS JOIN lop on hocsinh.malop = lop.malop
                    WHERE diem.mamonhoc like CONCAT('%', lop, '%') and lop.nienkhoa = nienkhoa
                    GROUP BY hocsinh.MaHS
                    HAVING COUNT(diem.MaMonHoc) >= 3)
	ORDER BY tbMon DESC;
END$$

DELIMITER ;

DELIMITER $$
DROP FUNCTION IF EXISTS TinhSoHS $$
CREATE FUNCTION TinhSoHS (malop CHAR(8))
RETURNS FLOAT
BEGIN
    DECLARE sohs int;

    SELECT COUNT( h.MaHS)
    INTO sohs
    FROM hocsinh h inner join lop l on h.MaLop = l.MaLop
    WHERE l.MaLop = malop
    GROUP BY malop;
    RETURN sohs;
END$$
DELIMITER ;

select tinhSoHS('A001');