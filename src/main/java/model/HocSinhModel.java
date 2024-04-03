package model;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	
	public boolean delete(HocSinh HocSinh) {
		if(this.hocSinhDao.delete(HocSinh)) {;
			this.dsHocSinh.remove(HocSinh);
			return true;
		}	
		return false;
	}
	
	public void update(HocSinh HocSinh) {
		this.hocSinhDao.saveOrUpdate(HocSinh);
		this.dsHocSinh = (ArrayList<model.HocSinh>) this.hocSinhDao.selectAll();
	}
	
	public ArrayList<HocSinh> findByInFor(String maHS, String hoTen, String maLop){
		ArrayList<HocSinh> all = (ArrayList<HocSinh>)this.hocSinhDao.selectAll();
		ArrayList<HocSinh> result =  new ArrayList<HocSinh>();
		for (HocSinh hocSinh : all) {
			System.out.println(hocSinh);
			if(hocSinh.getMaHS().equals(maHS)) {
				result.add(hocSinh);
				break;
			}
			if(!maHS.isEmpty() && !hocSinh.getMaHS().equals(maHS)) {
				continue;
			}
			if(!hoTen.isEmpty() && !hocSinh.getHoTenHS().contains(hoTen)) {
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
	
	public boolean daTonTai(HocSinh hs) {
		for(HocSinh HocSinh : dsHocSinh) {
			if(HocSinh.getMaHS().equals(hs.getMaHS())) {
				return true;
			}
		}
		return false;
	}
    
	public ArrayList<String> getMabyTen(String tenHS) {
		ArrayList<String> ds = new ArrayList<String>();
    	this.dsHocSinh = (ArrayList<HocSinh>) this.hocSinhDao.selectAll();
    	for(HocSinh hs : this.dsHocSinh) {
    		if(hs.getHoTenHS().contains(tenHS))
    			ds.add(hs.getMaHS());
    	}
    	return ds;
    }


	/*
	 * XUẤT FILE HỌC SINH
	 * */
	public void xuatFileDSHS(String tenfile) {
		// Tạo một workbook mới
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một trang tính mới
            Sheet sheet = workbook.createSheet("Sheet1");

            ArrayList<HocSinh> data = this.dsHocSinh;
            int rowCount = 0;
            Row row = sheet.createRow(0);

            //Ghi tên cột
            row.createCell(0).setCellValue("STT");
            row.createCell(1).setCellValue("Mã học sinh");
            row.createCell(2).setCellValue("Họ và Tên");
            row.createCell(3).setCellValue("Ngày sinh");
            row.createCell(4).setCellValue("Địa chỉ");
            row.createCell(5).setCellValue("SDT phụ huynh");
            row.createCell(6).setCellValue("Lớp");
            
            // Ghi dữ liệu vào file Excel
            for(int i = 0; i < data.size(); i++) {
            	row = sheet.createRow(i+1);

                // Ghi dữ liệu của đối tượng vào các Cell
                row.createCell(0).setCellValue(i+1);
                row.createCell(1).setCellValue(data.get(i).getMaHS());
                row.createCell(2).setCellValue(data.get(i).getHoTenHS());
                String s_ngaySinh = data.get(i).getNgaySinhHS().getDate() + "/" + data.get(i).getNgaySinhHS().getMonth() + "/"
        				+ (data.get(i).getNgaySinhHS().getYear() + 1900);
                row.createCell(3).setCellValue(s_ngaySinh);
                row.createCell(4).setCellValue(data.get(i).getDiaChiHS());
                row.createCell(5).setCellValue(data.get(i).getSDTPhuHuynhHS());
                row.createCell(6).setCellValue(data.get(i).getMaLop());
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
	
	public boolean deleteAnyway(HocSinh hs) {
		if(this.hocSinhDao.deleteAnyway(hs)) {
			System.out.println(this.dsHocSinh.remove(hs)); 
			return true;
		};
		return false;
	}
}