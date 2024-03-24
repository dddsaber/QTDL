package model;

import java.util.ArrayList;

import dao.PhongLopDAO;

public class PhongLopModel {
    private  ArrayList<PhongLop> dsPhongLop;
    private PhongLopDAO phongLopDao;


    
    public PhongLopModel(ArrayList<PhongLop> dsPhongLop, PhongLopDAO phongLopDao) {
        this.dsPhongLop = dsPhongLop;
        this.phongLopDao = phongLopDao;
    }
    public PhongLopModel(ArrayList<PhongLop> dsPhongLop) {
        this.dsPhongLop = dsPhongLop;
    }
    public PhongLopModel() {
        this.dsPhongLop = new ArrayList<PhongLop>();
        this.phongLopDao = new PhongLopDAO();
    }



    public ArrayList<PhongLop> getDsPhongLop() {
        return dsPhongLop;
    }
    public void setDsPhongLop(ArrayList<PhongLop> dsPhongLop) {
        this.dsPhongLop = dsPhongLop;
    }
    public PhongLopDAO getPhonglopDao() {
        return phongLopDao;
    }
    public void setPhonglopDao(PhongLopDAO phonglopDao) {
        this.phongLopDao = phonglopDao;
    }
    public void insert(PhongLop PhongLop) {
  		this.dsPhongLop.add(PhongLop);
  		this.phongLopDao.saveOrUpdate(PhongLop);
  	}
  	
  	public void delete(PhongLop PhongLop) {
  		this.dsPhongLop.remove(PhongLop);
  		this.phongLopDao.delete(PhongLop);
  	}
  	
  	public void update(PhongLop PhongLop) {
  		this.phongLopDao.saveOrUpdate(PhongLop);
  		this.dsPhongLop = (ArrayList<model.PhongLop>) this.phongLopDao.selectAll();
  	}
  	
  	public boolean daTonTai(PhongLop pl) {
  		for(PhongLop PhongLop : dsPhongLop) {
  			if(PhongLop.getMaLop().equals(pl.getMaLop()) && PhongLop.getMaPhong().equals(pl.getMaPhong())) {
  				return true;
  			}
  		}
  		
  		return false;
  	}
}
