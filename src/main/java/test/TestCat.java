package test;

import java.util.Date;

import javax.swing.UIManager;

import dao.ThiSinhDAO;
import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class TestCat {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		//	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new QLSVView();
//		ThiSinhDAO tsdao = new ThiSinhDAO();
//		
//		ThiSinh ts = new ThiSinh(1001,"Nguyen Van",new Tinh(84, "Trà Vinh"), new java.sql.Date(100, 2, 2), false ,(float)9.0,(float)9.0,(float)10.0);
//		
//		tsdao.saveOrUpdate(ts);
	}

}
