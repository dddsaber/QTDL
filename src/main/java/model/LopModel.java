package model;

import java.util.ArrayList;

import dao.LopDAO;

public class LopModel {
    private ArrayList<Lop> dsLop;
    private LopDAO lopDao;
    

    //contructor
    public LopModel(ArrayList<Lop> dsLop, LopDAO lopDao) {
        this.dsLop = dsLop;
        this.lopDao = lopDao;
    }
    public LopModel(ArrayList<Lop> dsLop) {
        this.dsLop = dsLop;
    }
    public LopModel() {
        this.dsLop = new ArrayList<Lop>();
        this.lopDao = new LopDAO();
    }


    
    public ArrayList<Lop> getDsLop() {
        return dsLop;
    }
    public void setDsLop(ArrayList<Lop> dsLop) {
        this.dsLop = dsLop;
    }
    public LopDAO getLopDao() {
        return lopDao;
    }
    public void setLopDao(LopDAO lopDao) {
        this.lopDao = lopDao;
    }

    public void insert(Lop Lop) {
		this.dsLop.add(Lop);
		this.lopDao.saveOrUpdate(Lop);
	}
	
	public void delete(Lop Lop) {
		this.dsLop.remove(Lop);
		this.lopDao.delete(Lop);
	}
	
	public void update(Lop Lop) {
		this.lopDao.saveOrUpdate(Lop);
		this.dsLop.remove(Lop);
		this.dsLop.add(Lop);
	}
	
	public boolean daTonTai(Lop lop) {
		for(Lop Lop : dsLop) {
			if(Lop.getMaLop().equals(lop.getMaLop())) {
				return true;
			}
		}
		return false;
	}
    
}
