package model;

import java.util.ArrayList;
import java.util.List;

import dao.DiemDAO;
import dao.HocSinhDAO;

public class ThongKeHS {
	private String maHS;
	private String tenHS;
	private double tbToan;
	private double tbVan;
	private double tbNN;
	
	public ThongKeHS(String maHS) {
		this.maHS = maHS;
		HocSinhDAO hsdao = new HocSinhDAO();
		HocSinh hs = hsdao.selectById(maHS);
		
		DiemDAO ddao = new DiemDAO();
		List<Diem> dsdiem = ddao.selectByMaHS(maHS);
		
		
		for(int i = 0; i < dsdiem.size(); i++) {
			if(dsdiem.get(i).getMaMonHoc().equals("TOAN")) {
				tbToan = ((dsdiem.get(i).getDiemMieng() != null ? dsdiem.get(i).getDiemMieng() : 0.0) +( dsdiem.get(i).getDiem15Phut() != null ? dsdiem.get(i).getDiem15Phut() : 0.0) + (dsdiem.get(i).getDiem1Tiet() != null ? dsdiem.get(i).getDiem1Tiet() : 0.0) * 2 + (dsdiem.get(i).getDiemHocKy()!= null ? dsdiem.get(i).getDiemHocKy() : 0.0) * 3)/7;
			}
		}
	}
	
	public ThongKeHS(String maHS, String tenHS, double tbToan, double tbVan, double tbNN) {
		this.maHS = maHS;
		this.tenHS = tenHS;
		this.tbToan = tbToan;
		this.tbVan = tbVan;
		this.tbNN = tbNN;
	}
	
	
}
