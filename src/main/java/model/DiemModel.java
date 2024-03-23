package model;

import java.util.ArrayList;
import java.util.List;

import dao.DiemDAO;

public class DiemModel {
	private ArrayList<Diem> dsDiem;
	private DiemDAO diemDAO;
	
	
	
	public DiemModel() {
		this.dsDiem = new ArrayList<Diem>();
		this.diemDAO = new DiemDAO();
	}

	public DiemModel(ArrayList<Diem> dsDiem, DiemDAO diemDAO) {
		this.dsDiem = dsDiem;
		this.diemDAO = diemDAO;
	}
	
	

	public ArrayList<Diem> getdsDiem() {
		return dsDiem;
	}

	public void setdsDiem(ArrayList<Diem> dsDiem) {
		this.dsDiem = dsDiem;
	}

	public DiemDAO getdiemDAO() {
		return diemDAO;
	}

	public void setdiemDAO(DiemDAO diemDAO) {
		this.diemDAO = diemDAO;
	}

	public void insert(Diem Diem) {
		this.dsDiem.add(Diem);
		this.diemDAO.saveOrUpdate(Diem);
	}
	
	public void delete(Diem Diem) {
		this.dsDiem.remove(Diem);
		this.diemDAO.delete(Diem);
	}
	
	public void update(Diem Diem) {
		this.diemDAO.saveOrUpdate(Diem);
		this.dsDiem =  (ArrayList<model.Diem>) this.diemDAO.selectAll();
	}

	public boolean daTonTai(Diem diem) {
		for(Diem Diem : dsDiem) {
			if(Diem.getMaHS().equals(diem.getMaHS()) && Diem.getMaMonHoc().equals(diem.getMaMonHoc())) {
				return true;
			}
		}
		return false;
	}
}
