package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Diem implements Serializable {
	private String MaHS;
	private String MaMonHoc;
	private Float DiemMieng;
	private Float Diem15Phut;
	private Float Diem1Tiet;
	private Float DiemHocKy;

	public Diem() {
	}

	public Diem(String maHS, String maMonHoc, Float diemMieng, Float diem15Phut, Float diem1Tiet, Float diemHocKy) {
		MaHS = maHS;
		MaMonHoc = maMonHoc;
		DiemMieng = diemMieng;
		Diem15Phut = diem15Phut;
		Diem1Tiet = diem1Tiet;
		DiemHocKy = diemHocKy;
	}

	@Id
	public String getMaHS() {
		return MaHS;
	}

	public void setMaHS(String maHS) {
		MaHS = maHS;
	}

	@Id
	public String getMaMonHoc() {
		return MaMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		MaMonHoc = maMonHoc;
	}

	public Float getDiemMieng() {
		return DiemMieng;
	}

	public void setDiemMieng(Float diemMieng) {
		DiemMieng = diemMieng;
	}

	public Float getDiem15Phut() {
		return Diem15Phut;
	}

	public void setDiem15Phut(Float diem15Phut) {
		Diem15Phut = diem15Phut;
	}

	public Float getDiem1Tiet() {
		return Diem1Tiet;
	}

	public void setDiem1Tiet(Float diem1Tiet) {
		Diem1Tiet = diem1Tiet;
	}

	public Float getDiemHocKy() {
		return DiemHocKy;
	}

	public void setDiemHocKy(Float diemHocKy) {
		DiemHocKy = diemHocKy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Diem15Phut, Diem1Tiet, DiemHocKy, DiemMieng, MaHS, MaMonHoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diem other = (Diem) obj;
		return Objects.equals(Diem15Phut, other.Diem15Phut) && Objects.equals(Diem1Tiet, other.Diem1Tiet)
				&& Objects.equals(DiemHocKy, other.DiemHocKy) && Objects.equals(DiemMieng, other.DiemMieng)
				&& Objects.equals(MaHS, other.MaHS) && Objects.equals(MaMonHoc, other.MaMonHoc);
	}

	@Override
	public String toString() {
		return "Diem [MaHS=" + MaHS + ", MaMonHoc=" + MaMonHoc + ", DiemMieng=" + DiemMieng + ", Diem15Phut="
				+ Diem15Phut + ", Diem1Tiet=" + Diem1Tiet + ", DiemHocKy=" + DiemHocKy + "]";
	}

}
