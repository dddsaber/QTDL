package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.QLSVView;

public class QLSVListener implements ActionListener {
	private QLSVView view;
	
	public QLSVListener(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		//JOptionPane.showMessageDialog(view, "Ban vua nhan vao " + actionCommand);
		if(actionCommand.equals("Them")) {
			view.them();
		}
		else if(actionCommand.equals("Xoa")) {
			view.xoa();
		}
		else if(actionCommand.equals("Cap nhat")) {
			view.capnhat();
		}
		else if(actionCommand.equals("Luu")) {
			view.luu();
		}
		else if(actionCommand.equals("Huy")) {
			view.them();
		}
		else if(actionCommand.equals("Tim kiem")) {
			view.tim();
		}
		else if(actionCommand.equals("Huy tim")) {
			view.huytim();
		}
		else if(actionCommand.equals("About me")) {
			view.aboutMe();
		}
		else if(actionCommand.equals("Exit")) {
			view.exit();
		}
		else if(actionCommand.equals("Open")) {
			view.open();
		}
	}

}
