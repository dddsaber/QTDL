package model;

import java.util.ArrayList;
import java.util.List;

import dao.HocSinhDAO;

public class HocSinhModel {
	private ArrayList<HocSinh> dsHocSinh;
    private HocSinhDAO hocSinhDao;
 
    public HocSinhModel(ArrayList<HocSinh> dsHocSinh, HocSinhDAO hocSinhDao) {
        this.dsHocSinh = dsHocSinh;
        this.hocSinhDao = hocSinhDao;
    }
    
    public HocSinhModel() {
        this.dsHocSinh = new ArrayList<HocSinh>();
        this.hocSinhDao =  new HocSinhDAO();
    }
    
    public HocSinhModel(ArrayList<HocSinh> dsHocSinh) {
        this.dsHocSinh = dsHocSinh;
    }
    
    //Get and set
    public ArrayList<HocSinh> getDsHocSinh() {
        return dsHocSinh;
    }
    public void setDsHocSinh(ArrayList<HocSinh> dsHocSinh) {
        this.dsHocSinh = dsHocSinh;
    }
    public HocSinhDAO getHocSinhDao() {
        return hocSinhDao;
    }
    public void setHocSinhDao(HocSinhDAO hocSinhDao) {
        this.hocSinhDao = hocSinhDao;
    }
    
    public void insert(HocSinh HocSinh) {
		this.dsHocSinh.add(HocSinh);
		this.hocSinhDao.saveOrUpdate(HocSinh);
	}
	
	public void delete(HocSinh HocSinh) {
		this.dsHocSinh.remove(HocSinh);
		this.hocSinhDao.delete(HocSinh);
	}
	
	public void update(HocSinh HocSinh) {
		this.hocSinhDao.saveOrUpdate(HocSinh);
		this.dsHocSinh.remove(HocSinh);
		this.dsHocSinh.add(HocSinh);
	}
	
	public boolean daTonTai(HocSinh hs) {
		for(HocSinh HocSinh : dsHocSinh) {
			if(HocSinh.getMaHS().equals(hs.getMaHS())) {
				return true;
			}
		}
		return false;
	}
    
	public ArrayList<HocSinh> findByInFor(String maHS, String hoTen, String maLop){
		List<HocSinh> all = this.hocSinhDao.selectAll();
		ArrayList<HocSinh> result =  new ArrayList<HocSinh>();
		for (HocSinh hocSinh : all) {
			System.out.println(hocSinh);
			if(!maHS.isEmpty() && !hocSinh.getMaHS().equals(maHS)) {
				continue;
			}
			if(!hoTen.isEmpty() && !hocSinh.getHoTenHS().equals(hoTen)) {
				continue;
			}
			if(!maLop.isEmpty() && !hocSinh.getMaLop().equals(maLop)) {
				continue;
			}
			System.out.println(hocSinh);
			result.add(hocSinh);
		}
		return result;
		
	}
		
}