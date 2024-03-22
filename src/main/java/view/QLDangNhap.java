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
import javax.swing.JPasswordField;

public class QLDangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTenTKDN;
	private JPasswordField passwordFieldDN;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(10, 11, 324, 364);
		contentPane.add(tabbedPane);
		
		JPanel panelDangNhap = new JPanel();
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
		btnDangNhap.setBounds(103, 256, 89, 23);
		btnDangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dangNhap();
				
			}
		});
		panelDangNhap.add(btnDangNhap);
		
		JLabel lblNewLabel = new JLabel("Welcome To This App");
		lblNewLabel.setBounds(103, 63, 141, 50);
		panelDangNhap.add(lblNewLabel);
		
		JPanel panelDangKy = new JPanel();
		tabbedPane.addTab("Đăng ký", null, panelDangKy, null);
		panelDangKy.setLayout(null);
		this.setVisible(true);
	}
	
	public void dangNhap() {
		String tenTK = this.textFieldTenTKDN.getText();
		String matKhauTK = this.passwordFieldDN.getText();
		TaiKhoanDAO tkdao = new TaiKhoanDAO();
		TaiKhoan tkCanXacThuc = tkdao.selectById(tenTK);
		
		if(tkCanXacThuc.xacthuc(tenTK, matKhauTK)) {
			this.setVisible(false);
			QLHS mainView = new QLHS();
			mainView.openDL();
		}
		else {
			JOptionPane.showMessageDialog(contentPane, "Tài khoản hoặc mật khẩu sai, vui lòng nhập lại");
			this.textFieldTenTKDN.setText("");
			this.passwordFieldDN.setText("");
		}
	}
}
