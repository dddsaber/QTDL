package model;

import java.util.ArrayList;
import java.util.List;

import dao.GiaoVienDAO;

public class GiaoVienModel {
	private ArrayList<GiaoVien> dsGiaoVien;
	private GiaoVienDAO gvDAO;
	
	
	public GiaoVienModel() {
		this.dsGiaoVien = new ArrayList<GiaoVien>();
		this.gvDAO = new GiaoVienDAO();
	}

	public GiaoVienDAO getGiaoVienDAO() {
		return gvDAO;
	}

	public void setTsDAO(GiaoVienDAO gvDAO) {
		this.gvDAO = gvDAO;
	}

	public GiaoVienModel(ArrayList<GiaoVien> dsGiaoVien) {
		this.dsGiaoVien = dsGiaoVien;
	}

	public ArrayList<GiaoVien> getDsGiaoVien() {
		return dsGiaoVien;
	}

	public void setDsGiaoVien(List<GiaoVien> list) {
		this.dsGiaoVien = (ArrayList<GiaoVien>) list;
	}
	
	public void insert(GiaoVien GiaoVien) {
		this.dsGiaoVien.add(GiaoVien);
		this.gvDAO.saveOrUpdate(GiaoVien);
	}
	
	public void delete(GiaoVien GiaoVien) {
		this.dsGiaoVien.remove(GiaoVien);
		this.gvDAO.delete(GiaoVien);
	}
	
	public void update(GiaoVien GiaoVien) {
		this.gvDAO.saveOrUpdate(GiaoVien);
		this.dsGiaoVien.remove(GiaoVien);
		this.dsGiaoVien.add(GiaoVien);
	}

	public boolean daTonTai(GiaoVien gv) {
		for(GiaoVien GiaoVien : dsGiaoVien) {
			if(GiaoVien.getMaGV().equals(gv.getMaGV())) {
				return true;
			}

		}
		return false;
	}
	
}
