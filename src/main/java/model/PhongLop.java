package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class PhongLop implements Serializable{
	@Id
	private String MaPhong;
	@Id
	private String MaLop;
	private String HocKyNamHoc;
	
	public PhongLop(String maPhong, String maLop, String hocKyNamHoc) {
		MaPhong = maPhong;
		MaLop = maLop;
		HocKyNamHoc = hocKyNamHoc;
	}

	public PhongLop() {
	}
	public String getMaPhong() {
		return MaPhong;
	}

	public void setMaPhong(String maPhong) {
		MaPhong = maPhong;
	}

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getHocKyNamHoc() {
		return HocKyNamHoc;
	}

	public void setHocKyNamHoc(String hocKyNamHoc) {
		HocKyNamHoc = hocKyNamHoc;
	}


	@Override
	public String toString() {
		return "PhongLop [MaPhong=" + MaPhong + ", MaLop=" + MaLop + ", HocKyNamHoc=" + HocKyNamHoc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(HocKyNamHoc, MaLop, MaPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongLop other = (PhongLop) obj;
		return Objects.equals(HocKyNamHoc, other.HocKyNamHoc) && Objects.equals(MaLop, other.MaLop)
				&& Objects.equals(MaPhong, other.MaPhong);
	}

	
	
}
	