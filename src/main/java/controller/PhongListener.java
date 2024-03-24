package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QLHS;

public class PhongListener implements ActionListener{
	private QLHS view;
	
	public PhongListener(QLHS view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Tạo mới")) {
			view.xoaTextFieldPH();
			
		}
		else if(actionCommand.equals("Xoá")) {
			view.xoaPhongHoc();
		}
		else if(actionCommand.equals("Lưu")) {
			view.luuDuLieuPHtuInput();
		}
		else if(actionCommand.equals("Chọn")) {
			view.hienThiThongTinPhongHocDangChon();
		}
		else if(actionCommand.equals("Huỷ tìm")) {
			view.huytimPH();
			view.huytimPL();
		}
		else if(actionCommand.equals("Tìm kiếm")) {
			view.timKiemPhongLop();
		}
	}

}
