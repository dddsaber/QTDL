package model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity	
public class PhongHoc {
	@Id
	private String MaPhong; 
	private int SoPhong;
	private int SoChoToiDa;
	
	public PhongHoc() {
	}

	public PhongHoc(String maPhong, int soPhong, int soChoToiDa) {
		MaPhong = maPhong;
		SoPhong = soPhong;
		SoChoToiDa = soChoToiDa;
	}

	public String getMaPhong() {
		return MaPhong;
	}

	public void setMaPhong(String maPhong) {
		MaPhong = maPhong;
	}

	public int getSoPhong() {
		return SoPhong;
	}

	public void setSoPhong(int soPhong) {
		SoPhong = soPhong;
	}

	public int getSoChoToiDa() {
		return SoChoToiDa;
	}

	public void setSoChoToiDa(int soChoToiDa) {
		SoChoToiDa = soChoToiDa;
	}

	@Override
	public String toString() {
		return "PhongHoc [MaPhong=" + MaPhong + ", SoPhong=" + SoPhong + ", SoChoToiDa=" + SoChoToiDa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(MaPhong, SoChoToiDa, SoPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		return Objects.equals(MaPhong, other.MaPhong) && SoChoToiDa == other.SoChoToiDa && SoPhong == other.SoPhong;
	}
	
	
	
	
}