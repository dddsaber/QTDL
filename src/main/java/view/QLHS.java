package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

import controller.DiemTabListener;
import controller.GiaoVienTabListener;
import controller.HocSinhTabListener;
import controller.LopHocListener;
import controller.LopListener;
import controller.PhongListener;
import dao.ChuNhiemDAO;
import dao.HocSinhDAO;
import model.ChuNhiem;
import model.ChuNhiemModel;
import model.Diem;
import model.DiemModel;
import model.GiaoVien;
import model.GiaoVienModel;
import model.HocSinh;
import model.HocSinhModel;
import model.Lop;
import model.LopModel;
import model.MonHoc;
import model.MonHocModel;
import model.PhongHoc;
import model.PhongHocModel;
import model.PhongLop;
import model.PhongLopModel;
import model.ThiSinh;
import model.Tinh;
import model.XuatFileExcel;
import net.bytebuddy.asm.Advice.This;

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
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;

public class QLHS extends JFrame {

	// DAO Object Attributes
	private GiaoVienModel gvModel;
	private ChuNhiemModel cnModel;
	private DiemModel diemModel;
	private PhongHocModel phModel;
	private PhongLopModel plModel;
	private HocSinhModel hsModel;
	private MonHocModel mhModel;
	private LopModel lopModel;

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
	private JTextField textFieldMaPhongLop;
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
	private JTextField textFieldNhapDiemMaLop;
	private JComboBox comboBoxChonMonHoc;
	private JTextField textFieldTimDiemMaHS;
	private JTextField textFieldTimDiemTenHS;
	private JTextField textFieldMaLopHoc;
	private JTextField textFieldNienKhoaLopHoc;
	private JTextField textFieldTenLopHoc;
	private JTable tableLopHoc;
	private JTextField textFieldTimKiemMaLopHoc;
	private JTextField textFieldTImKiemTenLopHoc;
	private JTextField textFieldTimKiemNienKhoaLopHoc;
	private JTextField textNhapTenFileGV;
	private JTextField textNhapTenFileHS;
	private JTextField textNhapTenFileDiem;
	private JTextField textNhapTenFileLopHoc;

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
		this.diemModel = new DiemModel();
		this.cnModel = new ChuNhiemModel();
		this.phModel = new PhongHocModel();
		this.plModel = new PhongLopModel();
		this.hsModel = new HocSinhModel();
		this.mhModel = new MonHocModel();
		this.lopModel = new LopModel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 538);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 869, 32);
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
		tabbedPane.setBackground(new Color(224, 255, 255));
		tabbedPane.setBounds(0, 30, 869, 469);
		contentPane.add(tabbedPane);

		/*
		 * Tab giáo viên bắt đầu từ đây TEACHER START
		 */

		GiaoVienTabListener gvtl = new GiaoVienTabListener(this);

		JPanel panelTeacher = new JPanel();
		panelTeacher.setBackground(new Color(224, 255, 255));
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
		scrollPaneThongTinGiaoVienClass.setBounds(525, 201, 219, 218);
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
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_3.setBounds(525, 164, 219, 29);
		panelTeacher.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Tìm kiếm");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
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

		JButton btnCapNhatChuNhiem = new JButton("Cập nhật");
		btnCapNhatChuNhiem.addActionListener(gvtl);
		btnCapNhatChuNhiem.setBounds(592, 430, 89, 23);
		panelTeacher.add(btnCapNhatChuNhiem);
		
		JButton btnXuatFileGV = new JButton("Xuất File");
		btnXuatFileGV.addActionListener(gvtl);
		btnXuatFileGV.setBackground(SystemColor.activeCaption);
		btnXuatFileGV.setForeground(new Color(0, 0, 128));
		btnXuatFileGV.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnXuatFileGV.setBounds(174, 153, 89, 23);
		panelTeacher.add(btnXuatFileGV);
		
		textNhapTenFileGV = new JTextField();
		textNhapTenFileGV.setText("Nhập tên file");
		textNhapTenFileGV.setToolTipText("Nhập tên file");
		textNhapTenFileGV.setBounds(273, 156, 86, 20);
		panelTeacher.add(textNhapTenFileGV);
		textNhapTenFileGV.setColumns(10);

		/*
		 * Tab giáo viên kết thúc ở đây TEACHER END
		 */

		/*
		 * Tab học sinh bắt đầu từ đây STUDENT START
		 */
		ActionListener hstl = new HocSinhTabListener(this);

		JPanel panelStudent = new JPanel();
		panelStudent.setBackground(new Color(224, 255, 255));
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
		
		JButton btnXuatFileHS = new JButton("Xuất File");
		btnXuatFileHS.addActionListener(hstl);
		btnXuatFileHS.setForeground(new Color(0, 0, 128));
		btnXuatFileHS.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnXuatFileHS.setBackground(SystemColor.activeCaption);
		btnXuatFileHS.setBounds(198, 153, 89, 23);
		panelStudent.add(btnXuatFileHS);
		
		textNhapTenFileHS = new JTextField();
		textNhapTenFileHS.setToolTipText("Nhập tên file");
		textNhapTenFileHS.setText("Nhập tên file");
		textNhapTenFileHS.setColumns(10);
		textNhapTenFileHS.setBounds(297, 156, 86, 20);
		panelStudent.add(textNhapTenFileHS);

		/*
		 * Tab học sinh kết thúc ở đây STUDENT END
		 */

		/*
		 * Tab quản lý điểm bắt đầu từ đây SCORE START
		 */

		ActionListener diemltn = new DiemTabListener(this);

		JPanel panelScore = new JPanel();
		panelScore.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Quản lý điểm", null, panelScore, null);
		panelScore.setLayout(null);

		tableThongTinDiem = new JTable();
		tableThongTinDiem.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 h\u1ECDc sinh", "T\u00EAn H\u1ECDc Sinh", "M\u00E3 M\u00F4n",
						"T\u00EAn M\u00F4n", "\u0110i\u1EC3m mi\u1EC7ng", "15 ph\u00FAt", "1 Ti\u1EBFt",
						"H\u1ECDc K\u1EF3" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableThongTinDiem.getColumnModel().getColumn(0).setPreferredWidth(52);

		JScrollPane scrollPaneThongTinDiemHocSinh = new JScrollPane(tableThongTinDiem);
		scrollPaneThongTinDiemHocSinh.setBounds(21, 169, 723, 284);
		panelScore.add(scrollPaneThongTinDiemHocSinh);

		String[] cacMonHoc = new String[] { "Toán", "Ngữ văn", "Anh văn" };

		String[] thuTuLocDiem = new String[] { "tb >= 8.0", "tb >= 6.5", "b >= 5.0", "tb >= 3.0" };

		JLabel lblTeacherName_1_1_1 = new JLabel("Mã Lớp");
		lblTeacherName_1_1_1.setBounds(21, 38, 60, 20);
		panelScore.add(lblTeacherName_1_1_1);

		JLabel lblTeacherName_1_1_1_1 = new JLabel("Môn học");
		lblTeacherName_1_1_1_1.setBounds(195, 38, 60, 20);
		panelScore.add(lblTeacherName_1_1_1_1);

		comboBoxChonMonHoc = new JComboBox();
		comboBoxChonMonHoc.addItem("All");
		comboBoxChonMonHoc.addItem("Toán");
		comboBoxChonMonHoc.addItem("Ngoại Ngữ");
		comboBoxChonMonHoc.addItem("Ngữ Văn");
		comboBoxChonMonHoc.setToolTipText("Môn Học");
		comboBoxChonMonHoc.setBounds(258, 37, 80, 22);
		panelScore.add(comboBoxChonMonHoc);

		textFieldNhapDiemMaLop = new JTextField();
		textFieldNhapDiemMaLop.setColumns(10);
		textFieldNhapDiemMaLop.setBounds(82, 38, 86, 20);
		panelScore.add(textFieldNhapDiemMaLop);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Nhập điểm theo danh sách");
		lblNewLabel_3_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1_1_1.setAlignmentX(0.5f);
		lblNewLabel_3_1_1_1_1.setBounds(44, 7, 280, 20);
		panelScore.add(lblNewLabel_3_1_1_1_1);

		JButton btnlaydsDiem = new JButton("Lấy danh sách");
		btnlaydsDiem.addActionListener(diemltn);
		btnlaydsDiem.setBounds(81, 79, 124, 23);
		panelScore.add(btnlaydsDiem);

		JButton btnLuuDiem = new JButton("Lưu");
		btnLuuDiem.addActionListener(diemltn);
		btnLuuDiem.setBounds(235, 79, 89, 23);
		panelScore.add(btnLuuDiem);

		JLabel lblNewLabel_3_1_2_1 = new JLabel("Tìm kiếm");
		lblNewLabel_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_2_1.setAlignmentX(0.5f);
		lblNewLabel_3_1_2_1.setBounds(525, 7, 219, 20);
		panelScore.add(lblNewLabel_3_1_2_1);

		textFieldTimDiemMaHS = new JTextField();
		textFieldTimDiemMaHS.setColumns(10);
		textFieldTimDiemMaHS.setBounds(658, 49, 86, 20);
		panelScore.add(textFieldTimDiemMaHS);

		textFieldTimDiemTenHS = new JTextField();
		textFieldTimDiemTenHS.setColumns(10);
		textFieldTimDiemTenHS.setBounds(658, 80, 86, 20);
		panelScore.add(textFieldTimDiemTenHS);

		JLabel lblSearchTeacherCode_1_1 = new JLabel("Mã học sinh");
		lblSearchTeacherCode_1_1.setBounds(558, 49, 60, 20);
		panelScore.add(lblSearchTeacherCode_1_1);

		JLabel lblSearchTeacherName_1_1 = new JLabel("Họ tên");
		lblSearchTeacherName_1_1.setBounds(558, 80, 60, 20);
		panelScore.add(lblSearchTeacherName_1_1);

		JButton btnTimKiemDiemHS = new JButton("Tìm kiếm");
		btnTimKiemDiemHS.addActionListener(diemltn);
		btnTimKiemDiemHS.setBounds(558, 111, 89, 23);
		panelScore.add(btnTimKiemDiemHS);

		JButton btnHuyTimDiemHS = new JButton("Huỷ tìm");
		btnHuyTimDiemHS.addActionListener(diemltn);
		btnHuyTimDiemHS.setBounds(657, 111, 89, 23);
		panelScore.add(btnHuyTimDiemHS);

		JLabel lblNewLabel_4_1 = new JLabel("Danh sách học sinh");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_4_1.setBounds(10, 138, 234, 20);
		panelScore.add(lblNewLabel_4_1);
		
		JButton btnXuatFileDiem = new JButton("Xuất File");
		btnXuatFileDiem.addActionListener(diemltn);
		btnXuatFileDiem.setForeground(new Color(0, 0, 128));
		btnXuatFileDiem.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnXuatFileDiem.setBackground(SystemColor.activeCaption);
		btnXuatFileDiem.setBounds(195, 138, 89, 23);
		panelScore.add(btnXuatFileDiem);
		
		textNhapTenFileDiem = new JTextField();
		textNhapTenFileDiem.setToolTipText("Nhập tên file");
		textNhapTenFileDiem.setText("Nhập tên file");
		textNhapTenFileDiem.setColumns(10);
		textNhapTenFileDiem.setBounds(304, 141, 86, 20);
		panelScore.add(textNhapTenFileDiem);

		/*
		 * Tab quản lý điểm kết thúc ở đây SCORE END
		 */

		/*
		 * Tab quản lý phòng học bắt đầu từ đây CLASSROOM START
		 */

		ActionListener phltn = new PhongListener(this);
		ActionListener plltn = new LopListener(this);

		JPanel panelClassroom = new JPanel();
		panelClassroom.setBackground(new Color(224, 255, 255));
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
		btnChonPhong.addActionListener(phltn);
		btnChonPhong.setBounds(10, 126, 89, 23);
		panelClassroom.add(btnChonPhong);

		JButton btnLuuPhong = new JButton("Lưu");
		btnLuuPhong.addActionListener(phltn);
		btnLuuPhong.setBounds(109, 126, 89, 23);
		panelClassroom.add(btnLuuPhong);

		JButton btnXoaPhong = new JButton("Xoá");
		btnXoaPhong.addActionListener(phltn);
		btnXoaPhong.setBounds(10, 157, 89, 23);
		panelClassroom.add(btnXoaPhong);

		JButton btnChonMoiPhong = new JButton("Tạo mới");
		btnChonMoiPhong.addActionListener(phltn);
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
		btnChonLop.addActionListener(plltn);
		btnChonLop.setBounds(246, 126, 89, 23);
		panelClassroom.add(btnChonLop);

		JButton btnLuuLop = new JButton("Lưu");
		btnLuuLop.addActionListener(plltn);
		btnLuuLop.setBounds(345, 126, 89, 23);
		panelClassroom.add(btnLuuLop);

		JButton btnXoaLop = new JButton("Xoá");
		btnXoaLop.addActionListener(plltn);
		btnXoaLop.setBounds(246, 157, 89, 23);
		panelClassroom.add(btnXoaLop);

		JButton btnChonMoiLop = new JButton("Tạo mới");
		btnChonMoiLop.addActionListener(plltn);
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

		textFieldMaPhongLop = new JTextField();
		textFieldMaPhongLop.setColumns(10);
		textFieldMaPhongLop.setBounds(348, 32, 86, 20);
		panelClassroom.add(textFieldMaPhongLop);

		textFieldHocKyNamHoc = new JTextField();
		textFieldHocKyNamHoc.setColumns(10);
		textFieldHocKyNamHoc.setBounds(348, 94, 86, 20);
		panelClassroom.add(textFieldHocKyNamHoc);

		textFieldMaLop = new JTextField();
		textFieldMaLop.setColumns(10);
		textFieldMaLop.setBounds(348, 63, 86, 20);
		panelClassroom.add(textFieldMaLop);

		JButton btnTimKiemLop = new JButton("Tìm kiếm");
		btnTimKiemLop.addActionListener(plltn);
		btnTimKiemLop.setBounds(497, 126, 89, 23);
		panelClassroom.add(btnTimKiemLop);

		JButton btnHuyTimLop = new JButton("Huỷ tìm");
		btnHuyTimLop.addActionListener(plltn);
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

		JLabel lblNewLabel_1_1 = new JLabel("Thông tin phòng-lớp");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(255, 9, 156, 21);
		panelClassroom.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tìm kiếm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(507, 7, 156, 23);
		panelClassroom.add(lblNewLabel_1_2);

		JLabel lblDanhSchPhng = new JLabel("Danh sách phòng");
		lblDanhSchPhng.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblDanhSchPhng.setBounds(10, 185, 234, 20);
		panelClassroom.add(lblDanhSchPhng);

		JLabel lblDanhSchPhongg = new JLabel("Danh sách phòng-lớp");
		lblDanhSchPhongg.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblDanhSchPhongg.setBounds(395, 185, 234, 20);
		panelClassroom.add(lblDanhSchPhongg);

		/*
		 * TAB LỚP HỌC BẮT ĐẦU
		 * 
		 * 
		 */
		ActionListener lhltn = new LopHocListener(this);
		JPanel panelLopHoc = new JPanel();
		panelLopHoc.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Lớp học", null, panelLopHoc, null);
		tabbedPane.setForegroundAt(4, new Color(0, 0, 0));
		panelLopHoc.setLayout(null);

		JLabel lblNewLabel_3_1_3 = new JLabel("Tìm kiếm");
		lblNewLabel_3_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_3.setAlignmentX(0.5f);
		lblNewLabel_3_1_3.setBounds(525, 13, 219, 17);
		panelLopHoc.add(lblNewLabel_3_1_3);

		JLabel lblMLp_2 = new JLabel("Mã lớp");
		lblMLp_2.setBounds(10, 34, 60, 20);
		panelLopHoc.add(lblMLp_2);

		JLabel lblTnlp = new JLabel("Tên lớp");
		lblTnlp.setBounds(10, 65, 60, 20);
		panelLopHoc.add(lblTnlp);

		JLabel lblNinKho = new JLabel("Niên khoá");
		lblNinKho.setBounds(10, 96, 89, 20);
		panelLopHoc.add(lblNinKho);

		textFieldMaLopHoc = new JTextField();
		textFieldMaLopHoc.setColumns(10);
		textFieldMaLopHoc.setBounds(112, 34, 86, 20);
		panelLopHoc.add(textFieldMaLopHoc);

		textFieldNienKhoaLopHoc = new JTextField();
		textFieldNienKhoaLopHoc.setColumns(10);
		textFieldNienKhoaLopHoc.setBounds(112, 96, 86, 20);
		panelLopHoc.add(textFieldNienKhoaLopHoc);

		textFieldTenLopHoc = new JTextField();
		textFieldTenLopHoc.setColumns(10);
		textFieldTenLopHoc.setBounds(112, 65, 86, 20);
		panelLopHoc.add(textFieldTenLopHoc);

		JLabel lblNewLabel_1_1_1 = new JLabel("Thông tin lớp học");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(19, 11, 156, 21);
		panelLopHoc.add(lblNewLabel_1_1_1);

		JButton btnChonLopHoc = new JButton("Chọn");
		btnChonLopHoc.addActionListener(lhltn);
		btnChonLopHoc.setBounds(228, 34, 89, 23);
		panelLopHoc.add(btnChonLopHoc);

		JButton btnLuuLopHoc = new JButton("Lưu");
		btnLuuLopHoc.addActionListener(lhltn);
		btnLuuLopHoc.setBounds(327, 34, 89, 23);
		panelLopHoc.add(btnLuuLopHoc);

		JButton btnXoaLopHoc = new JButton("Xoá");
		btnXoaLopHoc.addActionListener(lhltn);
		btnXoaLopHoc.setBounds(228, 65, 89, 23);
		panelLopHoc.add(btnXoaLopHoc);

		JButton btnTaoMoiLopHoc = new JButton("Tạo mới");
		btnTaoMoiLopHoc.addActionListener(lhltn);
		btnTaoMoiLopHoc.setBounds(327, 65, 89, 23);
		panelLopHoc.add(btnTaoMoiLopHoc);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 177, 734, 276);
		panelLopHoc.add(scrollPane);

		tableLopHoc = new JTable();
		tableLopHoc.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã Lớp", "Tên Lớp", "Niên khoá", "Sỉ số" }));
		scrollPane.setViewportView(tableLopHoc);

		textFieldTimKiemMaLopHoc = new JTextField();
		textFieldTimKiemMaLopHoc.setColumns(10);
		textFieldTimKiemMaLopHoc.setBounds(623, 31, 86, 20);
		panelLopHoc.add(textFieldTimKiemMaLopHoc);

		textFieldTImKiemTenLopHoc = new JTextField();
		textFieldTImKiemTenLopHoc.setColumns(10);
		textFieldTImKiemTenLopHoc.setBounds(623, 62, 86, 20);
		panelLopHoc.add(textFieldTImKiemTenLopHoc);

		JLabel lblSearchTeacherCode_2 = new JLabel("Mã lớp");
		lblSearchTeacherCode_2.setBounds(523, 31, 60, 20);
		panelLopHoc.add(lblSearchTeacherCode_2);

		JLabel lblSearchTeacherName_2 = new JLabel("Tên lớp");
		lblSearchTeacherName_2.setBounds(523, 62, 60, 20);
		panelLopHoc.add(lblSearchTeacherName_2);

		JButton btnTimKiemLopHoc = new JButton("Tìm kiếm");
		btnTimKiemLopHoc.addActionListener(lhltn);
		btnTimKiemLopHoc.setBounds(556, 124, 89, 23);
		panelLopHoc.add(btnTimKiemLopHoc);

		JLabel lblSearchTeacherAddress_2 = new JLabel("Niên khoá");
		lblSearchTeacherAddress_2.setBounds(523, 93, 60, 20);
		panelLopHoc.add(lblSearchTeacherAddress_2);

		textFieldTimKiemNienKhoaLopHoc = new JTextField();
		textFieldTimKiemNienKhoaLopHoc.setColumns(10);
		textFieldTimKiemNienKhoaLopHoc.setBounds(623, 93, 86, 20);
		panelLopHoc.add(textFieldTimKiemNienKhoaLopHoc);

		JButton btnHuyTimLopHoc = new JButton("Huỷ tìm");
		btnHuyTimLopHoc.addActionListener(lhltn);
		btnHuyTimLopHoc.setBounds(655, 124, 89, 23);
		panelLopHoc.add(btnHuyTimLopHoc);
		
		JButton btnXuatFileLop = new JButton("Xuất File");
		btnXuatFileLop.addActionListener(lhltn);
		btnXuatFileLop.setForeground(new Color(0, 0, 128));
		btnXuatFileLop.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnXuatFileLop.setBackground(SystemColor.activeCaption);
		btnXuatFileLop.setBounds(201, 143, 89, 23);
		panelLopHoc.add(btnXuatFileLop);
		
		JLabel lblDanhSchLp = new JLabel("Danh sách lớp học");
		lblDanhSchLp.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblDanhSchLp.setBounds(10, 147, 234, 20);
		panelLopHoc.add(lblDanhSchLp);
		
		textNhapTenFileLopHoc = new JTextField();
		textNhapTenFileLopHoc.setToolTipText("Nhập tên file");
		textNhapTenFileLopHoc.setText("Nhập tên file");
		textNhapTenFileLopHoc.setColumns(10);
		textNhapTenFileLopHoc.setBounds(312, 144, 86, 20);
		panelLopHoc.add(textNhapTenFileLopHoc);

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
		huytimGV();
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

		ArrayList<GiaoVien> dsgv = new ArrayList<GiaoVien>();
		dsgv.add(gv);
		this.hienthiChuNhiemtheodsGV(dsgv);

	}

	public void xoaGV() {
		DefaultTableModel mode = (DefaultTableModel) this.tableThongTinGV.getModel();
		int i_row = this.tableThongTinGV.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,
				"Bạn có chắc muốn xoá giáo viên này ra khỏi cơ sở dữ liệu không?");

		if (luaChon == JOptionPane.YES_OPTION) {
			GiaoVien gv = layThongTinGVDangChon();
			if(this.gvModel.delete(gv)) {
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}else{
				int pn = JOptionPane.showConfirmDialog(this, "Có thể hiện dữ liệu khác tham chiếu tới dữ liệu bạn muốn xoá!, bạn muốn xoá hết các dữ liệu liên quan không?");
				System.out.println(pn);
				if(pn == JOptionPane.YES_OPTION) {
					System.out.println(this.gvModel.deleteAnyway(gv));
				}
			}
			this.huytimGV();
		}

	}

	public void timKiemGV() {
		String maGV = this.textFieldMaGVTimKiem.getText();
		String tenGV = this.textFieldTimKiemHoTenGV.getText();
		String diachiGV = this.textFieldTimKiemDiaChiGV.getText();

		ArrayList<GiaoVien> ds = new ArrayList<GiaoVien>();

		for (int i = 0; i < this.gvModel.getDsGiaoVien().size(); i++) {
			if (this.gvModel.getDsGiaoVien().get(i).getMaGV().equals(maGV)) {
				ds.add(this.gvModel.getDsGiaoVien().get(i));
				break;
			} else if (this.gvModel.getDsGiaoVien().get(i).getHoTenGV().contains(tenGV)
					&& this.gvModel.getDsGiaoVien().get(i).getDiaChiGV().contains(diachiGV) && maGV.equals("")) {
				ds.add(this.gvModel.getDsGiaoVien().get(i));

			}
		}
		hienthiGVtheods(ds);
	}

	public void hienthiGVtheods(ArrayList<GiaoVien> ds) {
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
		for (GiaoVien gv : ds) {
			this.themGVvaoBangDL(gv);
		}
		this.hienthiChuNhiemtheodsGV(ds);
	}

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
		hienthiChuNhiemtheodsGV(this.gvModel.getDsGiaoVien());
	}

	public void xuatFileGV() {
		String tenfile = this.textNhapTenFileGV.getText();
		if(tenfile.equals("Nhập tên file")) {
			tenfile = "NewExcel";
		}
		this.gvModel.xuatFileDSGV(tenfile);
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

			ArrayList<HocSinh> dshs = new ArrayList<HocSinh>();
			dshs = (ArrayList<HocSinh>) this.hsModel.getHocSinhDao().selectAll();
			this.hsModel.setDsHocSinh(dshs);

			this.layDSChuNhiem();
			this.hienthiDSChuNhiemHienTai();

			ArrayList<PhongHoc> dsph = new ArrayList<PhongHoc>();
			dsph = (ArrayList<PhongHoc>) this.phModel.getPhongHocDAO().selectAll();
			this.phModel.setDsPhongHoc(dsph);

			ArrayList<PhongLop> dspl = new ArrayList<PhongLop>();
			dspl = (ArrayList<PhongLop>) this.plModel.getPhonglopDao().selectAll();
			this.plModel.setDsPhongLop(dspl);

			ArrayList<Lop> dslh = new ArrayList<Lop>();
			dslh = (ArrayList<Lop>) this.lopModel.getLopDao().selectAll();
			this.lopModel.setDsLop(dslh);

			System.out.println(ds);
			this.layDSDiem();
			this.hienthiDSChuNhiemHienTai();
			huytimLH();
			huytimPH();
			huytimPL();
			huytimGV();
			huytimHS();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void hienthiCNtheods(ArrayList<ChuNhiem> ds) {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableChuNhiem.getModel();
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
		for (ChuNhiem cn : ds) {
			this.themChuNhiemVaoTable(cn);
		}
	}

	public void hienthiChuNhiemtheodsGV(ArrayList<GiaoVien> dsgv) {
		ArrayList<ChuNhiem> dscn = this.cnModel.getDsChuNhiem();
		ArrayList<ChuNhiem> dsht = new ArrayList<ChuNhiem>();
		for (int i = 0; i < dsgv.size(); i++) {
			for (int j = 0; j < dscn.size(); j++) {
				if (dsgv.get(i).getMaGV().equals(dscn.get(j).getMaGV())) {
					dsht.add(dscn.get(j));
				}
			}
		}
		dsht.add(null);
		hienthiCNtheods(dsht);
	}

	public void layDLChuNhiemTuBang() {
		DefaultTableModel mode = (DefaultTableModel) tableChuNhiem.getModel();
		int soDong = mode.getRowCount();

		ArrayList<ChuNhiem> ds = new ArrayList<ChuNhiem>();

		for (int i = 0; i < soDong; i++) {
			String magv = mode.getValueAt(i, 0).toString();
			String malop = mode.getValueAt(i, 1).toString();
			String namhoc = mode.getValueAt(i, 2).toString();
			if (magv.equals("_")) {
				break;
			}
			ChuNhiem cn = new ChuNhiem(magv, malop, namhoc);
			ds.add(cn);
		}

		this.cnModel.setDsChuNhiem(ds);
	}

	public void hienthiDSChuNhiemHienTai() {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableChuNhiem.getModel();
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
		for (ChuNhiem cn : this.cnModel.getDsChuNhiem()) {
			this.themChuNhiemVaoTable(cn);
		}
		themChuNhiemVaoTable(null);
	}

	public void luuDSChuNhiem() {
		this.layDLChuNhiemTuBang();
		int soPhanTu = this.cnModel.getDsChuNhiem().size();

		ChuNhiemDAO cnd = new ChuNhiemDAO();
		ArrayList<ChuNhiem> dstmp = new ArrayList<ChuNhiem>();
		dstmp = (ArrayList<ChuNhiem>) cnd.selectAll();

		for (int i = 0; i < dstmp.size(); i++) {
			cnd.delete(dstmp.get(i));
		}

		for (int i = 0; i < soPhanTu; i++) {
			this.cnModel.getChuNhiemDao().saveOrUpdate(this.cnModel.getDsChuNhiem().get(i));
		}
	}

	public void layDSChuNhiem() {
		try {
			ArrayList<ChuNhiem> ds = new ArrayList<ChuNhiem>();
			ds = (ArrayList<ChuNhiem>) this.cnModel.getChuNhiemDao().selectAll();
			this.cnModel.setDsChuNhiem(ds);
			System.out.println(ds);
			hienThiDSDiemHienTai();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void themChuNhiemVaoTable(ChuNhiem cn) {
		DefaultTableModel mode = (DefaultTableModel) tableChuNhiem.getModel();
		// Them 1 hang co du lieu la "GiaoVien gv"
		HocSinhModel hsmodel = new HocSinhModel();
		MonHocModel mhmodel = new MonHocModel();

		if (cn != null) {
			mode.addRow(new Object[] { cn.getMaGV(), cn.getMaLop(), cn.getNamHoc() });
		} else {
			mode.addRow(new Object[] { "_", "_", "_" });
		}
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
			if(this.hsModel.delete(hs)) {
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}else{
				JOptionPane.showMessageDialog(this, "Có thể hiện dữ liệu khác tham chiếu tới dữ liệu bạn muốn xoá!\n Xoá không thành công");
			}
			this.huytimHS();
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
		String maLop = !this.textFieldMaLopHS.getText().isEmpty() ? new String(this.textFieldMaLopHS.getText()) : null;
		HocSinh hs = new HocSinh(maHS, hoTenHS, ngaySinhHS, diaChiHS, soDienThoaiPH, maLop);
		this.themHS(hs);
	}

	public void themHS(HocSinh hs) {
		DefaultTableModel mode = (DefaultTableModel) tableHocSinh.getModel();
		if (!this.hsModel.daTonTai(hs)) {
//			Thêm hs vào bảng thông tin và CSDL nếu học sinh chưa được tạo
			this.hsModel.insert(hs);
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
		huytimHS();
	}

	public void themHSvaoBangDL(HocSinh hs) {
		DefaultTableModel mode = (DefaultTableModel) tableHocSinh.getModel();

		mode.addRow(new Object[] { this.hsModel.getDsHocSinh().lastIndexOf(hs) + 1, hs.getMaHS(), hs.getHoTenHS(),
				hs.getNgaySinhHS().getDate() + "/" + (hs.getNgaySinhHS().getMonth() + 1) + "/"
						+ (hs.getNgaySinhHS().getYear() + 1900),
				hs.getDiaChiHS(), hs.getSDTPhuHuynhHS(), hs.getMaLop(), this.lopModel.getTenByMa(hs.getMaLop()) });
	}

	public void hienThiThongTinHSDangChon() {
		HocSinh hs = this.layThongTinHSDangChon();

		System.out.println(hs);
		this.textFieldMaHS.setText(hs.getMaHS());
		this.textFieldHoTenHS.setText(hs.getHoTenHS());
		String s_ngaySinh = hs.getNgaySinhHS().getDate() + "/" + hs.getNgaySinhHS().getMonth() + "/"
				+ (hs.getNgaySinhHS().getYear() + 1900);
		this.textFieldNgaySinhHS.setText(s_ngaySinh);
		this.textAreaDiaChiHS.setText(hs.getDiaChiHS());
		this.textFieldSDTPhuHuynh.setText(hs.getSDTPhuHuynhHS());
		this.textFieldMaLopHS.setText(hs.getMaLop());
	}

	public void huytimHS() {
		// Xoa hết kết quả tìm kiếm trong bảng
		textFieldMaHSTimKiem.setText("");
		textFieldHoTenHSTimKiem.setText("");
		textFieldMaLopHSTimKiem.setText("");

		while (true) {
			DefaultTableModel mode = (DefaultTableModel) tableHocSinh.getModel();
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
		for (HocSinh hs : this.hsModel.getDsHocSinh()) {
			this.themHSvaoBangDL(hs);
		}

	}

	public void timHS() {
		// TODO Auto-generated method stub
		String maHS = new String(textFieldMaHSTimKiem.getText());
		String hoTen = new String(textFieldHoTenHSTimKiem.getText());
		String maLop = new String(textFieldMaLopHSTimKiem.getText());
		if (maHS.isEmpty() && hoTen.isEmpty() && maLop.isEmpty()) {
			JOptionPane.showMessageDialog(tableHocSinh, "Vui lòng nhập ít nhất 1 trường", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		} else {
			ArrayList<HocSinh> result = this.hsModel.findByInFor(maHS, hoTen, maLop);
			while (true) {
				DefaultTableModel mode = (DefaultTableModel) this.tableHocSinh.getModel();
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
			for (HocSinh hs : result) {
				themHSvaoBangDL(hs);
			}
		}

	}

	public void xuatFileHS() {
		String tenfile = this.textNhapTenFileHS.getText();
		if(tenfile.equals("Nhập tên file")) {
			tenfile = "NewExcel";
		}
		this.hsModel.xuatFileDSHS(tenfile);
	}
	
	/*
	 * CÁC PHƯƠNG THỨC LIÊN QUAN ĐẾN TAB HỌC SINH KẾT THỨC Ở ĐÂY
	 * 
	 * 
	 */

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
			Float diemMieng = null;
			Float diem15p = null;
			Float diem1Tiet = null;
			Float diemHocKy = null;

			if (mode.getValueAt(i, 5) != null)
				diemMieng = Float.valueOf(mode.getValueAt(i, 5).toString());
			if (mode.getValueAt(i, 6) != null)
				diem15p = Float.valueOf(mode.getValueAt(i, 6).toString());
			if (mode.getValueAt(i, 7) != null)
				diem1Tiet = Float.valueOf(mode.getValueAt(i, 7).toString());
			if (mode.getValueAt(i, 8) != null)
				diemHocKy = Float.valueOf(mode.getValueAt(i, 8).toString());

			Diem tmp = new Diem(maHS, maMonHoc, diemMieng, diem15p, diem1Tiet, diemHocKy);
			dsDiem.add(tmp);
		}

		this.diemModel.setdsDiem(dsDiem);
	}

	public void hienThiDSDiemHienTai() {
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

	public void luuDSDiem() {
		this.layDuLieuTuBang();
		int soPhanTu = this.diemModel.getdsDiem().size();
		for (int i = 0; i < soPhanTu; i++) {
			this.diemModel.getdiemDAO().saveOrUpdate(this.diemModel.getdsDiem().get(i));
		}
	}

	public void layDSDiem() {
		try {
			String maLop = this.textFieldNhapDiemMaLop.getText();
			String tenMon = (String) this.comboBoxChonMonHoc.getSelectedItem();
			System.out.println(tenMon);
			ArrayList<Diem> ds = new ArrayList<Diem>();
			ds = (ArrayList<Diem>) this.diemModel.getdiemDAO().selectOnConditions(maLop,
					this.mhModel.getMabyTen(tenMon));
			this.diemModel.setdsDiem(ds);
			System.out.println(ds);
			hienThiDSDiemHienTai();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void themDiemVaoTable(Diem diem) {
		DefaultTableModel mode = (DefaultTableModel) tableThongTinDiem.getModel();
		// Them 1 hang co du lieu la "GiaoVien gv"
		HocSinhModel hsmodel = new HocSinhModel();
		MonHocModel mhmodel = new MonHocModel();

		mode.addRow(new Object[] { this.diemModel.getdsDiem().lastIndexOf(diem) + 1, diem.getMaHS(),
				hsmodel.getHocSinhDao().selectById(diem.getMaHS()).getHoTenHS(), diem.getMaMonHoc(),
				mhmodel.getMonHocDao().selectById(diem.getMaMonHoc()).getTenMonHoc(), diem.getDiemMieng(),
				diem.getDiem15Phut(), diem.getDiem1Tiet(), diem.getDiemHocKy() });

	}

	public void timKiemDiemHS() {
		String maHS = this.textFieldTimDiemMaHS.getText();
		String tenHS = this.textFieldTimDiemTenHS.getText();

		ArrayList<Diem> ds = new ArrayList<Diem>();
		ArrayList<HocSinh> dshs = (ArrayList<HocSinh>) this.hsModel.getHocSinhDao().selectAll();

		for (int i = 0; i < this.diemModel.getdsDiem().size(); i++) {
			if (this.diemModel.getdsDiem().get(i).getMaHS().equals(maHS)) {
				ds.add(this.diemModel.getdsDiem().get(i));
				break;
			}
		}
		if (ds.size() == 0) {
			for (int j = 0; j < dshs.size(); j++) {
				if (dshs.get(j).getHoTenHS().contains(tenHS)) {
					for (int i = 0; i < this.diemModel.getdsDiem().size(); i++) {
						if (this.diemModel.getdsDiem().get(i).getMaHS().equals(dshs.get(j).getMaHS())) {
							ds.add(this.diemModel.getdsDiem().get(i));
						}
					}
				}
			}

		}
		hienthiDiemHStheods(ds);
	}

	public void hienthiDiemHStheods(ArrayList<Diem> ds) {
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
		for (Diem diem : ds) {
			this.themDiemVaoTable(diem);
		}
	}

	public void xuatFileDiem() {
		String tenfile = this.textNhapTenFileDiem.getText();
		if(tenfile.equals("Nhập tên file")) {
			tenfile = "NewExcel";
		}
		this.diemModel.xuatFileDSDiem(tenfile);
	}
	
	/*
	 * 
	 * TAB Phòng học
	 */

	// xoa PH
	public void xoaTextFieldPH() {
		this.textFieldMaPhong.setText("");
		this.textFieldSoPhong.setText("");
		this.textFieldSoCho.setText("");
	}

	// luu dl phong hoc
	public void luuDuLieuPHtuInput() {
		// Lay du lieu giao vien tu cac textField va textArea de thuc thi cac thao tac
		// them/sua dl
		String MaPhong = new String(this.textFieldMaPhong.getText());
		int SoPhong = Integer.parseInt(this.textFieldSoPhong.getText());
		int SoChoToiDa = Integer.parseInt(this.textFieldSoCho.getText());

		PhongHoc ph = new PhongHoc(MaPhong, SoPhong, SoChoToiDa);
		this.themPH(ph);
	}

	// them phong hoc
	public void themPH(PhongHoc ph) {
		DefaultTableModel mode = (DefaultTableModel) tableThongTinPhong.getModel();
		if (!this.phModel.daTonTai(ph)) {
			// Them ph vao bang thong tin & csdl neu phong hoc chua ton tai
			this.phModel.insert(ph);
		} else {
			// Chinh sua du lieu phong hoc neu phong hoc da ton tai
			for (PhongHoc PhongHoc : this.phModel.getDsPhongHoc())
				if (ph.getMaPhong().equals(ph.getMaPhong())) {
					this.phModel.update(ph);
				}
		}
		huytimPH();
	}

	private void themPhongHocvaoBangDL(PhongHoc ph) {
		DefaultTableModel mode = (DefaultTableModel) tableThongTinPhong.getModel();
		mode.addRow(new Object[] { ph.getMaPhong(), ph.getSoPhong(), ph.getSoChoToiDa() });
	}

	public PhongHoc layThongTinPhongHocDangChon() {
		DefaultTableModel mode = (DefaultTableModel) this.tableThongTinPhong.getModel();
		int i_row = this.tableThongTinPhong.getSelectedRow();
		String maPhong = (String) mode.getValueAt(i_row, 0);
		int soPhong = Integer.valueOf(mode.getValueAt(i_row, 1).toString());
		int soChoToiDa = Integer.valueOf(mode.getValueAt(i_row, 2).toString());

		PhongHoc ph = new PhongHoc(maPhong, soPhong, soChoToiDa);
		return ph;
	}

	public void xoaPhongHoc() {
		DefaultTableModel mode = (DefaultTableModel) this.tableThongTinPhong.getModel();
		int i_row = this.tableThongTinPhong.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,
				"Bạn có chắc muốn xoá Phòng này ra khỏi cơ sở dữ liệu không?");

		if (luaChon == JOptionPane.YES_OPTION) {
			PhongHoc ph = layThongTinPhongHocDangChon();
			if(this.phModel.delete(ph)) {
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}else{
				JOptionPane.showMessageDialog(this, "Có thể hiện dữ liệu khác tham chiếu tới dữ liệu bạn muốn xoá!\n Xoá không thành công");
			}
			this.huytimPH();
		}
	}

	public void hienThiThongTinPhongHocDangChon() {
		PhongHoc ph = this.layThongTinPhongHocDangChon();
		this.textFieldMaPhong.setText(ph.getMaPhong());
		this.textFieldSoPhong.setText(Integer.toString(ph.getSoPhong())); // Chuyển đổi số nguyên thành chuỗi trước khi
																			// đặt vào trường văn bản
		this.textFieldSoCho.setText(Integer.toString(ph.getSoChoToiDa())); // Tương tự

		ArrayList<PhongHoc> dsph = new ArrayList<PhongHoc>();
		dsph.add(ph);
		this.hienthiPhongTheoDS(dsph);
		this.hienthiLopTheoPhong(dsph);
	}

	public void huytimPH() {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableThongTinPhong.getModel();
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
		for (PhongHoc ph : this.phModel.getDsPhongHoc()) {
			this.themPhongHocvaoBangDL(ph);
		}
	}

	// Xoa Phong Lop
	public void xoaTextFieldPL() {
		this.textFieldMaLop.setText("");
		this.textFieldMaPhongLop.setText("");
		this.textFieldHocKyNamHoc.setText("");
	}

	// Luu du lieu phong lop
	public void luuDuLieuPLtuInput() {
		String MaLop = new String(this.textFieldMaLop.getText());
		String MaPhong = new String(this.textFieldMaPhongLop.getText());
		String HocKyNamHoc = new String(this.textFieldHocKyNamHoc.getText());
		PhongLop pl = new PhongLop(MaPhong, MaLop, HocKyNamHoc);
		this.themPL(pl);
	}

	public void themPL(PhongLop pl) {
		DefaultTableModel mode = (DefaultTableModel) tableThongTinLop.getModel();
		if (!this.plModel.daTonTai(pl)) {
			// Them ph vao bang thong tin & csdl neu phong hoc chua ton tai
			this.plModel.insert(pl);
		} else {
			// Chinh sua du lieu phong hoc neu phong hoc da ton tai
			for (PhongLop PhongLop : this.plModel.getDsPhongLop())
				if (pl.getMaPhong().equals(pl.getMaPhong()) && pl.getMaLop().equals(pl.getMaLop())) {
					this.plModel.update(pl);
				}
		}
		huytimPL();
	}

	private void themPhongLopvaoBangDL(PhongLop pl) {
		DefaultTableModel mode = (DefaultTableModel) tableThongTinLop.getModel();
		mode.addRow(new Object[] { pl.getMaPhong(), pl.getMaLop(), pl.getHocKyNamHoc() });
	}

	public void hienThiThongTinPhongLopDangChon() {
		PhongLop pl = this.layThongTinPhongLopDangChon();
		this.textFieldMaPhongLop.setText(pl.getMaPhong());
		this.textFieldMaLop.setText(pl.getMaLop());
		this.textFieldHocKyNamHoc.setText(pl.getHocKyNamHoc());

		ArrayList<PhongLop> dspl = new ArrayList<PhongLop>();
		dspl.add(pl);
		this.hienthiLopTheoDS(dspl);
		this.hienthiPhongTheoLop(dspl);
	}

	public PhongLop layThongTinPhongLopDangChon() {
		DefaultTableModel mode = (DefaultTableModel) this.tableThongTinLop.getModel();
		int i_row = this.tableThongTinLop.getSelectedRow();
		String maPhong = mode.getValueAt(i_row, 0).toString();
		String maLop = mode.getValueAt(i_row, 1).toString();
		String hocKyNamHoc = mode.getValueAt(i_row, 2).toString();

		PhongLop ph = new PhongLop(maPhong, maLop, hocKyNamHoc);
		return ph;
	}

	public void xoaPhongLop() {
		DefaultTableModel mode = (DefaultTableModel) this.tableThongTinLop.getModel();
		int i_row = this.tableThongTinLop.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,
				"Bạn có chắc muốn xoá Phòng Lớp này ra khỏi cơ sở dữ liệu không?");

		if (luaChon == JOptionPane.YES_OPTION) {
			PhongLop pl = layThongTinPhongLopDangChon();
			if(this.plModel.delete(pl)) {
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}else
			{
				JOptionPane.showMessageDialog(this, "Có thể hiện dữ liệu khác tham chiếu tới dữ liệu bạn muốn xoá!");
			}
			this.huytimPL();
		}
	}

	public void huytimPL() {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableThongTinLop.getModel();
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
		for (PhongLop pl : this.plModel.getDsPhongLop()) {
			this.themPhongLopvaoBangDL(pl);
		}
	}

	public void hienthiPhongTheoLop(ArrayList<PhongLop> dspl) {
		ArrayList<PhongHoc> dsph = this.phModel.getDsPhongHoc();
		ArrayList<PhongHoc> dsht = new ArrayList<PhongHoc>();
		for (int i = 0; i < dspl.size(); i++) {
			for (int j = 0; j < dsph.size(); j++) {
				if (dspl.get(i).getMaPhong().equals(dsph.get(j).getMaPhong())) {
					dsht.add(dsph.get(j));
				}
			}
		}
		hienthiPhongTheoDS(dsht);
	}

	public void hienthiPhongTheoDS(ArrayList<PhongHoc> ds) {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableThongTinPhong.getModel();
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
		for (PhongHoc ph : ds) {
			this.themPhongHocvaoBangDL(ph);
		}
	}

	public void hienthiLopTheoPhong(ArrayList<PhongHoc> dsph) {
		ArrayList<PhongLop> dspl = this.plModel.getDsPhongLop();
		ArrayList<PhongLop> dsht = new ArrayList<PhongLop>();
		for (int i = 0; i < dsph.size(); i++) {
			for (int j = 0; j < dspl.size(); j++) {
				if (dsph.get(i).getMaPhong().equals(dspl.get(j).getMaPhong())) {
					dsht.add(dspl.get(j));
				}
			}
		}
		hienthiLopTheoDS(dsht);
	}

	public void hienthiLopTheoDS(ArrayList<PhongLop> ds) {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableThongTinLop.getModel();
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
		for (PhongLop pl : ds) {
			this.themPhongLopvaoBangDL(pl);
		}
	}

	public void timKiemPhongLop() {
		String maPhong = this.textFieldTimKiemMaPhong.getText();
		String maLop = this.textFieldTimKiemMaLop.getText();

		ArrayList<PhongHoc> dsph = new ArrayList<PhongHoc>();
		ArrayList<PhongLop> dspl = new ArrayList<PhongLop>();

		if (maPhong.length() == 0 && maLop.length() == 0) {
			huytimPH();
			huytimPL();
		} else if (maPhong.length() != 0 && maLop.length() == 0) {
			for (int i = 0; i < this.phModel.getDsPhongHoc().size(); i++) {
				if (this.phModel.getDsPhongHoc().get(i).getMaPhong().equals(maPhong)) {
					dsph.add(this.phModel.getDsPhongHoc().get(i));
				}
			}
			this.hienthiPhongTheoDS(dsph);
			this.hienthiLopTheoPhong(dsph);
		} else if (maPhong.length() == 0 && maLop.length() != 0) {
			for (int i = 0; i < this.plModel.getDsPhongLop().size(); i++) {
				if (this.plModel.getDsPhongLop().get(i).getMaLop().equals(maLop)) {
					dspl.add(this.plModel.getDsPhongLop().get(i));
				}
			}
			this.hienthiLopTheoDS(dspl);
			this.hienthiPhongTheoLop(dspl);
		} else {
			for (int i = 0; i < this.plModel.getDsPhongLop().size(); i++) {
				if (this.plModel.getDsPhongLop().get(i).getMaLop().equals(maLop)
						&& this.plModel.getDsPhongLop().get(i).getMaPhong().equals(maPhong)) {
					dspl.add(this.plModel.getDsPhongLop().get(i));
				}
			}
			this.hienthiLopTheoDS(dspl);
			this.hienthiPhongTheoLop(dspl);
		}

	}

	/*
	 * 
	 * TAB Lớp học
	 */
	/*
	 * 
	 * Các Phương thức liên quna đên TAB LOPHOC
	 * 
	 * 
	 * 
	 * 
	 */
	public void xoaTextFieldLH() {
		this.textFieldMaLopHoc.setText("");
		this.textFieldTenLopHoc.setText("");
		this.textFieldNienKhoaLopHoc.setText("");
	}

	public Lop layThongTinLopDangChon() {
		DefaultTableModel mode = (DefaultTableModel) this.tableLopHoc.getModel();
		int i_row = this.tableLopHoc.getSelectedRow();
		String maLopHoc = mode.getValueAt(i_row, 1).toString();
		String tenLopHoc = mode.getValueAt(i_row, 2).toString();
		String nienKhoa = mode.getValueAt(i_row, 3).toString();

		Lop lop = new Lop(maLopHoc, tenLopHoc, nienKhoa);
		return lop;
	}

	public void xoaLopHoc() {
		DefaultTableModel mode = (DefaultTableModel) this.tableLopHoc.getModel();
		int i_row = this.tableLopHoc.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá  Lớp Học này ra khỏi cơ sở dữ liệu không?");

		if (luaChon == JOptionPane.YES_OPTION) {
			Lop lop = layThongTinLopDangChon();
			if(this.lopModel.delete(lop)) {
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}else
			{
				JOptionPane.showMessageDialog(this, "Có thể hiện dữ liệu khác tham chiếu tới dữ liệu bạn muốn xoá!");
			}
			huytimLH();
		}
	}

	public void themL(Lop lop) {
		DefaultTableModel mode = (DefaultTableModel) tableLopHoc.getModel();
		if (!this.lopModel.daTonTai(lop)) {
			// Them ph vao bang thong tin & csdl neu phong hoc chua ton tai
			this.lopModel.insert(lop);
		} else {
			// Chinh sua du lieu phong hoc neu phong hoc da ton tai
			for (Lop Lop : this.lopModel.getDsLop())
				if (lop.getMaLop().equals(lop.getMaLop())) {
					this.lopModel.update(lop);
				}
		}
		huytimLH();
	}

	public void luuDuLieuLHtuInput() {
		String MaLopHoc = new String(this.textFieldMaLopHoc.getText());
		String TenLopHoc = new String(this.textFieldTenLopHoc.getText());
		String NienKhoaLopHoc = new String(this.textFieldNienKhoaLopHoc.getText());
		Lop lop = new Lop(MaLopHoc, TenLopHoc, NienKhoaLopHoc);
		this.themL(lop);
	}

	public void hienThiThongTinLopHocDangChon() {
		Lop lop = this.layThongTinLopDangChon();
		this.textFieldMaLopHoc.setText(lop.getMaLop());
		this.textFieldTenLopHoc.setText(lop.getTenLop());
		this.textFieldNienKhoaLopHoc.setText(lop.getNienKhoa());
		/*
		 * ArrayList<Lop> dslop = new ArrayList<Lop>(); dslop.add(lop);
		 * this.hienthiLopTheoDS(dspl); this.hienthiPhongTheoLop(dspl);
		 */
	}

	public void huytimLH() {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableLopHoc.getModel();
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
		for (Lop lop : this.lopModel.getDsLop()) {
			this.themLopvaoBangDL(lop);
		}
	}

	private void themLopvaoBangDL(Lop lop) {
		DefaultTableModel mode = (DefaultTableModel) tableLopHoc.getModel();
		mode.addRow(new Object[] { mode.getRowCount()+1, lop.getMaLop(), lop.getTenLop(), lop.getNienKhoa(), lop.getSiSo(this.hsModel.getDsHocSinh()) });
	}

	public void timKiemLopHoc() {
		String maLopHoc = this.textFieldTimKiemMaLopHoc.getText();
		String tenLopHoc = this.textFieldTImKiemTenLopHoc.getText();
		String nienKhoaLopHoc = this.textFieldTimKiemNienKhoaLopHoc.getText();

		ArrayList<Lop> ds = new ArrayList<Lop>();

		for (int i = 0; i < this.lopModel.getDsLop().size(); i++) {
			if (this.lopModel.getDsLop().get(i).getMaLop().equals(maLopHoc)) {
				ds.add(this.lopModel.getDsLop().get(i));
				break;
			} else if (this.lopModel.getDsLop().get(i).getTenLop().contains(tenLopHoc)
					&& this.lopModel.getDsLop().get(i).getNienKhoa().contains(nienKhoaLopHoc) && maLopHoc.equals("")) {
				ds.add(this.lopModel.getDsLop().get(i));

			}
		}

		hienthiLoptheods(ds);
	}

	public void hienthiLoptheods(ArrayList<Lop> ds) {
		while (true) {
			DefaultTableModel mode = (DefaultTableModel) this.tableLopHoc.getModel();
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
		for (Lop lop : ds) {
			this.themLopvaoBangDL(lop);
		}
	}
	public void xuatFileLop() {
		String tenfile = this.textNhapTenFileLopHoc.getText();
		if(tenfile.equals("Nhập tên file")) {
			tenfile = "NewExcel";
		}
		this.lopModel.xuatFileDSLH(tenfile);
	}
}
