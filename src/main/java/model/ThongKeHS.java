package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import dao.DiemDAO;
import dao.HocSinhDAO;
import dao.ThongKeDAO;

@Entity
public class ThongKeHS {
	@Id
	private String maHS;
	private String tenHS;
	private double tbToan;
	private double tbVan;
	private double tbNN;
	private double tbMon;
	
	public ThongKeHS() {
		
	}
	
	public ThongKeHS(String maHS) {
		super();
		this.maHS = maHS;
	}

	public ThongKeHS(String maHS, String tenHS, double tbToan, double tbVan, double tbNN, double tbMon) {
		super();
		this.maHS = maHS;
		this.tenHS = tenHS;
		this.tbToan = tbToan;
		this.tbVan = tbVan;
		this.tbNN = tbNN;
		this.tbMon = tbMon;
	}


	public String getMaHS() {
		return maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	public String getTenHS() {
		return tenHS;
	}

	public void setTenHS(String tenHS) {
		this.tenHS = tenHS;
	}

	public double getTbToan() {
		return tbToan;
	}

	public void setTbToan(double tbToan) {
		this.tbToan = tbToan;
	}

	public double getTbVan() {
		return tbVan;
	}

	public void setTbVan(double tbVan) {
		this.tbVan = tbVan;
	}

	public double getTbNN() {
		return tbNN;
	}

	public void setTbNN(double tbNN) {
		this.tbNN = tbNN;
	}

	public double getTbMon() {
		return tbMon;
	}

	public void setTbMon(double tbMon) {
		this.tbMon = tbMon;
	}
	
	public String getHocLuc() {
		String hocLuc = new String();
		if(tbMon >= 8.0)
			hocLuc = new String("Giỏi");
		else if(tbMon < 8.0 && tbMon >= 6.5) 
			hocLuc = new String("Khá");
		else if(tbMon < 6.5 && tbMon >= 5.0)
			hocLuc = new String("Trung bình");
		else if(tbMon < 5.0 && tbMon >= 3.5)
			hocLuc = new String("Yếu");
		else if(tbMon < 3.5)
			hocLuc = new String("Kém");
		
		return hocLuc;
	}
	
	

	
//	public ThongKeHS(String maHS) {
//		this.maHS = maHS;
//		HocSinhDAO hsdao = new HocSinhDAO();
//		HocSinh hs = hsdao.selectById(maHS);
//		
//		DiemDAO ddao = new DiemDAO();
//		List<Diem> dsdiem = ddao.selectByMaHS(maHS);
//		
//		
//		for(int i = 0; i < dsdiem.size(); i++) {
//			if(dsdiem.get(i).getMaMonHoc().equals("TOAN")) {
//				tbToan = ((dsdiem.get(i).getDiemMieng() != null ? dsdiem.get(i).getDiemMieng() : 0.0) +( dsdiem.get(i).getDiem15Phut() != null ? dsdiem.get(i).getDiem15Phut() : 0.0) + (dsdiem.get(i).getDiem1Tiet() != null ? dsdiem.get(i).getDiem1Tiet() : 0.0) * 2 + (dsdiem.get(i).getDiemHocKy()!= null ? dsdiem.get(i).getDiemHocKy() : 0.0) * 3)/7;
//			}
//		}
//	}
	
}