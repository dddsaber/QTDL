package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GiaoVien;
import view.QLHS;

public class HocSinhTabListener implements ActionListener{
	private QLHS view;
	
	public HocSinhTabListener(QLHS view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Tạo mới")) {
			view.xoaTextFieldHS();
		}
		else if(actionCommand.equals("Xoá")) {
			view.xoaHS();
		}
		else if(actionCommand.equals("Lưu")) {
			view.luuDuLieuHStuInput();
		}
		else if(actionCommand.equals("Chọn")) {
			view.hienThiThongTinHSDangChon();
		}
		else if(actionCommand.equals("Huỷ tìm")) {
			view.huytimHS();
		}
		else if(actionCommand.equals("Tìm kiếm")) {
			view.timHS();
		}
		else if(actionCommand.equals("Xuất File")) {
			view.xuatFileHS();;
		}
	}
}
