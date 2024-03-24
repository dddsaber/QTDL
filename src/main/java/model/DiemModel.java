package model;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.DiemDAO;
import dao.HocSinhDAO;

public class DiemModel {
	private ArrayList<Diem> dsDiem;
	private DiemDAO diemDAO;
	
	
	
	public DiemModel() {
		this.dsDiem = new ArrayList<Diem>();
		this.diemDAO = new DiemDAO();
	}

	public DiemModel(ArrayList<Diem> dsDiem, DiemDAO diemDAO) {
		this.dsDiem = dsDiem;
		this.diemDAO = diemDAO;
	}
	
	

	public ArrayList<Diem> getdsDiem() {
		return dsDiem;
	}

	public void setdsDiem(ArrayList<Diem> dsDiem) {
		this.dsDiem = dsDiem;
	}

	public DiemDAO getdiemDAO() {
		return diemDAO;
	}

	public void setdiemDAO(DiemDAO diemDAO) {
		this.diemDAO = diemDAO;
	}

	public void insert(Diem Diem) {
		this.dsDiem.add(Diem);
		this.diemDAO.saveOrUpdate(Diem);
	}
	
	public void delete(Diem Diem) {
		this.dsDiem.remove(Diem);
		this.diemDAO.delete(Diem);
	}
	
	public void update(Diem Diem) {
		this.diemDAO.saveOrUpdate(Diem);
		this.dsDiem =  (ArrayList<model.Diem>) this.diemDAO.selectAll();
	}

	public boolean daTonTai(Diem diem) {
		for(Diem Diem : dsDiem) {
			if(Diem.getMaHS().equals(diem.getMaHS()) && Diem.getMaMonHoc().equals(diem.getMaMonHoc())) {
				return true;
			}
		}
		return false;
	}
	public void xuatFileDSDiem(String tenfile) {
		// Tạo một workbook mới
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một trang tính mới
            Sheet sheet = workbook.createSheet("Sheet1");

            ArrayList<Diem> data = this.dsDiem;
            int rowCount = 0;
            Row row = sheet.createRow(0);

            //Ghi tên cột
            row.createCell(0).setCellValue("STT");
            row.createCell(1).setCellValue("Mã học sinh");
            row.createCell(2).setCellValue("Họ tên");
            row.createCell(3).setCellValue("Mã môn học");
            row.createCell(4).setCellValue("Tên môn");
            row.createCell(5).setCellValue("Điểm miệng");
            row.createCell(6).setCellValue("Điểm 15 phút");
            row.createCell(7).setCellValue("Điểm 1 tiết");
            row.createCell(8).setCellValue("Điểm học kỳ");
            // Ghi dữ liệu vào file Excel
            HocSinhModel hsmodel = new HocSinhModel();
            MonHocModel mhmodel = new MonHocModel();
            
            for(int i = 0; i < data.size(); i++) {
            	
            	row = sheet.createRow(i+1);
                // Ghi dữ liệu của đối tượng vào các Cell
                row.createCell(0).setCellValue(i+1);
                row.createCell(1).setCellValue(data.get(i).getMaHS());
                row.createCell(2).setCellValue(hsmodel.getHocSinhDao().selectById(data.get(i).getMaHS()).getHoTenHS());
                row.createCell(3).setCellValue(data.get(i).getMaMonHoc());
                row.createCell(4).setCellValue(mhmodel.getMonHocDao().selectById(data.get(i).getMaMonHoc()).getTenMonHoc());
                row.createCell(5).setCellValue(data.get(i).getDiemMieng() != null ? data.get(i).getDiemMieng() : 0.0);
                row.createCell(6).setCellValue(data.get(i).getDiem15Phut() != null ? data.get(i).getDiem15Phut() : 0.0);
                row.createCell(7).setCellValue(data.get(i).getDiem1Tiet() != null ? data.get(i).getDiem1Tiet() : 0.0);
                row.createCell(8).setCellValue(data.get(i).getDiemHocKy() != null ? data.get(i).getDiemHocKy() : 0.0);
            }

            // Ghi workbook ra file
            try (FileOutputStream outputStream = new FileOutputStream(tenfile+".xlsx")) {
                workbook.write(outputStream);
            }
            System.out.println("File Excel đã được tạo thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
