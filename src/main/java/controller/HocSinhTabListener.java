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
			int luaChon = JOptionPane.showConfirmDialog(this.view, "Code đã chạy đúng");
			
			if(luaChon == JOptionPane.YES_OPTION) {
				
			}
		}
	}
}