package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QLHS;

public class LopHocListener implements ActionListener {
	private QLHS view;
	
	
	public LopHocListener(QLHS view) {
		this.view = view;
	}


	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Tạo mới")) {
			view.xoaTextFieldLH();
		}
		else if(actionCommand.equals("Xoá")) {
			view.xoaLopHoc();
		}
		else if(actionCommand.equals("Lưu")) {
			view.luuDuLieuLHtuInput();
		}
		else if(actionCommand.equals("Chọn")) {
			view.hienThiThongTinLopHocDangChon();
		}
		else if(actionCommand.equals("Huỷ tìm")) {
			view.huytimLH();
		}
		else if(actionCommand.equals("Tìm kiếm")) {
			view.timKiemLopHoc();
		}
		else if(actionCommand.equals("Xuất File")) {
			view.xuatFileLop();
		}
	}
}
