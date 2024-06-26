package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.TaiKhoanDAO;
import model.TaiKhoan;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class QLDangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTenTKDN;
	private JPasswordField passwordFieldDN;

	private JTextField textFieldTenTKDK;
	private JPasswordField passwordFieldDK;
	private JPasswordField passwordFieldDKNL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDangNhap frame = new QLDangNhap();
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
	public QLDangNhap() {
		setTitle("Quản lý học sinh");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java\\QLSV\\icon.jpg"));
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 360, 425);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.activeCaption);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(10, 11, 324, 364);
		contentPane.add(tabbedPane);

		JPanel panelDangNhap = new JPanel();
		panelDangNhap.setBackground(SystemColor.activeCaption);
		panelDangNhap.setToolTipText("Đăng nhập");
		tabbedPane.addTab("Đăng nhập", null, panelDangNhap, null);
		panelDangNhap.setLayout(null);

		JLabel lblTaiKhoan = new JLabel("Tài khoản");
		lblTaiKhoan.setBounds(57, 139, 63, 36);
		panelDangNhap.add(lblTaiKhoan);

		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(57, 186, 74, 36);
		panelDangNhap.add(lblMtKhu);

		textFieldTenTKDN = new JTextField();
		textFieldTenTKDN.setColumns(10);
		textFieldTenTKDN.setBounds(141, 147, 111, 20);
		panelDangNhap.add(textFieldTenTKDN);

		passwordFieldDN = new JPasswordField();
		passwordFieldDN.setBounds(141, 194, 111, 20);
		panelDangNhap.add(passwordFieldDN);

		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBounds(120, 257, 89, 23);
		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dangNhap();

			}
		});

		panelDangNhap.add(btnDangNhap);

		JLabel lblNewLabel = new JLabel("App Quản lý học sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(88, 41, 164, 50);
		panelDangNhap.add(lblNewLabel);

		JPanel panelDangKy = new JPanel();
		panelDangKy.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Đăng ký", null, panelDangKy, null);
		panelDangKy.setLayout(null);

		JLabel lblTaiKhoan_1 = new JLabel("Tài khoản");
		lblTaiKhoan_1.setBounds(58, 108, 63, 36);
		panelDangKy.add(lblTaiKhoan_1);

		JLabel lblMtKhu_1 = new JLabel("Mật khẩu");
		lblMtKhu_1.setBounds(58, 155, 74, 36);
		panelDangKy.add(lblMtKhu_1);

		textFieldTenTKDK = new JTextField();
		textFieldTenTKDK.setColumns(10);
		textFieldTenTKDK.setBounds(142, 116, 111, 20);
		panelDangKy.add(textFieldTenTKDK);

		passwordFieldDK = new JPasswordField();
		passwordFieldDK.setBounds(142, 163, 111, 20);
		panelDangKy.add(passwordFieldDK);

		JButton btnDangKy = new JButton("Đăng ký");
		btnDangKy.setBounds(124, 265, 89, 23);
		btnDangKy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dangKy();
			}
		});
		panelDangKy.add(btnDangKy);

		JLabel lblMKNhapLai = new JLabel("Nhập lại mk");
		lblMKNhapLai.setBounds(58, 202, 74, 36);
		panelDangKy.add(lblMKNhapLai);

		passwordFieldDKNL = new JPasswordField();
		passwordFieldDKNL.setBounds(142, 210, 111, 20);
		panelDangKy.add(passwordFieldDKNL);
		
		JLabel lblNewLabel_1 = new JLabel("App Quản lý học sinh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(89, 40, 164, 50);
		panelDangKy.add(lblNewLabel_1);

		this.setVisible(true);
	}

	public void xoaDLNhap() {
		this.textFieldTenTKDN.setText("");
		this.passwordFieldDN.setText("");

		this.textFieldTenTKDK.setText("");
		this.passwordFieldDK.setText("");
		this.passwordFieldDKNL.setText("");
	}

	public void dangNhap() {
		String tenTK = this.textFieldTenTKDN.getText();
		String matKhauTK = this.passwordFieldDN.getText();

		TaiKhoanDAO tkdao = new TaiKhoanDAO();
		if(tenTK.length() == 0 || matKhauTK.length() == 0) {
//			this.setVisible(false);
//			QLHS mainView = new QLHS();
//			mainView.openDL();
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đầy đủ tài khoản và mật khẩu");
		}
		else {
			TaiKhoan tkCanXacThuc = tkdao.selectById(tenTK);
			if(tkCanXacThuc == null) {
				JOptionPane.showMessageDialog(contentPane, "Tài Khoản không tồn tại");
				//Sửa lại sau
//				this.setVisible(false);
//				QLHS mainView = new QLHS();
//				mainView.openDL();
			}
			else if (tkCanXacThuc.xacthuc(tenTK, matKhauTK)) {
				JOptionPane.showMessageDialog(contentPane, "Đăng nhập thành công!");
				this.setVisible(false);
				this.openQLHS();
			} else {
				JOptionPane.showMessageDialog(contentPane, "Tài khoản hoặc mật khẩu sai, vui lòng nhập lại");
				this.xoaDLNhap();
			}
		}
	}

	public void dangKy() {
		String tenTKDK = this.textFieldTenTKDK.getText();
		String matKhauTKDK  = this.passwordFieldDK.getText();
		String matKhauTKDKNL = this.passwordFieldDKNL.getText();
		
		TaiKhoan tk = new TaiKhoan(tenTKDK,matKhauTKDK);
		if(matKhauTKDK.equals(matKhauTKDKNL)) {
			TaiKhoanDAO tkDAO = new TaiKhoanDAO();
			if(tkDAO.selectById(tenTKDK) == null) {
				tkDAO.saveOrUpdate(tk);
				JOptionPane.showMessageDialog(contentPane, "Tạo tài khoản thành công!");
				this.xoaDLNhap();
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Tài khoản đã tồn tại!");
			}
		}else {
			JOptionPane.showMessageDialog(contentPane, "Mật khẩu nhập lại bị sai!");
		}

	}
	
	public void openQLHS(){
		SwingUtilities.invokeLater(() -> {
			QLHS mainView = new QLHS();
            mainView.setVisible(true);
            mainView.openDL();
        });
	}
}
