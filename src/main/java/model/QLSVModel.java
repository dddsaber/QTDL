package model;

import java.util.ArrayList;
import java.util.List;

import dao.ThiSinhDAO;

public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private ThiSinhDAO tsDAO;
	
	
	public QLSVModel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
		this.tsDAO = new ThiSinhDAO();
	}

	public ThiSinhDAO getTsDAO() {
		return tsDAO;
	}

	public void setTsDAO(ThiSinhDAO tsDAO) {
		this.tsDAO = tsDAO;
	}

	public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(List<ThiSinh> list) {
		this.dsThiSinh = (ArrayList<ThiSinh>) list;
	}
	
	public void insert(ThiSinh thiSinh) {
		this.dsThiSinh.add(thiSinh);
		this.tsDAO.saveOrUpdate(thiSinh);
	}
	
	public void delete(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
		this.tsDAO.delete(thiSinh);
	}
	
	public void update(ThiSinh thiSinh) {
		this.tsDAO.saveOrUpdate(thiSinh);
		this.dsThiSinh.remove(thiSinh);
		this.dsThiSinh.add(thiSinh);
	}

	public boolean daTonTai(ThiSinh ts) {
		for(ThiSinh thisinh : dsThiSinh) {
			if(thisinh.getMaThiSinh() == ts.getMaThiSinh())
				return true;
		}
		return false;
	}
	
}
