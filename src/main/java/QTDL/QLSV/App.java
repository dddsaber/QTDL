package QTDL.QLSV;

import javax.swing.UIManager;

import view.QLDangNhap;
import view.QLHS;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		//	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
        QLDangNhap app = new QLDangNhap();
        
    }
}
