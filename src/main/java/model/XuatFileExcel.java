package model;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.DiemDAO;

public class XuatFileExcel {
	private String tenFile;
	
	public XuatFileExcel(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public XuatFileExcel() {
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public void xuatFileDSGV(ArrayList<GiaoVien> data) {
		// Tạo một workbook mới
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một trang tính mới
            Sheet sheet = workbook.createSheet("Sheet1");

            int rowCount = 0;
            Row row = sheet.createRow(0);

            //Ghi tên cột
            row.createCell(0).setCellValue("STTs");
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
                row.createCell(3).setCellValue(data.get(i).getNgaySinhGV());
                row.createCell(4).setCellValue(data.get(i).getDiaChiGV());
                row.createCell(5).setCellValue(data.get(i).getSoDienThoaiGV());
            }

            // Ghi workbook ra file
            try (FileOutputStream outputStream = new FileOutputStream(this.tenFile+".xlsx")) {
                workbook.write(outputStream);
            }
            System.out.println("File Excel đã được tạo thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
