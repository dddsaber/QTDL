package QTDL.QLSV;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.DiemDAO;
import model.Diem;

public class Test {
    public static void main(String[] args) {
        // Tạo một workbook mới
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một trang tính mới
            Sheet sheet = workbook.createSheet("Sheet1");

            // Tạo dữ liệu mẫu
            DiemDAO ddao = new DiemDAO();
          
            List<Diem> data =  ddao.selectAll();
            String tmp = data.get(0).getClass().getDeclaredFields()[0].toString();
            System.out.println(tmp.substring(tmp.lastIndexOf(".")+1));

            int rowCount = 0;
            Row row = sheet.createRow(0);

            // Ghi dữ liệu của đối tượng vào các Cell
            row.createCell(0).setCellValue("Mã Học Sinh");
            row.createCell(1).setCellValue("Mã Môn Học");
            row.createCell(2).setCellValue("Điểm miệng");
            row.createCell(3).setCellValue("Điểm 15 phút");
            row.createCell(4).setCellValue("Điểm 1 tiết");
            row.createCell(5).setCellValue("Điểm học kỳ");
            // Ghi dữ liệu vào file Excel
            for(int i = 0; i < data.size(); i++) {
            	row = sheet.createRow(i+1);

                // Ghi dữ liệu của đối tượng vào các Cell
                row.createCell(0).setCellValue(data.get(i).getMaHS());
                row.createCell(1).setCellValue(data.get(i).getMaMonHoc());
                row.createCell(2).setCellValue(data.get(i).getDiemMieng() != null ? data.get(i).getDiemMieng() : 0.0);
                row.createCell(3).setCellValue(data.get(i).getDiem15Phut() != null ? data.get(i).getDiem15Phut() : 0.0);
                row.createCell(4).setCellValue(data.get(i).getDiem1Tiet() != null ? data.get(i).getDiem1Tiet() : 0.0);
                row.createCell(5).setCellValue(data.get(i).getDiemHocKy() != null ? data.get(i).getDiemHocKy() : 0.0);
            }

            // Ghi workbook ra file
            try (FileOutputStream outputStream = new FileOutputStream("example5.xlsx")) {
                workbook.write(outputStream);
            }
            System.out.println("File Excel đã được tạo thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
