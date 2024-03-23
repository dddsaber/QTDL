package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.GiaoVienTabListener;
import controller.HocSinhTabListener;
import model.Diem;
import model.DiemModel;
import model.GiaoVien;
import model.GiaoVienModel;
import model.HocSinh;
import model.HocSinhModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class QLHS extends JFrame {

	// DAO Object Attributes
	private GiaoVienModel gvModel;
	private HocSinhModel hsModel;
	private DiemModel diemModel;
	// View Object Attributes
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableThongTinGV;
	private JTable tableChuNhiem;
	private JTextField textFieldMaGVTimKiem;
	private JTextField textFieldTimKiemHoTenGV;
	private JTextField textFieldTimKiemDiaChiGV;
	private JTable tableThongTinPhong;
	private JTable tableThongTinLop;
	private JTextField textFieldMaPhong;
	private JTextField textFieldSoCho;
	private JTextField textFieldSoPhong;
	private JTextField textFieldMaPhong_Lop;
	private JTextField textFieldHocKyNamHoc;
	private JTextField textFieldMaLop;
	private JTextField textFieldTimKiemMaPhong;
	private JTextField textFieldTimKiemMaLop;
	private JTextField textFieldMaGV;
	private JTextField textFieldNgaySinhGV;
	private JTextField textFieldHoTenGV;
	private JTextField textFieldSoDienThoaiGV;
	private JTextField textFieldMaHSTimKiem;
	private JTextField textFieldHoTenHSTimKiem;
	private JTextField textFieldMaLopHSTimKiem;
	private JTextField textFieldMaHS;
	private JTextField textFieldNgaySinhHS;
	private JTextField textFieldHoTenHS;
	private JTextField textFieldSDTPhuHuynh;
	private JTextField textFieldMaLopHS;
	private JTable tableHocSinh;

	private JTable tableThongTinDiem;
	private JTextField textFieldsoDienThoaiGV;

	private JTextArea textAreaDiaChiHS;

	private JTextArea textAreaDiaChiGV;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLHS frame = new QLHS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLHS() {
		this.gvModel = new GiaoVienModel();
		this.hsModel = new HocSinhModel();
		this.diemModel = new DiemModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 860, 32);
		contentPane.add(menuBar);

		JMenu JMenuAccount = new JMenu("Tài khoản");
		menuBar.add(JMenuAccount);

		JMenu JMenuData = new JMenu("New menu");
		menuBar.add(JMenuData);
//		Các tab bắt đầu từ đây
		/*
		 * 
		 */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(0, 30, 865, 469);
		contentPane.add(tabbedPane);

		/*
		 * Tab giáo viên bắt đầu từ đây TEACHER START
		 */

		GiaoVienTabListener gvtl = new GiaoVienTabListener(this);

		JPanel panelTeacher = new JPanel();
		tabbedPane.addTab("Giáo viên", null, panelTeacher, null);
		panelTeacher.setLayout(null);

		JScrollPane scrollPaneThongTinGiaoVien = new JScrollPane();
		scrollPaneThongTinGiaoVien.setBounds(10, 187, 505, 266);
		panelTeacher.add(scrollPaneThongTinGiaoVien);

		tableThongTinGV = new JTable();
		tableThongTinGV.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 gi\u00E1o vi\u00EAn", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh",
						"\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i" }));
		tableThongTinGV.getColumnModel().getColumn(0).setPreferredWidth(52);
		scrollPaneThongTinGiaoVien.setViewportView(tableThongTinGV);

		JScrollPane scrollPaneThongTinGiaoVienClass = new JScrollPane();
		scrollPaneThongTinGiaoVienClass.setBounds(525, 235, 219, 218);
		panelTeacher.add(scrollPaneThongTinGiaoVienClass);

		JLabel lblNewLabel_2 = new JLabel("Chủ nhiệm");
		scrollPaneThongTinGiaoVienClass.setColumnHeaderView(lblNewLabel_2);

		tableChuNhiem = new JTable();
		tableChuNhiem.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Mã giáo viên", "Mã lớp", "Năm học" }));
		scrollPaneThongTinGiaoVienClass.setViewportView(tableChuNhiem);

		JLabel lblNewLabel_3 = new JLabel("Chủ nhiệm");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(525, 204, 219, 29);
		panelTeacher.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Tìm kiếm");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setAlignmentX(0.5f);
		lblNewLabel_3_1.setBounds(520, 3, 219, 20);
		panelTeacher.add(lblNewLabel_3_1);

		textFieldMaGVTimKiem = new JTextField();
		textFieldMaGVTimKiem.setBounds(618, 42, 86, 20);
		panelTeacher.add(textFieldMaGVTimKiem);
		textFieldMaGVTimKiem.setColumns(10);

		textFieldTimKiemHoTenGV = new JTextField();
		textFieldTimKiemHoTenGV.setBounds(618, 73, 86, 20);
		panelTeacher.add(textFieldTimKiemHoTenGV);
		textFieldTimKiemHoTenGV.setColumns(10);

		JLabel lblSearchTeacherCode = new JLabel("Mã giáo viên");
		lblSearchTeacherCode.setBounds(518, 42, 60, 20);
		panelTeacher.add(lblSearchTeacherCode);

		JLabel lblSearchTeacherName = new JLabel("Họ tên");
		lblSearchTeacherName.setBounds(518, 73, 60, 20);
		panelTeacher.add(lblSearchTeacherName);

		JButton btnTimKiemGV = new JButton("Tìm kiếm");
		btnTimKiemGV.addActionListener(gvtl);
		btnTimKiemGV.setBounds(551, 135, 89, 23);
		panelTeacher.add(btnTimKiemGV);

		JLabel lblSearchTeacherAddress = new JLabel("Địa chỉ");
		lblSearchTeacherAddress.setBounds(518, 104, 60, 20);
		panelTeacher.add(lblSearchTeacherAddress);

		textFieldTimKiemDiaChiGV = new JTextField();
		textFieldTimKiemDiaChiGV.setColumns(10);
		textFieldTimKiemDiaChiGV.setBounds(618, 104, 86, 20);
		panelTeacher.add(textFieldTimKiemDiaChiGV);

		JButton btnHuyTimGV = new JButton("Huỷ tìm");
		btnHuyTimGV.addActionListener(gvtl);
		btnHuyTimGV.setBounds(650, 135, 89, 23);
		panelTeacher.add(btnHuyTimGV);

		JLabel lblNewLabel = new JLabel("Danh sách giáo viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 156, 234, 20);
		panelTeacher.add(lblNewLabel);

		JLabel lblTeacherCode = new JLabel("Mã giáo viên");
		lblTeacherCode.setBounds(10, 31, 60, 20);
		panelTeacher.add(lblTeacherCode);

		JLabel lblTeacherName = new JLabel("Họ tên");
		lblTeacherName.setBounds(10, 62, 60, 20);
		panelTeacher.add(lblTeacherName);

		JLabel lblTeacherDate = new JLabel("Ngày sinh");
		lblTeacherDate.setBounds(10, 93, 60, 20);
		panelTeacher.add(lblTeacherDate);

		JLabel lblTeacherPhone = new JLabel("Số điện thoại");
		lblTeacherPhone.setBounds(10, 124, 84, 20);
		panelTeacher.add(lblTeacherPhone);

		textFieldMaGV = new JTextField();
		textFieldMaGV.setColumns(10);
		textFieldMaGV.setBounds(84, 31, 86, 20);
		panelTeacher.add(textFieldMaGV);

		textFieldNgaySinhGV = new JTextField();
		textFieldNgaySinhGV.setColumns(10);
		textFieldNgaySinhGV.setBounds(84, 93, 86, 20);
		panelTeacher.add(textFieldNgaySinhGV);

		textFieldHoTenGV = new JTextField();
		textFieldHoTenGV.setColumns(10);
		textFieldHoTenGV.setBounds(84, 62, 86, 20);
		panelTeacher.add(textFieldHoTenGV);

		textFieldSoDienThoaiGV = new JTextField();
		textFieldSoDienThoaiGV.setColumns(10);
		textFieldSoDienThoaiGV.setBounds(84, 124, 86, 20);
		panelTeacher.add(textFieldSoDienThoaiGV);

		JLabel lblTeacherAddress = new JLabel("Địa chỉ");
		lblTeacherAddress.setBounds(223, 34, 95, 14);
		panelTeacher.add(lblTeacherAddress);

		JButton btnChonGV = new JButton("Chọn");
		btnChonGV.addActionListener(gvtl);
		btnChonGV.setBounds(369, 30, 89, 23);
		panelTeacher.add(btnChonGV);

		JButton btnLuuGV = new JButton("Lưu");
		btnLuuGV.addActionListener(gvtl);
		btnLuuGV.setBounds(369, 61, 89, 23);
		panelTeacher.add(btnLuuGV);

		JButton btnXoaGV = new JButton("Xoá");
		btnXoaGV.addActionListener(gvtl);
		btnXoaGV.setBounds(369, 92, 89, 23);
		panelTeacher.add(btnXoaGV);

		JButton btnTaoMoiGV = new JButton("Tạo mới");
		btnTaoMoiGV.addActionListener(gvtl);
		btnTaoMoiGV.setBounds(369, 123, 89, 23);
		panelTeacher.add(btnTaoMoiGV);

		JLabel lblNewLabel_3_1_1 = new JLabel("Thông tin giáo viên");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1.setAlignmentX(0.5f);
		lblNewLabel_3_1_1.setBounds(140, 3, 219, 20);
		panelTeacher.add(lblNewLabel_3_1_1);

		textFieldsoDienThoaiGV = new JTextField();
		textFieldsoDienThoaiGV.setColumns(10);
		textFieldsoDienThoaiGV.setBounds(84, 124, 86, 20);
		panelTeacher.add(textFieldsoDienThoaiGV);

		textAreaDiaChiGV = new JTextArea();
		textAreaDiaChiGV.setBounds(208, 60, 130, 76);
		panelTeacher.add(textAreaDiaChiGV);

		/*
		 * Tab giáo viên kết thúc ở đây TEACHER END
		 */

		/*
		 * Tab học sinh bắt đầu từ đây STUDENT START
		 */
		HocSinhTabListener hstl = new HocSinhTabListener(this);
		
		JPanel panelStudent = new JPanel();
		tabbedPane.addTab("Học sinh", null, panelStudent, null);
		panelStudent.setLayout(null);

//		JPanel panelStudent = new JPanel();
//		panelStudent.setLayout(null);
//		panelStudent.setBounds(0, 0, 754, 464);
//		panelStudent.add(panelStudent);

		tableHocSinh = new JTable();
		tableHocSinh.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Mã học sinh", "Họ tên",
				"Ngày sinh", "Địa chỉ", "SDT Phụ huynh", "Mã lớp", "Tên lớp" }));

		JScrollPane scrollPaneThongTinHocSinh = new JScrollPane(tableHocSinh);
		scrollPaneThongTinHocSinh.setBounds(10, 187, 729, 266);
		panelStudent.add(scrollPaneThongTinHocSinh);

		JLabel lblNewLabel_3_1_2 = new JLabel("Tìm kiếm");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2.setAlignmentX(0.5f);
		lblNewLabel_3_1_2.setBounds(520, 3, 219, 20);
		panelStudent.add(lblNewLabel_3_1_2);

		textFieldMaHSTimKiem = new JTextField();
		textFieldMaHSTimKiem.setColumns(10);
		textFieldMaHSTimKiem.setBounds(618, 42, 86, 20);
		panelStudent.add(textFieldMaHSTimKiem);

		textFieldHoTenHSTimKiem = new JTextField();
		textFieldHoTenHSTimKiem.setColumns(10);
		textFieldHoTenHSTimKiem.setBounds(618, 73, 86, 20);
		panelStudent.add(textFieldHoTenHSTimKiem);

		JLabel lblSearchTeacherCode_1 = new JLabel("Mã học sinh");
		lblSearchTeacherCode_1.setBounds(518, 42, 60, 20);
		panelStudent.add(lblSearchTeacherCode_1);

		JLabel lblSearchTeacherName_1 = new JLabel("Họ tên");
		lblSearchTeacherName_1.setBounds(518, 73, 60, 20);
		panelStudent.add(lblSearchTeacherName_1);

		JButton btnTimKiemHS = new JButton("Tìm kiếm");
		btnTimKiemHS.addActionListener(hstl);
		btnTimKiemHS.setBounds(551, 135, 89, 23);
		panelStudent.add(btnTimKiemHS);

		JLabel lblSearchTeacherAddress_1 = new JLabel("Mã lớp");
		lblSearchTeacherAddress_1.setBounds(518, 104, 60, 20);
		panelStudent.add(lblSearchTeacherAddress_1);

		textFieldMaLopHSTimKiem = new JTextField();
		textFieldMaLopHSTimKiem.setColumns(10);
		textFieldMaLopHSTimKiem.setBounds(618, 104, 86, 20);
		panelStudent.add(textFieldMaLopHSTimKiem);

		JButton btnHuyTimHS = new JButton("Huỷ tìm");
		btnHuyTimHS.addActionListener(hstl);
		btnHuyTimHS.setBounds(650, 135, 89, 23);
		panelStudent.add(btnHuyTimHS);

		JLabel lblNewLabel_4 = new JLabel("Danh sách học sinh");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_4.setBounds(10, 156, 234, 20);
		panelStudent.add(lblNewLabel_4);

		JLabel lblMSinhVin = new JLabel("Mã học sinh");
		lblMSinhVin.setBounds(10, 31, 60, 20);
		panelStudent.add(lblMSinhVin);

		JLabel lblTeacherName_1 = new JLabel("Họ tên");
		lblTeacherName_1.setBounds(10, 62, 60, 20);
		panelStudent.add(lblTeacherName_1);

		JLabel lblTeacherDate_1 = new JLabel("Ngày sinh");
		lblTeacherDate_1.setBounds(10, 93, 60, 20);
		panelStudent.add(lblTeacherDate_1);

		JLabel lblTeacherPhone_1 = new JLabel("Số điện thoại");
		lblTeacherPhone_1.setBounds(10, 124, 84, 20);
		panelStudent.add(lblTeacherPhone_1);

		textFieldMaHS = new JTextField();
		textFieldMaHS.setColumns(10);
		textFieldMaHS.setBounds(84, 31, 86, 20);
		panelStudent.add(textFieldMaHS);

		textFieldNgaySinhHS = new JTextField();
		textFieldNgaySinhHS.setColumns(10);
		textFieldNgaySinhHS.setBounds(84, 93, 86, 20);
		panelStudent.add(textFieldNgaySinhHS);

		textFieldHoTenHS = new JTextField();
		textFieldHoTenHS.setColumns(10);
		textFieldHoTenHS.setBounds(84, 62, 86, 20);
		panelStudent.add(textFieldHoTenHS);

		textFieldSDTPhuHuynh = new JTextField();
		textFieldSDTPhuHuynh.setColumns(10);
		textFieldSDTPhuHuynh.setBounds(84, 124, 86, 20);
		panelStudent.add(textFieldSDTPhuHuynh);

		JLabel lblTeacherAddress_1 = new JLabel("Địa chỉ");
		lblTeacherAddress_1.setBounds(223, 34, 95, 14);
		panelStudent.add(lblTeacherAddress_1);

		JButton btnChonHS = new JButton("Chọn");
		btnChonHS.addActionListener(hstl);
		btnChonHS.setBounds(369, 30, 89, 23);
		panelStudent.add(btnChonHS);

		JButton btnLuuHS = new JButton("Lưu");
		btnLuuHS.addActionListener(hstl);
		btnLuuHS.setBounds(369, 61, 89, 23);
		panelStudent.add(btnLuuHS);

		JButton btnXoaHS = new JButton("Xoá");
		btnXoaHS.addActionListener(hstl);
		btnXoaHS.setBounds(369, 92, 89, 23);
		panelStudent.add(btnXoaHS);

		JButton btnTaoMoiHS = new JButton("Tạo mới");
		btnTaoMoiHS.addActionListener(hstl);
		btnTaoMoiHS.setBounds(369, 123, 89, 23);
		panelStudent.add(btnTaoMoiHS);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Thông tin học sinh");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1_1.setAlignmentX(0.5f);
		lblNewLabel_3_1_1_1.setBounds(140, 3, 219, 20);
		panelStudent.add(lblNewLabel_3_1_1_1);

		JScrollPane scrollPaneDiaChiHS = new JScrollPane();
		scrollPaneDiaChiHS.setBounds(198, 60, 161, 53);
		panelStudent.add(scrollPaneDiaChiHS);

		textAreaDiaChiHS = new JTextArea();
		scrollPaneDiaChiHS.setViewportView(textAreaDiaChiHS);

		JLabel lblMLp_1 = new JLabel("Mã lớp");
		lblMLp_1.setBounds(198, 124, 60, 20);
		panelStudent.add(lblMLp_1);

		textFieldMaLopHS = new JTextField();
		textFieldMaLopHS.setColumns(10);
		textFieldMaLopHS.setBounds(257, 125, 102, 20);
		panelStudent.add(textFieldMaLopHS);

		/*
		 * Tab học sinh kết thúc ở đây STUDENT END
		 */

		/*
		 * Tab quản lý điểm bắt đầu từ đây SCORE START
		 */

		JPanel panelScore = new JPanel();
		tabbedPane.addTab("Quản lý điểm", null, panelScore, null);
		panelScore.setLayout(null);

		tableThongTinDiem = new JTable();
		tableThongTinDiem.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "STT", "M\u00E3 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "T\u00EAn m\u00F4n",
						"\u0111i\u1EC3m mi\u1EC7ng", "15 ph\u00FAt", "1 ti\u1EBFt", "H\u1ECDc k\u1EF3" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, true, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableThongTinDiem.getColumnModel().getColumn(0).setPreferredWidth(52);

		JScrollPane scrollPaneThongTinDiemHocSinh = new JScrollPane(tableThongTinDiem);
		scrollPaneThongTinDiemHocSinh.setBounds(10, 187, 729, 266);
		panelScore.add(scrollPaneThongTinDiemHocSinh);

		JLabel lblNewLabel_4_1 = new JLabel("Danh sách điểm");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_4_1.setBounds(10, 156, 234, 20);
		panelScore.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Tìm kiếm");
		lblNewLabel_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2_1.setAlignmentX(0.5f);
		lblNewLabel_3_1_2_1.setBounds(274, 0, 219, 20);
		panelScore.add(lblNewLabel_3_1_2_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(287, 30, 86, 20);
		panelScore.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(287, 61, 86, 20);
		panelScore.add(textField_1);
		
		JLabel lblSearchTeacherCode_1_1 = new JLabel("Mã học sinh");
		lblSearchTeacherCode_1_1.setBounds(187, 30, 60, 20);
		panelScore.add(lblSearchTeacherCode_1_1);
		
		JLabel lblSearchTeacherName_1_1 = new JLabel("Họ tên");
		lblSearchTeacherName_1_1.setBounds(187, 61, 60, 20);
		panelScore.add(lblSearchTeacherName_1_1);
		
		JButton btnTimKiemHS_1 = new JButton("Tìm kiếm");
		btnTimKiemHS_1.setBounds(220, 123, 89, 23);
		panelScore.add(btnTimKiemHS_1);
		
		JLabel lblSearchTeacherAddress_1_1 = new JLabel("Mã lớp");
		lblSearchTeacherAddress_1_1.setBounds(187, 92, 60, 20);
		panelScore.add(lblSearchTeacherAddress_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(287, 92, 86, 20);
		panelScore.add(textField_2);
		
		JButton btnHuyTimHS_1 = new JButton("Huỷ tìm");
		btnHuyTimHS_1.setBounds(319, 123, 89, 23);
		panelScore.add(btnHuyTimHS_1);
		
		JLabel lblTeacherName_1_1_1 = new JLabel("Môn học");
		lblTeacherName_1_1_1.setBounds(407, 30, 60, 20);
		panelScore.add(lblTeacherName_1_1_1);
		
		String[] cacMonHoc = new String[] { "Toán", "Ngữ văn", "Anh văn", "Lịch sử", "Địa lý" };
		JComboBox<String> comboBoxTimKiemMonHoc = new JComboBox<String>(cacMonHoc);
		comboBoxTimKiemMonHoc.setBounds(470, 30, 86, 20);
		panelScore.add(comboBoxTimKiemMonHoc);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Lọc theo:");
		lblNewJgoodiesLabel.setBounds(534, 157, 60, 20);
		panelScore.add(lblNewJgoodiesLabel);
		
		String[] thuTuLocDiem = new String[] { "tb >= 8.0", "tb >= 6.5", "tb >= 5.0", "tb >= 3.0"};
		JComboBox<String> comboBox = new JComboBox<String>(thuTuLocDiem);
		comboBox.setBounds(587, 157, 80, 20);
		panelScore.add(comboBox);
		


		/*
		 * Tab quản lý điểm kết thúc ở đây SCORE END
		 */

		/*
		 * Tab quản lý phòng học bắt đầu từ đây CLASSROOM START
		 */

		JPanel panelClassroom = new JPanel();
		tabbedPane.addTab("Quản lý phòng học", null, panelClassroom, null);
		panelClassroom.setLayout(null);

		JScrollPane scrollPaneClassroom = new JScrollPane();
		scrollPaneClassroom.setBounds(10, 216, 375, 237);
		panelClassroom.add(scrollPaneClassroom);

		tableThongTinPhong = new JTable();
		tableThongTinPhong.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Mã phòng", "Số phòng", "Số chỗ tối đa" }));
		scrollPaneClassroom.setViewportView(tableThongTinPhong);

		JScrollPane scrollPaneClass = new JScrollPane();
		scrollPaneClass.setBounds(395, 216, 344, 237);
		panelClassroom.add(scrollPaneClass);

		tableThongTinLop = new JTable();
		tableThongTinLop.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Mã phòng", "Mã lớp", "Học kỳ - năm học" }));
		scrollPaneClass.setViewportView(tableThongTinLop);

		JButton btnChonPhong = new JButton("Chọn");
		btnChonPhong.setBounds(10, 126, 89, 23);
		panelClassroom.add(btnChonPhong);

		JButton btnLuuPhong = new JButton("Lưu");
		btnLuuPhong.setBounds(109, 126, 89, 23);
		panelClassroom.add(btnLuuPhong);

		JButton btnXoaPhong = new JButton("Xoá");
		btnXoaPhong.setBounds(10, 157, 89, 23);
		panelClassroom.add(btnXoaPhong);

		JButton btnChonMoiPhong = new JButton("Chọn mới");
		btnChonMoiPhong.setBounds(109, 157, 89, 23);
		panelClassroom.add(btnChonMoiPhong);

		JLabel lblClassroomCode = new JLabel("Mã phòng");
		lblClassroomCode.setBounds(10, 32, 60, 20);
		panelClassroom.add(lblClassroomCode);

		JLabel lblClassroomNumber = new JLabel("Số phòng");
		lblClassroomNumber.setBounds(10, 63, 60, 20);
		panelClassroom.add(lblClassroomNumber);

		JLabel lblClassroomSlots = new JLabel("Số chỗ tối đa");
		lblClassroomSlots.setBounds(10, 94, 64, 20);
		panelClassroom.add(lblClassroomSlots);

		textFieldMaPhong = new JTextField();
		textFieldMaPhong.setColumns(10);
		textFieldMaPhong.setBounds(80, 32, 86, 20);
		panelClassroom.add(textFieldMaPhong);

		textFieldSoCho = new JTextField();
		textFieldSoCho.setColumns(10);
		textFieldSoCho.setBounds(80, 94, 86, 20);
		panelClassroom.add(textFieldSoCho);

		textFieldSoPhong = new JTextField();
		textFieldSoPhong.setColumns(10);
		textFieldSoPhong.setBounds(80, 63, 86, 20);
		panelClassroom.add(textFieldSoPhong);

		JButton btnChonLop = new JButton("Chọn");
		btnChonLop.setBounds(246, 126, 89, 23);
		panelClassroom.add(btnChonLop);

		JButton btnLuuLop = new JButton("Lưu");
		btnLuuLop.setBounds(345, 126, 89, 23);
		panelClassroom.add(btnLuuLop);

		JButton btnXoaLop = new JButton("Xoá");
		btnXoaLop.setBounds(246, 157, 89, 23);
		panelClassroom.add(btnXoaLop);

		JButton btnChonMoiLop = new JButton("Chọn mới");
		btnChonMoiLop.setBounds(345, 157, 89, 23);
		panelClassroom.add(btnChonMoiLop);

		JLabel lblClassRoomCode = new JLabel("Mã phòng");
		lblClassRoomCode.setBounds(246, 32, 60, 20);
		panelClassroom.add(lblClassRoomCode);

		JLabel lblClassClassCode = new JLabel("Mã lớp");
		lblClassClassCode.setBounds(246, 63, 60, 20);
		panelClassroom.add(lblClassClassCode);

		JLabel lblClassYear = new JLabel("Học kỳ - năm học");
		lblClassYear.setBounds(246, 94, 89, 20);
		panelClassroom.add(lblClassYear);

		textFieldMaPhong_Lop = new JTextField();
		textFieldMaPhong_Lop.setColumns(10);
		textFieldMaPhong_Lop.setBounds(348, 32, 86, 20);
		panelClassroom.add(textFieldMaPhong_Lop);

		textFieldHocKyNamHoc = new JTextField();
		textFieldHocKyNamHoc.setColumns(10);
		textFieldHocKyNamHoc.setBounds(348, 94, 86, 20);
		panelClassroom.add(textFieldHocKyNamHoc);

		textFieldMaLop = new JTextField();
		textFieldMaLop.setColumns(10);
		textFieldMaLop.setBounds(348, 63, 86, 20);
		panelClassroom.add(textFieldMaLop);

		JButton btnTimKiemLop = new JButton("Tìm kiếm");
		btnTimKiemLop.setBounds(497, 126, 89, 23);
		panelClassroom.add(btnTimKiemLop);

		JButton btnHuyTimLop = new JButton("Huỷ tìm");
		btnHuyTimLop.setBounds(596, 126, 89, 23);
		panelClassroom.add(btnHuyTimLop);

		JLabel lblClassroomCode_2 = new JLabel("Mã phòng");
		lblClassroomCode_2.setBounds(497, 32, 60, 20);
		panelClassroom.add(lblClassroomCode_2);

		JLabel lblMLp = new JLabel("Mã lớp");
		lblMLp.setBounds(497, 63, 60, 20);
		panelClassroom.add(lblMLp);

		textFieldTimKiemMaPhong = new JTextField();
		textFieldTimKiemMaPhong.setColumns(10);
		textFieldTimKiemMaPhong.setBounds(567, 32, 86, 20);
		panelClassroom.add(textFieldTimKiemMaPhong);

		textFieldTimKiemMaLop = new JTextField();
		textFieldTimKiemMaLop.setColumns(10);
		textFieldTimKiemMaLop.setBounds(567, 63, 86, 20);
		panelClassroom.add(textFieldTimKiemMaLop);

		JLabel lblNewLabel_1 = new JLabel("Thông tin phòng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(22, 7, 156, 23);
		panelClassroom.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Thông tin lớp");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(255, 9, 156, 21);
		panelClassroom.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tìm kiếm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(507, 7, 156, 23);
		panelClassroom.add(lblNewLabel_1_2);
		/*
		 * Tab quản lý phòng học kết thúc ở đây CLASSROOM END
		 */

		this.setVisible(true);
	}

	/*
	 * CÁC PHƯƠNG THỨC LIÊN QUAN TAB GIÁO VIÊN
	 * 
	 * START
	 */
	public void xoaTextFieldGV() {
		this.textFieldMaGV.setText("");
		this.textFieldHoTenGV.setText("");
		this.textFieldNgaySinhGV.setText("");
		this.textFieldSoDienThoaiGV.setText("");
		this.textAreaDiaChiGV.setText("");
	}

	public void luuDuLieuGVtuInput() {
		// Lay du lieu giao vien tu cac textField va textArea de thuc thi cac thao tac
		// them/sua dl
		String maGV = new String(this.textFieldMaGV.getText());
		String hotenGV = new String(this.textFieldHoTenGV.getText());
		Date ngaySinhGV = new Date(this.textFieldNgaySinhGV.getText());
		String diaChiGV = new String(this.textAreaDiaChiGV.getText().toString());
		String soDienThoaiGV = new String(this.textFieldSoDienThoaiGV.getText());
		GiaoVien gv = new GiaoVien(maGV, hotenGV, ngaySinhGV, diaChiGV, soDienThoaiGV);
		this.themGV(gv);
	}

	public void themGV(GiaoVien gv) {
		DefaultTableModel mode = (DefaultTableModel) tableThongTinGV.getModel();
		if (!this.gvModel.daTonTai(gv)) {
			// Them gv vao bang thong tin & csdl neu giao vien chua ton tai
			this.gvModel.insert(gv);
			this.themGVvaoBangDL(gv);
		} else {
			// Chinh sua du lieu giao vien neu giao vien da ton tai
			this.gvModel.update(gv);
			int soLuongDong = mode.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = mode.getValueAt(i, 1).toString();
				if (id.equals(gv.getMaGV())) {
					mode.setValueAt(gv.getMaGV(), i, 1);
					mode.setValueAt(gv.getHoTenGV(), i, 2);
					mode.setValueAt(gv.getNgaySinhGV().getDate() + "/" + (gv.getNgaySinhGV().getMonth() + 1) + "/"
							+ (gv.getNgaySinhGV().getYear() + 1900) + "", i, 3);
					mode.setValueAt(gv.getDiaChiGV(), i, 4);
					mode.setValueAt(gv.getSoDienThoaiGV(), i, 5);

				}
			}
		}
	}

	private void themGVvaoBangDL(GiaoVien gv) {
		DefaultTableModel mode = (DefaultTableModel) tableThongTinGV.getModel();
		// Them 1 hang co du lieu la "GiaoVien gv"
		mode.addRow(new Object[] { this.gvModel.getDsGiaoVien().lastIndexOf(gv) + 1, gv.getMaGV(), gv.getHoTenGV(),
				gv.getNgaySinhGV().getDate() + "/" + (gv.getNgaySinhGV().getMonth() + 1) + "/"
						+ (gv.getNgaySinhGV().getYear() + 1900),
				gv.getDiaChiGV(), gv.getSoDienThoaiGV() });
	}

	public GiaoVien layThongTinGVDangChon() {
		DefaultTableModel mode = (DefaultTableModel) this.tableThongTinGV.getModel();
		int i_row = this.tableThongTinGV.getSelectedRow();

		String maGV = mode.getValueAt(i_row, 1).toString();
		String hoTenGV = mode.getValueAt(i_row, 2).toString();
		Date ngaySinhGV = new Date(mode.getValueAt(i_row, 3).toString());
		String diaChiGV = mode.getValueAt(i_row, 4).toString();
		String soDienThoaiGV = mode.getValueAt(i_row, 5).toString();

		GiaoVien gv = new GiaoVien(maGV, hoTenGV, ngaySinhGV, diaChiGV, soDienThoaiGV);
		return gv;
	}

	public void hienThiThongTinGVDangChon() {
		GiaoVien gv = this.layThongTinGVDangChon();

		this.textFieldMaGV.setText(gv.getMaGV());
		this.textFieldHoTenGV.setText(gv.getHoTenGV());
		String s_ngaySinh = gv.getNgaySinhGV().getDate() + "/" + gv.getNgaySinhGV().getMonth() + "/"
				+ (gv.getNgaySinhGV().getYear() + 1900);
		this.textFieldNgaySinhGV.setText(s_ngaySinh);
		this.textAreaDiaChiGV.setText(gv.getDiaChiGV());
		this.textFieldSoDienThoaiGV.setText(gv.getSoDienThoaiGV());

	}

	public void xoaGV() {
		DefaultTableModel mode = (DefaultTableModel) this.tableThongTinGV.getModel();
		int i_row = this.tableThongTinGV.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,
				"Bạn có chắc muốn xoá giáo viên này ra khỏi cơ sở dữ liệu không?");

		if (luaChon == JOptionPane.YES_OPTION) {
			GiaoVien gv = layThongTinGVDangChon();
			this.gvModel.delete(gv);
			mode.removeRow(i_row);
		}

	}

