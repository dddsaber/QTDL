package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QLHS;

public class GiaoVienTabListener implements ActionListener {
	private QLHS view;
	
	public GiaoVienTabListener(QLHS view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		//JOptionPane.showMessageDialog(view, "Ban vua nhan vao " + actionCommand);
		if(actionCommand.equals("Tạo mới")) {
			view.xoaTextFieldGV();
		}
		else if(actionCommand.equals("Xoá")) {
			view.xoaGV();
		}
		else if(actionCommand.equals("Xoá ")) {
			view.xoaCN();
		}
		else if(actionCommand.equals("Lưu")) {
			view.luuDuLieuGVtuInput();
		}
		else if(actionCommand.equals("Chọn")) {
			view.hienThiThongTinGVDangChon();
		}
		else if(actionCommand.equals("Cập nhật")) {
			view.luuDSChuNhiem();
			view.hienthiDSChuNhiemHienTai();
		}
		else if(actionCommand.equals("Huỷ tìm")) {
			view.huytimGV();
		}
		else if(actionCommand.equals("Tìm kiếm")) {
			view.timKiemGV();
		}
		else if(actionCommand.equals("Xuất File")) {
			view.xuatFileGV();
		}
		else if(actionCommand.equals("About me")) {
			view.aboutMe();
		}
		else if(actionCommand.equals("Exit")) {
			view.exit();
		}
	}
}
