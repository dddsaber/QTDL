package model;

import java.util.ArrayList;

import dao.PhongHocDAO;

public class PhongHocModel {
    private ArrayList<PhongHoc> dsPhongHoc;
    private PhongHocDAO phongHocDAO;

    
    public PhongHocModel(ArrayList<PhongHoc> dsPhongHoc, PhongHocDAO phongHocDAO) {
        this.dsPhongHoc = dsPhongHoc;
        this.phongHocDAO = phongHocDAO;
    }
    public PhongHocModel(ArrayList<PhongHoc> dsPhongHoc) {
        this.dsPhongHoc = dsPhongHoc;
    }
    public PhongHocModel() {
        this.dsPhongHoc = new ArrayList<PhongHoc>();
        this.phongHocDAO = new PhongHocDAO();
    }  


    public ArrayList<PhongHoc> getDsPhongHoc() {
        return dsPhongHoc;
    }
    public void setDsPhongHoc(ArrayList<PhongHoc> dsPhongHoc) {
        this.dsPhongHoc = dsPhongHoc;
    }
    public PhongHocDAO getPhongHocDAO() {
        return phongHocDAO;
    }
    public void setPhongHocDAO(PhongHocDAO phongHocDAO) {
        this.phongHocDAO = phongHocDAO;
    }
    public void insert(PhongHoc PhongHoc) {
  		this.dsPhongHoc.add(PhongHoc);
  		this.phongHocDAO.saveOrUpdate(PhongHoc);
  	}
  	
  	public boolean delete(PhongHoc PhongHoc) {
  		if(this.phongHocDAO.delete(PhongHoc)) {
  			this.dsPhongHoc.remove(PhongHoc);
  			return true;
  		}
  		return false;
  	}
  	
  	public void update(PhongHoc PhongHoc ) {
  		this.phongHocDAO.saveOrUpdate(PhongHoc);
  		this.dsPhongHoc = (ArrayList<model.PhongHoc>) this.phongHocDAO.selectAll();
  	}
  	
  	public boolean daTonTai(PhongHoc ph) {
  		for(PhongHoc PhongHoc: dsPhongHoc) {
  			if(PhongHoc.getMaPhong().equals(ph.getMaPhong())) {
  				return true;
  			}
  		}
  		return false;
  	}

    
}
