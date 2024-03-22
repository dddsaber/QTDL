package model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MonHoc {
	@Id
	private String MaMonHoc;
	private String TenMonHoc;
	private int Khoi;
	
	public MonHoc() {
	}

	public MonHoc(String maMonHoc, String tenMonHoc, int khoi) {
		MaMonHoc = maMonHoc;
		TenMonHoc = tenMonHoc;
		Khoi = khoi;
	}

	public String getMaMonHoc() {
		return MaMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		MaMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return TenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		TenMonHoc = tenMonHoc;
	}

	public int getKhoi() {
		return Khoi;
	}

	public void setKhoi(int khoi) {
		Khoi = khoi;
	}

	@Override
	public String toString() {
		return "MonHoc [MaMonHoc=" + MaMonHoc + ", TenMonHoc=" + TenMonHoc + ", Khoi=" + Khoi + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Khoi, MaMonHoc, TenMonHoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonHoc other = (MonHoc) obj;
		return Khoi == other.Khoi && Objects.equals(MaMonHoc, other.MaMonHoc)
				&& Objects.equals(TenMonHoc, other.TenMonHoc);
	}
	
	
}