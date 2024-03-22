package model;

import java.util.ArrayList;

import dao.ChuNhiemDAO;

public class ChuNhiemModel {
    private ArrayList<ChuNhiem> dsChuNhiem;
    private ChuNhiemDAO chuNhiemDao;

    public ChuNhiemModel(final ArrayList<ChuNhiem> dsChuNhiem, final ChuNhiemDAO chuNhiemDao) {
        this.dsChuNhiem = dsChuNhiem;
        this.chuNhiemDao = chuNhiemDao;
    }
    
    public ChuNhiemModel(final ArrayList<ChuNhiem> dsChuNhiem) {
        this.dsChuNhiem = dsChuNhiem;
    }

    public ChuNhiemModel(){
        this.dsChuNhiem = new ArrayList<ChuNhiem>();
        this.chuNhiemDao = new ChuNhiemDAO();
    }
    
    public ArrayList<ChuNhiem> getDsChuNhiem() {
        return dsChuNhiem;
    }

    public void setDsChuNhiem(final ArrayList<ChuNhiem> dsChuNhiem) {
        this.dsChuNhiem = dsChuNhiem;
    }

    public ChuNhiemDAO getChuNhiemDao() {
        return chuNhiemDao;
    }

    public void setChuNhiemDao(final ChuNhiemDAO chuNhiemDao) {
        this.chuNhiemDao = chuNhiemDao;
    }
    public void insert(ChuNhiem ChuNhiem) {
		this.dsChuNhiem.add(ChuNhiem);
		this.chuNhiemDao.saveOrUpdate(ChuNhiem);
	}
	
	public void delete(ChuNhiem ChuNhiem) {
		this.dsChuNhiem.remove(ChuNhiem);
		this.chuNhiemDao.delete(ChuNhiem);
	}
	
	public void update(ChuNhiem ChuNhiem) {
		this.chuNhiemDao.saveOrUpdate(ChuNhiem);
		this.dsChuNhiem.remove(ChuNhiem);
		this.dsChuNhiem.add(ChuNhiem);
	}

	public boolean daTonTai(ChuNhiem cn) {
		for(ChuNhiem ChuNhiem : dsChuNhiem) {
			if(ChuNhiem.getMaGV().equals(cn.getMaGV()) ) {
				return true;
			}
			if(ChuNhiem.getMaLop().equals(cn.getMaLop()) ) {
				return true;
			}
		}
		return false;
	}
	

}