package model;

import java.util.ArrayList;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.LopDAO;

public class LopModel {
	private ArrayList<Lop> dsLop;
	private LopDAO lopDao;

	// contructor
	public LopModel(ArrayList<Lop> dsLop, LopDAO lopDao) {
		this.dsLop = dsLop;
		this.lopDao = lopDao;
	}

	public LopModel(ArrayList<Lop> dsLop) {
		this.dsLop = dsLop;
	}

	public LopModel() {
		this.dsLop = new ArrayList<Lop>();
		this.lopDao = new LopDAO();
	}

	public ArrayList<Lop> getDsLop() {
		return dsLop;
	}

	public void setDsLop(ArrayList<Lop> dsLop) {
		this.dsLop = dsLop;
	}

	public LopDAO getLopDao() {
		return lopDao;
	}

	public void setLopDao(LopDAO lopDao) {
		this.lopDao = lopDao;
	}

	public void insert(Lop Lop) {
		this.dsLop.add(Lop);
		this.lopDao.saveOrUpdate(Lop);
	}

	public boolean delete(Lop Lop) {
		if (this.lopDao.delete(Lop)) {
			this.dsLop.remove(Lop);
			return true;
		}
		return false;
	}

	public void update(Lop Lop) {
		this.lopDao.saveOrUpdate(Lop);
		this.dsLop = (ArrayList<model.Lop>) this.lopDao.selectAll();
	}

	public boolean daTonTai(Lop lop) {
		for (Lop Lop : dsLop) {
			if (Lop.getMaLop().equals(lop.getMaLop())) {
				return true;
			}
		}
		return false;
	}

	public String getTenByMa(String maLop) {
		ArrayList<Lop> dslop = (ArrayList<Lop>) this.lopDao.selectAll();
		for (int i = 0; i < dslop.size(); i++) {
			if (dslop.get(i).getMaLop().equals(maLop))
				return dslop.get(i).getTenLop();
		}
		return "Chưa có Lớp";

	}

	public void xuatFileDSLH(String tenfile) {
		// Tạo một workbook mới
		try (Workbook workbook = new XSSFWorkbook()) {
			// Tạo một trang tính mới
			Sheet sheet = workbook.createSheet("Sheet1");

			ArrayList<Lop> data = this.dsLop;

			int rowCount = 0;
			Row row = sheet.createRow(0);

			// Ghi tên cột

			row.createCell(0).setCellValue("STT");
			row.createCell(1).setCellValue("Mã lớp");
			row.createCell(2).setCellValue("Tên lớp học");
			row.createCell(3).setCellValue("Niên khóa");
			row.createCell(4).setCellValue("Sỉ số lớp");

						// Ghi dữ liệu vào file Excel
			for (int i = 0; i < data.size(); i++) {
				row = sheet.createRow(i + 1);

				// Ghi dữ liệu của đối tượng vào các Cell
				row.createCell(0).setCellValue(i + 1);
				row.createCell(1).setCellValue(data.get(i).getMaLop());
				row.createCell(2).setCellValue(data.get(i).getTenLop());
				row.createCell(3).setCellValue(data.get(i).getNienKhoa());
				row.createCell(4).setCellValue(this.lopDao.laySoHS(data.get(i)));

			}

			// Ghi workbook ra file
			try (FileOutputStream outputStream = new FileOutputStream(tenfile + ".xlsx")) {
				workbook.write(outputStream);
			}
			System.out.println("File Excel đã được tạo thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean deleteAnyway(Lop lop) {
		if(this.lopDao.deleteAnyway(lop)) {
			System.out.println(this.dsLop.remove(lop)); 
			return true;
		};
		return false;
	}

	public int getSiSo(Lop lop) {
		return this.lopDao.laySoHS(lop);
	}
}
