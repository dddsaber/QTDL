package model;

import java.util.ArrayList;

import dao.MonHocDAO;

public class MonHocModel {
    private ArrayList<MonHoc> dsMonHoc;
    private MonHocDAO monHocDao;

    public MonHocModel(ArrayList<MonHoc> dsMonHoc, MonHocDAO monHocDao) {
        this.dsMonHoc = dsMonHoc;
        this.monHocDao = monHocDao;
    }

    public MonHocModel(ArrayList<MonHoc> dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    public MonHocModel() {
        this.dsMonHoc = new ArrayList<MonHoc>();
        this.monHocDao = new MonHocDAO();
    }

    
    public ArrayList<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(ArrayList<MonHoc> dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    public MonHocDAO getMonHocDao() {
        return monHocDao;
    }

    public void setMonHocDao(MonHocDAO monHocDao) {
        this.monHocDao = monHocDao;
    }
    
    public void insert(MonHoc MonHoc ) {
		this.dsMonHoc .add(MonHoc );
		this.monHocDao.saveOrUpdate(MonHoc );
	}
	
	public void delete(MonHoc  MonHoc ) {
		this.dsMonHoc.remove(MonHoc );
		this.monHocDao.delete(MonHoc );
	}
	
	public void update(MonHoc  MonHoc ) {
		this.monHocDao.saveOrUpdate(MonHoc );
		this.dsMonHoc = (ArrayList<model.MonHoc>) this.monHocDao.selectAll();
	}
	
	public boolean daTonTai(MonHoc mh) {
		for(MonHoc  MonHoc : dsMonHoc) {
			if(MonHoc.getMaMonHoc().equals(mh.getMaMonHoc())) {
				return true;
			}
		}
		return false;
	}
    
    


    
}
