package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.ScrollPane;
import java.awt.Window;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QLSVListener;

import javax.swing.JScrollPane;
import java.awt.Label;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class QLSVView extends JFrame {
	private QLSVModel model;
	private JPanel contentPane;
	private JTextField textField_TimKiemMSSV;
	private JTable table;
	private JTextField textField_MSSV;
	private JTextField textField_HoTen;
	private JTextField textField_NgaySinh;
	private JTextField textField_Toan;
	private JTextField textField_Van;
	private JTextField textField_AnhVan;
	private ButtonGroup btg;
	private JComboBox comboBox_ChinhSuaTinh;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JComboBox comboBox_TimKiemTinh;

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
//		this.model.setDsThiSinh(this.model.getTsDAO().selectAll());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 535);
		
		ActionListener action = new QLSVListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("Connect CSDL");
		menuFile.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		menuBar.add(menuFile);
		
		JMenuItem menuItemOpen = new JMenuItem("Open");
		menuItemOpen.addActionListener(action);
		menuFile.add(menuItemOpen);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		menuItemSave.addActionListener(action);
		menuFile.add(menuItemSave);
		
		JSeparator separator_1 = new JSeparator();
		menuFile.add(separator_1);
		
		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(action);
		menuFile.add(menuItemExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(action);
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTinh = new JLabel("Tinh");
		lblTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinh.setBounds(10, 11, 51, 30);
		contentPane.add(lblTinh);
		
		JLabel lblMSSV = new JLabel("MSSV");
		lblMSSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSSV.setBounds(259, 11, 54, 30);
		contentPane.add(lblMSSV);
		
		textField_TimKiemMSSV = new JTextField();
		textField_TimKiemMSSV.setColumns(10);
		textField_TimKiemMSSV.setBounds(316, 13, 113, 30);
		contentPane.add(textField_TimKiemMSSV);
		
		comboBox_TimKiemTinh = new JComboBox();
		comboBox_TimKiemTinh.addItem("");
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for(Tinh tmp : listTinh) {
			comboBox_TimKiemTinh.addItem(tmp.getTenTinh());
		}
		comboBox_TimKiemTinh.setBounds(71, 13, 169, 30);
		contentPane.add(comboBox_TimKiemTinh);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 51, 604, 2);
		contentPane.add(separator_2);
		
		JLabel lblDSSinhVien = new JLabel("Danh Sach Thi Sinh");
		lblDSSinhVien.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblDSSinhVien.setBounds(10, 56, 160, 23);
		contentPane.add(lblDSSinhVien);
		
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "MSSV", "Ho ten", "Ngay sinh", "Tinh", "Gioi tinh", "Toan", "Van", "Anh van"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(10, 77, 604, 155);
		contentPane.add(scrollPane_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 243, 604, 2);
		contentPane.add(separator_3);
		
		Label lblThongTin = new Label("Thong tin thi sinh");
		lblThongTin.setFont(new Font("Arial", Font.ITALIC, 12));
		lblThongTin.setBounds(10, 250, 141, 23);
		contentPane.add(lblThongTin);
		
		JLabel lblMSSV_1 = new JLabel("MSSV");
		lblMSSV_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSSV_1.setBounds(10, 279, 54, 17);
		contentPane.add(lblMSSV_1);
		
		textField_MSSV = new JTextField();
		textField_MSSV.setColumns(10);
		textField_MSSV.setBounds(84, 279, 86, 20);
		contentPane.add(textField_MSSV);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(84, 312, 86, 20);
		contentPane.add(textField_HoTen);
		
		JLabel lblTinh_1 = new JLabel("Tinh");
		lblTinh_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinh_1.setBounds(10, 343, 48, 23);
		contentPane.add(lblTinh_1);
		
		comboBox_ChinhSuaTinh = new JComboBox();
		comboBox_ChinhSuaTinh.addItem("");
		for(Tinh tmp : listTinh) {
			comboBox_ChinhSuaTinh.addItem(tmp.getTenTinh());
		}
		comboBox_ChinhSuaTinh.setBounds(84, 342, 86, 22);
		contentPane.add(comboBox_ChinhSuaTinh);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(84, 375, 86, 20);
		contentPane.add(textField_NgaySinh);
		
		JLabel lblHoTen = new JLabel("Ho ten");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoTen.setBounds(10, 315, 54, 17);
		contentPane.add(lblHoTen);
		
		JLabel lblNgaySinh = new JLabel("Ngay sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgaySinh.setBounds(10, 377, 54, 17);
		contentPane.add(lblNgaySinh);
		
		JLabel lblGioiTinh = new JLabel("Gioi tinh");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioiTinh.setBounds(259, 279, 54, 17);
		contentPane.add(lblGioiTinh);
		
		JLabel lblToan = new JLabel("Toan");
		lblToan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblToan.setBounds(259, 315, 54, 17);
		contentPane.add(lblToan);
		
		JLabel lblVan = new JLabel("Van");
		lblVan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVan.setBounds(259, 343, 48, 23);
		contentPane.add(lblVan);
		
		JLabel lblAnhVan = new JLabel("Anh Van");
		lblAnhVan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnhVan.setBounds(259, 377, 54, 17);
		contentPane.add(lblAnhVan);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(333, 278, 62, 23);
		contentPane.add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nu");
		rdbtnNu.setBounds(397, 278, 62, 23);
		contentPane.add(rdbtnNu);
		
		textField_Toan = new JTextField();
		textField_Toan.setColumns(10);
		textField_Toan.setBounds(343, 312, 86, 20);
		contentPane.add(textField_Toan);
		
		textField_Van = new JTextField();
		textField_Van.setColumns(10);
		textField_Van.setBounds(343, 346, 86, 20);
		contentPane.add(textField_Van);
		
		textField_AnhVan = new JTextField();
		textField_AnhVan.setColumns(10);
		textField_AnhVan.setBounds(343, 375, 86, 20);
		contentPane.add(textField_AnhVan);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(action);
		btnXoa.setBounds(126, 425, 98, 35);
		contentPane.add(btnXoa);
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(action);
		btnThem.setBounds(10, 425, 98, 35);
		contentPane.add(btnThem);
		
		JButton btnCapNhat = new JButton("Cap nhat");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setBounds(241, 425, 98, 35);
		contentPane.add(btnCapNhat);
		
		
		btg = new ButtonGroup();
		btg.add(rdbtnNam);
		btg.add(rdbtnNu);
		
		JButton btnLuu = new JButton("Luu");
		btnLuu.addActionListener(action);
		
		btnLuu.setBounds(356, 425, 98, 35);
		contentPane.add(btnLuu);
		
		JButton btnHuy = new JButton("Huy");
		btnHuy.addActionListener(action);
		btnHuy.setBounds(479, 425, 98, 35);
		contentPane.add(btnHuy);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(10, 412, 604, 2);
		contentPane.add(separator_3_1);
		
		JButton btnTim = new JButton("Tim kiem");
		btnTim.addActionListener(action);
		btnTim.setBounds(445, 17, 73, 23);
		contentPane.add(btnTim);
		
		JButton btnBoTim = new JButton("Huy tim");
		btnBoTim.addActionListener(action);
		btnBoTim.setBounds(528, 17, 73, 23);
		contentPane.add(btnBoTim);
		
		this.setVisible(true);
	}
	
	public QLSVModel getModel() {
		return model;
	}

	public void them() {
		textField_MSSV.setText("");
		textField_HoTen.setText("");
		textField_NgaySinh.setText("");
		textField_Toan.setText("");
		textField_Van.setText("");
		textField_AnhVan.setText("");
		this.comboBox_ChinhSuaTinh.setSelectedIndex(-1);
		btg.clearSelection();
	}
	
	public void luu() {
		try {
			int maThiSinh = Integer.valueOf(this.textField_MSSV.getText());
			String tenThiSinh = this.textField_HoTen.getText();
			Tinh queQuan = new Tinh(Integer.valueOf(this.comboBox_ChinhSuaTinh.getSelectedIndex())-1, this.comboBox_ChinhSuaTinh.getSelectedItem().toString());
			Date ngaySinh = new Date(this.textField_NgaySinh.getText());
			boolean gioiTinh = true;
			if(rdbtnNu.isSelected())
				gioiTinh = false;
			float diemMon1 = Float.valueOf(this.textField_Toan.getText());
			float diemMon2 = Float.valueOf(this.textField_Van.getText());
			float diemMon3 = Float.valueOf(this.textField_AnhVan.getText());
			ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, queQuan, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
			themThiSinh(ts);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void themTSvaoTable(ThiSinh ts) {
		DefaultTableModel mode = (DefaultTableModel) table.getModel();
		mode.addRow(new Object[]{
				this.model.getDsThiSinh().lastIndexOf(ts)+1,
				ts.getMaThiSinh()+"",
				ts.getTenThiSinh(),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth()+1) + 
				"/" + (ts.getNgaySinh().getYear() + 1900 ),
				ts.getQueQuan().getTenTinh(),
				ts.getGioiTinh(),
				ts.getDiemMon1()+"",
				ts.getDiemMon2()+"",
				ts.getDiemMon3()+""}
				);
	}
	public void themThiSinh(ThiSinh ts) {
		DefaultTableModel mode = (DefaultTableModel) table.getModel();
		if(!this.model.daTonTai(ts)) {
			this.model.insert(ts);
			this.themTSvaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = mode.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String id = mode.getValueAt(i, 1).toString();
				if(id.equals(ts.getMaThiSinh()+"")) {
					mode.setValueAt(ts.getMaThiSinh(), i, 1);
					mode.setValueAt(ts.getTenThiSinh(),i, 2);
					mode.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
					mode.setValueAt(ts.getQueQuan().getTenTinh(), i, 4);
					mode.setValueAt(ts.getGioiTinh(), i, 5);
					mode.setValueAt(ts.getDiemMon1(), i, 6);
					mode.setValueAt(ts.getDiemMon2(), i, 7);
					mode.setValueAt(ts.getDiemMon3(), i, 8);
					
				}
			}
		}
	}

	public ThiSinh layThiSinhDangChon() {
		DefaultTableModel mode = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		int maThiSinh = Integer.valueOf(mode.getValueAt(i_row, 1).toString());
		String tenThiSinh = mode.getValueAt(i_row, 2).toString();
		Date ngaySinh = new Date(mode.getValueAt(i_row, 3).toString());
		String tenTinh = mode.getValueAt(i_row, 4).toString();
		Tinh queQuan = new Tinh(Tinh.getTinhbyTen(tenTinh));
		System.out.println(tenTinh);
		String chonGioiTinh = mode.getValueAt(i_row, 5).toString();
		boolean gioiTinh = chonGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(mode.getValueAt(i_row, 6).toString());
		float diemMon2 = Float.valueOf(mode.getValueAt(i_row, 7).toString());
		float diemMon3 = Float.valueOf(mode.getValueAt(i_row, 8).toString());
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, queQuan, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}
	
	public void capnhat() {
		ThiSinh ts = this.layThiSinhDangChon();
		
		this.textField_MSSV.setText(ts.getMaThiSinh()+"");
		this.textField_HoTen.setText(ts.getTenThiSinh());
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + ts.getNgaySinh().getMonth() + 
				"/" + (ts.getNgaySinh().getYear() + 1900 );
		if(ts.isGioiTinh())
			rdbtnNam.setSelected(true);
		else
			rdbtnNu.setSelected(true);
		this.textField_NgaySinh.setText(s_ngaySinh);
		this.comboBox_ChinhSuaTinh.setSelectedItem(ts.getQueQuan().getTenTinh());
		this.textField_Toan.setText(ts.getDiemMon1()+"");
		this.textField_Van.setText(ts.getDiemMon2()+"");
		this.textField_AnhVan.setText(ts.getDiemMon3()+"");
		
	}

	public void xoa() {
		DefaultTableModel mode = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Ban dang xoa thi sinh!");
		
		if(luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = layThiSinhDangChon();
			this.model.delete(ts);
			mode.removeRow(i_row);
		}
		
	}

	public void tim() {
		this.huytim();
		DefaultTableModel mode = (DefaultTableModel) table.getModel();
		String mSSV = this.textField_TimKiemMSSV.getText();
		System.out.println(mSSV.length());
		int queQuan = this.comboBox_TimKiemTinh.getSelectedIndex()-1;
		int soLuongDong = mode.getRowCount();
		Tinh tinh = Tinh.getTinhbyId(queQuan);
		int tmp = 0;
		int check = 0;
		for(int i = 0; i < soLuongDong; i++) {
			check = 0;
			String mssv = mode.getValueAt(tmp, 1).toString();
			String tenTinhTable = mode.getValueAt(tmp, 4).toString();
			
			if(mSSV.length() > 0 && !mssv.equals(mSSV)) {
				System.out.println(1);
				try {
					mode.removeRow(tmp);
					check = 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(tinh != null && !tenTinhTable.equals(tinh.getTenTinh())) {
				System.out.println(2);
				try {
						mode.removeRow(tmp);
						check = 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(check == 0)
				tmp++;
		}
		
	}

	public void huytim() {
		while(true) {
			DefaultTableModel mode = (DefaultTableModel) table.getModel();
			int soLuongDong = mode.getRowCount();
			if(soLuongDong == 0)
				break;
			else {
				try {
					mode.removeRow(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for(ThiSinh ts : this.model.getDsThiSinh()) {
			this.themTSvaoTable(ts);
		}
	}
	
	public void aboutMe() {
		JOptionPane.showMessageDialog(this, "Phan mem quan ly thi sinh 1.1");
	}
	
	public void exit() {
		int option = JOptionPane.showConfirmDialog(this, "Thoat khoi chuong trinh?", "Exit", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void open() {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		ds = (ArrayList<ThiSinh>) this.model.getTsDAO().selectAll();
		this.model.setDsThiSinh(ds);
		System.out.println(ds);
		huytim();
	}
	
}
