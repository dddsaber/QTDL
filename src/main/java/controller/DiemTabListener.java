package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.QLHS;

public class DiemTabListener implements ActionListener {
	private QLHS view;
	
	public DiemTabListener(QLHS view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		//JOptionPane.showMessageDialog(view, "Ban vua nhan vao " + actionCommand);
		if(actionCommand.equals("Lấy danh sách")) {
			view.layDSDiem();
		}
		else if(actionCommand.equals("Lưu")) {
			view.luuDSDiem();
			JOptionPane.showMessageDialog(view, "Thêm thành công");
		}
		else if(actionCommand.equals("Huỷ tìm")) {
			view.hienThiDSDiemHienTai();
		}
		else if(actionCommand.equals("Tìm kiếm")) {
			view.timKiemDiemHS();
		}
		else if(actionCommand.equals("About me")) {
			view.aboutMe();
		}
		else if(actionCommand.equals("Exit")) {
			view.exit();
		}
		else if(actionCommand.equals("Xuất File")) {
			view.xuatFileDiem();
		}
	}
}
