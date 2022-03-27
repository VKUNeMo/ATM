package EndofTerm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JToggleButton;

public class Login_Frame extends JFrame {
	Connection conn;
	
	PreparedStatement ps;
	ResultSet rs;
	
	private JPanel contentPane;
	private JTextField text_the;
	private JPasswordField password_pin;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login_Frame frame = new Login_Frame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Login_Frame() {
		setTitle("Login ATM VKU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblma_the = new JLabel("Mã thẻ");
		lblma_the.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblma_the.setBounds(10, 274, 56, 30);
		contentPane.add(lblma_the);
		
		JLabel lblma_pin = new JLabel("Mã pin");
		lblma_pin.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblma_pin.setBounds(10, 315, 80, 30);
		contentPane.add(lblma_pin);
		
		text_the = new JTextField();
		text_the.setBounds(55, 277, 172, 25);
		contentPane.add(text_the);
		text_the.setColumns(10);
		
		password_pin = new JPasswordField();
		password_pin.setBounds(55, 318, 172, 25);
		contentPane.add(password_pin);
		
		JButton btn_dn = new JButton("Đăng nhập");
		btn_dn.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\enter.png"));
		btn_dn.setBounds(0, 368, 118, 41);
		contentPane.add(btn_dn);
		btn_dn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectDB c= new ConnectDB();
					conn= c.getConnect();
					ATM_Control a= new ATM_Control();
					a .getData();
					String sql = "Select * from Account where ma_the="+text_the.getText() +"and ma_pin="+Integer.valueOf(password_pin.getText());
					ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					int record =0;
					while(rs.next()){
						record+=1;
					}
					if(record == 1) {
						JOptionPane.showMessageDialog(null, "Thành công!");
						Account acc= new Account();
						acc=  Account_login( text_the.getText());
						ATM_Frame atm = new ATM_Frame(acc);
						atm.setVisible(true);
						setVisible(false);
					} 
					else  {
						JOptionPane.showMessageDialog(null, "Mã thẻ hoặc mã PIN của bạn đang bị sai! Vui lòng thử lại.");
					}
				}
				
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}				
			}
		});
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\log-out.png"));
		btn_thoat.setBounds(123, 368, 113, 41);
		contentPane.add(btn_thoat);
		
		JLabel lblNewLabel = new JLabel("KÍNH CHÀO QUÝ KHÁCH");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 162, 258, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\pixlr-bg-result.png"));
		lblNewLabel_2.setBounds(10, 11, 147, 120);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("V");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(204, 0, 51));
		lblNewLabel_1_1.setFont(new Font("Stencil", Font.BOLD, 50));
		lblNewLabel_1_1.setBounds(147, 30, 60, 87);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("K");
		lblNewLabel_2_1.setForeground(new Color(255, 204, 51));
		lblNewLabel_2_1.setFont(new Font("Stencil", Font.PLAIN, 50));
		lblNewLabel_2_1.setBounds(196, 39, 48, 69);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("U");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 50));
		lblNewLabel_3.setBounds(240, 42, 48, 63);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BANK");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 204, 0));
		lblNewLabel_4.setFont(new Font("Stencil", Font.PLAIN, 50));
		lblNewLabel_4.setBounds(275, 42, 164, 63);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\Untitled.png"));
		lblNewLabel_1.setBounds(0, 0, 447, 502);
		contentPane.add(lblNewLabel_1);
		btn_thoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to EXIT ?")==JOptionPane.NO_OPTION) {
                	return;
                }
				JOptionPane.showMessageDialog(null,"Thank you");
				System.exit(1000);
			}
		});
	}
	public Account Account_login( String ma_the) {
		Account a= new Account();
		String sql = "Select * from Account where ma_the= "+ ma_the;
		try {
			this.ps= this.conn.prepareStatement(sql);
			this.rs=this.ps.executeQuery();
			if(rs.next()) {
				 a= new Account(rs.getString(1),rs.getInt(2),rs.getLong(3),rs.getString(4),rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}
