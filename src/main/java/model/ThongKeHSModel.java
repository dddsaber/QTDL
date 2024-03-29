package model;

import java.util.ArrayList;

import dao.ThongKeDAO;

public class ThongKeHSModel {
	private ArrayList<ThongKeHS> thongKeList;
	private ThongKeDAO thongKeHSDao;
	public ThongKeHSModel() {
		super();
	}
	
	public ThongKeHSModel (String maLop) {
		thongKeHSDao = new ThongKeDAO();
		this.thongKeList = (ArrayList<ThongKeHS>) thongKeHSDao.layDSThongKe(maLop);
	}

	public ThongKeHSModel(ArrayList<ThongKeHS> thongKeList, ThongKeDAO thongKeHSDao) {
		super();
		this.thongKeList = thongKeList;
		this.thongKeHSDao = thongKeHSDao;
	}

	public ArrayList<ThongKeHS> getThongKeList() {
		return thongKeList;
	}

	public void setThongKeList(ArrayList<ThongKeHS> thongKeList) {
		this.thongKeList = thongKeList;
	}

	public ThongKeDAO getThongKeHSDao() {
		return thongKeHSDao;
	}

	public void setThongKeHSDao(ThongKeDAO thongKeHSDao) {
		this.thongKeHSDao = thongKeHSDao;
	}
	
	
	
	
}