//	public void tim() {
//		this.huytim();
//		DefaultTableModel mode = (DefaultTableModel) table.getModel();
//		String mSSV = this.textField_TimKiemMSSV.getText();
//		System.out.println(mSSV.length());
//		int queQuan = this.comboBox_TimKiemTinh.getSelectedIndex()-1;
//		int soLuongDong = mode.getRowCount();
//		Tinh tinh = Tinh.getTinhbyId(queQuan);
//		int tmp = 0;
//		int check = 0;
//		for(int i = 0; i < soLuongDong; i++) {
//			check = 0;
//			String mssv = mode.getValueAt(tmp, 1).toString();
//			String tenTinhTable = mode.getValueAt(tmp, 4).toString();
//			
//			if(mSSV.length() > 0 && !mssv.equals(mSSV)) {
//				System.out.println(1);
//				try {
//					mode.removeRow(tmp);
//					check = 1;
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			else if(tinh != null && !tenTinhTable.equals(tinh.getTenTinh())) {
//				System.out.println(2);
//				try {
//						mode.removeRow(tmp);
//						check = 1;
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if(check == 0)
//				tmp++;
//		}
//		
//	}

	public void huytimGV() {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableThongTinGV.getModel();
			int soLuongDong = mode.getRowCount();
			if (soLuongDong == 0)
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
		for (GiaoVien gv : this.gvModel.getDsGiaoVien()) {
			this.themGVvaoBangDL(gv);
		}
	}

	public void aboutMe() {
		JOptionPane.showMessageDialog(this, "Phan mem quan ly thi sinh 1.1");
	}

	public void exit() {
		int option = JOptionPane.showConfirmDialog(this, "Thoat khoi chuong trinh?", "Exit", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void openDL() {
		try {
			ArrayList<GiaoVien> ds = new ArrayList<GiaoVien>();
			ds = (ArrayList<GiaoVien>) this.gvModel.getGiaoVienDAO().selectAll();
			this.gvModel.setDsGiaoVien(ds);
			System.out.println(ds);
			huytimGV();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * CÁC PHƯƠNG THỨC LIÊN QUAN ĐẾN TAB ĐIỂM
	 * 
	 * 
	 */
//	public void xoaTextFieldDiem() {
//		this.textFieldQLDiemMaHS.setText("");
//		this.textFieldSoDiem.setText("");
//	}

	public void layDuLieuTuBang() {
		DefaultTableModel mode = (DefaultTableModel) tableThongTinDiem.getModel();
		int soDong = mode.getRowCount();

		ArrayList<Diem> dsDiem = new ArrayList<Diem>();

		for (int i = 0; i < soDong; i++) {
			String maHS = mode.getValueAt(i, 1).toString();
			String maMonHoc = mode.getValueAt(i, 3).toString();
			// Tam thoi de Ma Mon, se chinh lai sau
			Float diemMieng = Float.valueOf(mode.getValueAt(i, 4).toString());
			Float diem15p = Float.valueOf(mode.getValueAt(i, 5).toString());
			Float diem1Tiet = Float.valueOf(mode.getValueAt(i, 6).toString());
			Float diemHocKy = Float.valueOf(mode.getValueAt(i, 7).toString());

			Diem tmp = new Diem(maHS, maMonHoc, diemMieng, diem15p, diem1Tiet, diemHocKy);
			dsDiem.add(tmp);
		}
		
		this.diemModel.setdsDiem(dsDiem);
	}

	private void huytimDiem() {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableThongTinDiem.getModel();
			int soLuongDong = mode.getRowCount();
			if (soLuongDong == 0)
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
		for (Diem diem : this.diemModel.getdsDiem()) {
			this.themDiemVaoTable(diem);
		}
		
	}
	/*
	 * THÊM ĐIỂM VÀO TABLE CHƯA CÓ TÊN HỌC SINH
	 * 
	 */
	private void themDiemVaoTable(Diem diem) {
		DefaultTableModel mode = (DefaultTableModel) tableThongTinDiem.getModel();
		// Them 1 hang co du lieu la "GiaoVien gv"
		mode.addRow(new Object[] { this.diemModel.getdsDiem().lastIndexOf(diem) + 1, diem.getMaHS(), diem.getMaHS(),
				diem.getMaMonHoc(), diem.getDiemMieng(),diem.getDiem15Phut(), diem.getDiem1Tiet(), diem.getDiemHocKy() });
		
	}
	
	/*
	 * CÁC PHƯƠNG THỨC LIÊN QUAN ĐẾN TAB HỌC SINH BẮT ĐẦU Ở ĐÂY
	 * 
	 * 
	 */
	
	public void xoaTextFieldHS() {
		textFieldMaHS.setText("");
		textFieldHoTenHS.setText("");
		textFieldNgaySinhHS.setText("");
		textFieldSDTPhuHuynh.setText("");
		textAreaDiaChiHS.setText("");
		textFieldMaLopHS.setText("");
	}

	public void xoaHS() {
		// TODO Auto-generated method stub
		DefaultTableModel mode = (DefaultTableModel) this.tableHocSinh.getModel();
		int i_row = this.tableHocSinh.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,
				"Bạn có chắc muốn xoá Học sinh này ra khỏi cơ sở dữ liệu không?");

		if (luaChon == JOptionPane.YES_OPTION) {
			HocSinh hs = layThongTinHSDangChon();
			this.hsModel.delete(hs);
			mode.removeRow(i_row);
		}
	}

	private HocSinh layThongTinHSDangChon() {
		DefaultTableModel mode = (DefaultTableModel) this.tableHocSinh.getModel();
		int i_row = this.tableHocSinh.getSelectedRow();

		String maHS = mode.getValueAt(i_row, 1).toString();
		String hoTenHS = mode.getValueAt(i_row, 2).toString();
		Date ngaySinhHS = new Date(mode.getValueAt(i_row, 3).toString());
		String diaChiHS = mode.getValueAt(i_row, 4).toString();
		String soDienThoaiPH = mode.getValueAt(i_row, 5).toString();
		String maLop = mode.getValueAt(i_row, 6) != null ? mode.getValueAt(i_row, 6).toString() : "";
		HocSinh hs = new HocSinh(maHS, hoTenHS, ngaySinhHS, diaChiHS, soDienThoaiPH, maLop);
		return hs;
	}

	public void luuDuLieuHStuInput() {
		// TODO Auto-generated method stub
		String maHS = new String(this.textFieldMaHS.getText());
		String hoTenHS = new String(this.textFieldHoTenHS.getText());
		Date ngaySinhHS = new Date(this.textFieldNgaySinhHS.getText());
		String diaChiHS = new String(this.textAreaDiaChiHS.getText().toString());
		String soDienThoaiPH = new String(this.textFieldSDTPhuHuynh.getText());
		String maLop = new String(this.textFieldMaLopHS.getText());
		HocSinh hs = new HocSinh(maHS, hoTenHS, ngaySinhHS, diaChiHS, soDienThoaiPH, maLop);
		this.themHS(hs);
	}
	
	public void themHS(HocSinh hs) {
		DefaultTableModel mode = (DefaultTableModel) tableHocSinh.getModel();
		if (!this.hsModel.daTonTai(hs)) {
//			Thêm hs vào bảng thông tin và CSDL nếu học sinh chưa được tạo
			this.hsModel.insert(hs);
			this.themHSvaoBangDL(hs);
		} else {
//			Chỉnh sửa dữ liệu giáo viên nếu giáo viên đã tồn tại
			this.hsModel.update(hs);
			int soLuongDong = mode.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = mode.getValueAt(i, 1).toString();
				if (id.equals(hs.getMaHS())) {
					mode.setValueAt(hs.getMaHS(), i, 1);
					mode.setValueAt(hs.getHoTenHS(), i, 2);
					mode.setValueAt(hs.getNgaySinhHS().getDate() + "/" + (hs.getNgaySinhHS().getMonth() + 1) + "/"
							+ (hs.getNgaySinhHS().getYear() + 1900) + "", i, 3);
					mode.setValueAt(hs.getDiaChiHS(), i, 4);
					mode.setValueAt(hs.getSDTPhuHuynhHS(), i, 5);

				}
			}
		}
	}
	
	private void themHSvaoBangDL(HocSinh hs) {
		DefaultTableModel mode = (DefaultTableModel) tableHocSinh.getModel();
		// Them 1 hang co du lieu la "GiaoVien gv"
		mode.addRow(new Object[] { this.hsModel.getDsHocSinh().lastIndexOf(hs) + 1, hs.getMaHS(), hs.getHoTenHS(),
				hs.getNgaySinhHS().getDate() + "/" + (hs.getNgaySinhHS().getMonth() + 1) + "/"
						+ (hs.getNgaySinhHS().getYear() + 1900),
				hs.getDiaChiHS(), hs.getSDTPhuHuynhHS() });
	}

	public void hienThiThongTinHSDangChon() {
		// TODO Auto-generated method stub
		HocSinh hs = this.layThongTinHSDangChon();

		this.textFieldMaGV.setText(hs.getMaHS());
		this.textFieldHoTenGV.setText(hs.getHoTenHS());
		String s_ngaySinh = hs.getNgaySinhHS().getDate() + "/" + hs.getNgaySinhHS().getMonth() + "/"
				+ (hs.getNgaySinhHS().getYear() + 1900);
		this.textFieldNgaySinhGV.setText(s_ngaySinh);
		this.textAreaDiaChiGV.setText(hs.getDiaChiHS());
		this.textFieldSoDienThoaiGV.setText(hs.getSDTPhuHuynhHS());
		this.textFieldMaLopHS.setText(hs.getMaLop());
	}

	public void huytimHS() {
		// Xoa hết kết quả tìm kiếm trong bảng
		textFieldMaHSTimKiem.setText("");
		textFieldHoTenHSTimKiem.setText("");
		textFieldMaLopHSTimKiem.setText("");
		DefaultTableModel mode = (DefaultTableModel) tableHocSinh.getModel();
		int rowCount = mode.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			mode.removeRow(i);
		}
	}

	public void timHS() {
		// TODO Auto-generated method stub
		String maHS = new String(textFieldMaHSTimKiem.getText());
		String hoTen = new String(textFieldHoTenHSTimKiem.getText());
		String maLop = new String(textFieldMaLopHSTimKiem.getText());
		if(maHS.isEmpty() && hoTen.isEmpty() && maLop.isEmpty()) {
			JOptionPane.showMessageDialog(tableHocSinh, "Vui lòng nhập ít nhất 1 trường", "Lỗi",JOptionPane.ERROR_MESSAGE);
		}else {
			ArrayList<HocSinh> result = this.hsModel.findByInFor(maHS, hoTen, maLop);
			for (HocSinh hocSinh : result) {
				themHSvaoBangDL(hocSinh);
			}
		}	
	}
	
	/*
	 * CÁC PHƯƠNG THỨC LIÊN QUAN ĐẾN TAB HỌC SINH KẾT THỨC Ở ĐÂY
	 * 
	 * 
	 */
	
	
}
