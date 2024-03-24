package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QLHS;

public class LopListener implements ActionListener {
private QLHS view;
	
	public LopListener(QLHS view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Tạo mới")) {
			view.xoaTextFieldPL();
		}
		else if(actionCommand.equals("Xoá")) {
			view.xoaPhongLop();
		}
		else if(actionCommand.equals("Lưu")) {
			view.luuDuLieuPLtuInput();
		}
		else if(actionCommand.equals("Chọn")) {
			view.hienThiThongTinPhongLopDangChon();
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
