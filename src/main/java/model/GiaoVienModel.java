package model;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.GiaoVienDAO;

public class GiaoVienModel {
	private ArrayList<GiaoVien> dsGiaoVien;
	private GiaoVienDAO gvDAO;
	
	
	public GiaoVienModel() {
		this.dsGiaoVien = new ArrayList<GiaoVien>();
		this.gvDAO = new GiaoVienDAO();
	}

	public GiaoVienDAO getGiaoVienDAO() {
		return gvDAO;
	}

	public void setTsDAO(GiaoVienDAO gvDAO) {
		this.gvDAO = gvDAO;
	}

	public GiaoVienModel(ArrayList<GiaoVien> dsGiaoVien) {
		this.dsGiaoVien = dsGiaoVien;
	}

	public ArrayList<GiaoVien> getDsGiaoVien() {
		return dsGiaoVien;
	}

	public void setDsGiaoVien(List<GiaoVien> list) {
		this.dsGiaoVien = (ArrayList<GiaoVien>) list;
	}
	
	public void insert(GiaoVien GiaoVien) {
		this.dsGiaoVien.add(GiaoVien);
		this.gvDAO.saveOrUpdate(GiaoVien);
	}
	
	public boolean delete(GiaoVien GiaoVien) {
		if(this.gvDAO.delete(GiaoVien)) {
			this.dsGiaoVien.remove(GiaoVien);
			return true;
		}
		return false;
	}
	
	public void update(GiaoVien GiaoVien) {
		this.gvDAO.saveOrUpdate(GiaoVien);
		this.dsGiaoVien = (ArrayList<model.GiaoVien>) this.gvDAO.selectAll();
	}
	
	public void xuatFileDSGV(String tenfile) {
		// Tạo một workbook mới
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một trang tính mới
            Sheet sheet = workbook.createSheet("Sheet1");

            ArrayList<GiaoVien> data = this.dsGiaoVien;
            int rowCount = 0;
            Row row = sheet.createRow(0);

            //Ghi tên cột
            row.createCell(0).setCellValue("STT");
            row.createCell(1).setCellValue("Mã giáo viên");
            row.createCell(2).setCellValue("Họ tên");
            row.createCell(3).setCellValue("Ngày sinh");
            row.createCell(4).setCellValue("Địa chỉ");
            row.createCell(5).setCellValue("Số điện thoại");
            
            // Ghi dữ liệu vào file Excel
            for(int i = 0; i < data.size(); i++) {
            	row = sheet.createRow(i+1);
                // Ghi dữ liệu của đối tượng vào các Cell
                row.createCell(0).setCellValue(i+1);
                row.createCell(1).setCellValue(data.get(i).getMaGV());
                row.createCell(2).setCellValue(data.get(i).getHoTenGV());
                String s_ngaySinh = data.get(i).getNgaySinhGV().getDate() + "/" + data.get(i).getNgaySinhGV().getMonth() + "/"
        				+ (data.get(i).getNgaySinhGV().getYear() + 1900);
                row.createCell(3).setCellValue(s_ngaySinh);
                row.createCell(4).setCellValue(data.get(i).getDiaChiGV());
                row.createCell(5).setCellValue(data.get(i).getSoDienThoaiGV());
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

	public boolean daTonTai(GiaoVien gv) {
		for(GiaoVien GiaoVien : dsGiaoVien) {
			if(GiaoVien.getMaGV().equals(gv.getMaGV())) {
				return true;
			}

		}
		return false;
	}

	public boolean deleteAnyway(GiaoVien gv) {
		this.dsGiaoVien.remove(gv);
		return this.gvDAO.deleteAnyway(gv);
		
	}
	
}
