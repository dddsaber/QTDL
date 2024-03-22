package model;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChuNhiem implements Serializable{
  
	private String MaGV;
    private String MaLop;
    private String NamHoc;
    
	public ChuNhiem() {
	}

	public ChuNhiem(String maGV, String maLop, String namHoc) {
		MaGV = maGV;
		MaLop = maLop;
		NamHoc = namHoc;
	}
	@Id
	public String getMaGV() {
		return MaGV;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	@Id
	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getNamHoc() {
		return NamHoc;
	}

	public void setNamHoc(String namHoc) {
		NamHoc = namHoc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(MaGV, MaLop, NamHoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuNhiem other = (ChuNhiem) obj;
		return Objects.equals(MaGV, other.MaGV) && Objects.equals(MaLop, other.MaLop)
				&& Objects.equals(NamHoc, other.NamHoc);
	}

	@Override
	public String toString() {
		return "ChuNhiem [MaGV=" + MaGV + ", MaLop=" + MaLop + ", NamHoc=" + NamHoc + "]";
	}
	

    
    
}