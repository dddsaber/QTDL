package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaiKhoan {
	private String tenTK;
	private String matKhauTK;
	
	@Id
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMatKhauTK() {
		return matKhauTK;
	}
	public void setMatKhauTK(String matKhauTK) {
		this.matKhauTK = matKhauTK;
	}
	
	public boolean xacthuc(String tenTK, String matKhauTK) {
		if(this.tenTK.equals(tenTK) && this.matKhauTK.equals(matKhauTK))
			return true;
		return false;
	}
	
}
