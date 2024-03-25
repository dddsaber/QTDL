package model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class GiaoVien {
	//Giáo viên (Mã giáo viên, Họ tên, Ngày sinh, Địa chỉ, số điện thoại)
	private String maGV;
	private String hoTenGV;
	private Date ngaySinhGV;
	private String diaChiGV;
	private String soDienThoaiGV;
		
	public GiaoVien() {
	}
	
	public GiaoVien(String maGV, String hoTenGV, Date ngaySinhGV2, String diaChiGV, String soDienThoaiGV) {
		this.maGV = maGV;
		this.hoTenGV = hoTenGV;
		this.ngaySinhGV = ngaySinhGV2;
		this.diaChiGV = diaChiGV;
		this.soDienThoaiGV = soDienThoaiGV;
	}

	@Id
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	
	public String getHoTenGV() {
		return hoTenGV;
	}
	public void setHoTenGV(String hoTenGV) {
		this.hoTenGV = hoTenGV;
	}
	public Date getNgaySinhGV() {
		return ngaySinhGV;
	}
	public void setNgaySinhGV(Date ngaySinhGV) {
		this.ngaySinhGV = ngaySinhGV;
	}
	public String getDiaChiGV() {
		return diaChiGV;
	}
	public void setDiaChiGV(String diaChiGV) {
		this.diaChiGV = diaChiGV;
	}
	public String getSoDienThoaiGV() {
		return soDienThoaiGV;
	}
	public void setSoDienThoaiGV(String soDienThoaiGV) {
		this.soDienThoaiGV = soDienThoaiGV;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diaChiGV, hoTenGV, maGV, ngaySinhGV, soDienThoaiGV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoVien other = (GiaoVien) obj;
		return Objects.equals(diaChiGV, other.diaChiGV) && Objects.equals(hoTenGV, other.hoTenGV)
				&& Objects.equals(maGV, other.maGV) && Objects.equals(ngaySinhGV, other.ngaySinhGV)
				&& Objects.equals(soDienThoaiGV, other.soDienThoaiGV);
	}
	@Override
	public String toString() {
		return "GiaoVien [maGV=" + maGV + ", hoTenGV=" + hoTenGV + ", ngaySinhGV=" + ngaySinhGV + ", diaChiGV="
				+ diaChiGV + ", soDienThoaiGV=" + soDienThoaiGV + "]";
	}
	
	
	
	
}
