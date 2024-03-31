package model;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import dao.ThongKeDAO;

public class ThongKeHSModel {
	private ArrayList<ThongKeHS> thongKeList;
	private ThongKeDAO thongKeHSDao;
	public ThongKeHSModel() {
		super();
	}
	
	public ThongKeHSModel (String maLop, String nienKhoa) {
		thongKeHSDao = new ThongKeDAO();
		this.thongKeList = (ArrayList<ThongKeHS>) thongKeHSDao.layDSThongKe(maLop, nienKhoa);
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
	
	public void xuatFileDSDiem(String tenfile) {
		// Tạo một workbook mới
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một trang tính mới
            Sheet sheet = workbook.createSheet("Sheet1");

            ArrayList<ThongKeHS> data = this.thongKeList;
            int rowCount = 0;
            Row row = sheet.createRow(0);

            //Ghi tên cột
            row.createCell(0).setCellValue("Hạng");
            row.createCell(1).setCellValue("Mã học sinh");
            row.createCell(2).setCellValue("Tên học sinh");
            row.createCell(3).setCellValue("Điểm tb văn");
            row.createCell(4).setCellValue("Điểm tb toán");
            row.createCell(5).setCellValue("Điểm tb ngoại ngữ");
            row.createCell(6).setCellValue("Điểm tb các môn");
            row.createCell(7).setCellValue("Học lực");
            // Ghi dữ liệu vào file Excel
            
            for(int i = 0; i < data.size(); i++) {
            	
            	row = sheet.createRow(i+1);
                // Ghi dữ liệu của đối tượng vào các Cell
                row.createCell(0).setCellValue(i+1);
                row.createCell(1).setCellValue(data.get(i).getMaHS());
                row.createCell(2).setCellValue(data.get(i).getTenHS());
                row.createCell(3).setCellValue(data.get(i).getTbVan());
                row.createCell(4).setCellValue(data.get(i).getTbToan());
                row.createCell(5).setCellValue(data.get(i).getTbNN());
                row.createCell(6).setCellValue(data.get(i).getTbMon());
                row.createCell(7).setCellValue(data.get(i).getHocLuc());
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