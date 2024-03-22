package model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HocSinh {
	@Id
	private String MaHS;
	private String HoTenHS;
	private Date NgaySinhHS;
	private String DiaChiHS;
	private String SDTPhuHuynhHS;
	private String MaLop;
	public HocSinh() {
	}
	public HocSinh(String maHS, String hoTenHS, Date ngaySinhHS, String diaChiHS, String sDTPhuHuynhHS, String maLop) {
		MaHS = maHS;
		HoTenHS = hoTenHS;
		NgaySinhHS = ngaySinhHS;
		DiaChiHS = diaChiHS;
		SDTPhuHuynhHS = sDTPhuHuynhHS;
		MaLop = maLop;
	}
	public String getMaHS() {
		return MaHS;
	}
	public void setMaHS(String maHS) {
		MaHS = maHS;
	}
	public String getHoTenHS() {
		return HoTenHS;
	}
	public void setHoTenHS(String hoTenHS) {
		HoTenHS = hoTenHS;
	}
	public Date getNgaySinhHS() {
		return NgaySinhHS;
	}
	public void setNgaySinhHS(Date ngaySinhHS) {
		NgaySinhHS = ngaySinhHS;
	}
	public String getDiaChiHS() {
		return DiaChiHS;
	}
	public void setDiaChiHS(String diaChiHS) {
		DiaChiHS = diaChiHS;
	}
	public String getSDTPhuHuynhHS() {
		return SDTPhuHuynhHS;
	}
	public void setSDTPhuHuynhHS(String sDTPhuHuynhHS) {
		SDTPhuHuynhHS = sDTPhuHuynhHS;
	}
	public String getMaLop() {
		return MaLop;
	}
	public void setMaLop(String maLop) {
		MaLop = maLop;
	}
	@Override
	public int hashCode() {
		return Objects.hash(DiaChiHS, HoTenHS, MaHS, MaLop, NgaySinhHS, SDTPhuHuynhHS);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HocSinh other = (HocSinh) obj;
		return Objects.equals(DiaChiHS, other.DiaChiHS) && Objects.equals(HoTenHS, other.HoTenHS)
				&& Objects.equals(MaHS, other.MaHS) && Objects.equals(MaLop, other.MaLop)
				&& Objects.equals(NgaySinhHS, other.NgaySinhHS) && Objects.equals(SDTPhuHuynhHS, other.SDTPhuHuynhHS);
	}
	@Override
	public String toString() {
		return "HocSinh [MaHS=" + MaHS + ", HoTenHS=" + HoTenHS + ", NgaySinhHS=" + NgaySinhHS + ", DiaChiHS="
				+ DiaChiHS + ", SDTPhuHuynhHS=" + SDTPhuHuynhHS + ", MaLop=" + MaLop + "]";
	}
	
	
}