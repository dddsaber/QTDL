package model;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lop {
	@Id
	private String MaLop;
	private String TenLop;
	private String NienKhoa;
	public Lop() {
	}
	public Lop(String maLop, String tenLop, String nienKhoa) {
		MaLop = maLop;
		TenLop = tenLop;
		NienKhoa = nienKhoa;
	}
	public String getMaLop() {
		return MaLop;
	}
	public void setMaLop(String maLop) {
		MaLop = maLop;
	}
	public String getTenLop() {
		return TenLop;
	}
	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}
	public String getNienKhoa() {
		return NienKhoa;
	}
	public void setNienKhoa(String nienKhoa) {
		NienKhoa = nienKhoa;
	}
	
	@Override
	public String toString() {
		return "Lop [MaLop=" + MaLop + ", TenLop=" + TenLop + ", NienKhoa=" + NienKhoa + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaLop, NienKhoa, TenLop);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lop other = (Lop) obj;
		return Objects.equals(MaLop, other.MaLop) && Objects.equals(NienKhoa, other.NienKhoa)
				&& Objects.equals(TenLop, other.TenLop);
	}
	
	
}