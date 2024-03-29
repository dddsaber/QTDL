package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QLHS;

public class ThongKeTabListener implements ActionListener{

	private QLHS view;
	
	public ThongKeTabListener (QLHS view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
	 
		if(actionCommand.equals("Thống kê")) {
			String lopLuaChon = this.view.comboBoxChonLopThongKe.getSelectedItem().toString();
			this.view.layDSXepHangTheoHocLuc(lopLuaChon);
		}
 	}


}