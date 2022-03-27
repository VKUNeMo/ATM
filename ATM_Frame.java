package EndofTerm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.Toolkit;

public class ATM_Frame extends JFrame {

	private JPanel contentPane;
	
	private final JButton button = new JButton("New button");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					ATM_Frame frame = new ATM_Frame(Account acc);
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
	public ATM_Frame(Account acc) {
		setTitle("ATM VKU");
		setBackground(new Color(204, 204, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 516);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//add 6 button
		//chức năng rút tiền và giao diện
		JButton btn_ruttien = new JButton("Rút tiền");
		btn_ruttien.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\atm.png"));
		btn_ruttien.setSelectedIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\profits.png"));
		btn_ruttien.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_ruttien.setBounds(57, 177, 170, 70);
		contentPane.add(btn_ruttien);
		btn_ruttien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ATM_Control a= new ATM_Control();
				a .getData();
				JFrame fr= new JFrame("Rút tiền");
				fr.getContentPane().setLayout(new FlowLayout());
				JLabel lb= new JLabel("Số tiền bạn muốn rút");
				fr.getContentPane().add(lb);
				lb.setHorizontalAlignment(SwingConstants.CENTER);
				JTextField text = new JTextField(15);
				fr.getContentPane().add(text);
				JButton xn = new JButton("Xác nhận");
				xn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						long tien_rut = Integer.valueOf(text.getText());
						if(a.RutTien(acc.getMa_the(),tien_rut) ) {
							JOptionPane.showMessageDialog(null,"Thành công !");
							fr.setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "Thất bại !");
						}
						
					}
				});
				fr.getContentPane().add(xn,BorderLayout.SOUTH);
				JButton thoat = new JButton("Thoát");
				thoat.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						fr.setVisible(false);
					}
				});
				fr.getContentPane().add(thoat);
				fr.setLocationRelativeTo(null);
				fr.setSize(350,125);
				fr.setVisible(true);
			}
		});
		//chức năng chuyển khoản và giao diện
		JButton btn_ck = new JButton("Chuyển khoản");
		btn_ck.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\profits.png"));
		btn_ck.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_ck.setBounds(57, 266, 170, 70);
		contentPane.add(btn_ck);
		btn_ck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				ATM_Control a= new ATM_Control();
				a .getData();
				JFrame fr = new JFrame("Chuyển khoản");
				fr.getContentPane().setLayout(new GridLayout(3,1));
				JLabel lb1= new JLabel("Mã thẻ bạn muốn chuyển");
				fr.getContentPane().add(lb1);
				JTextField t1 = new JTextField(20);
				fr.getContentPane().add(t1);
				JLabel lb2 = new JLabel("Số tiền bạn muốn chuyển");
				fr.getContentPane().add(lb2);
				JTextField t2 = new JTextField(20);
				fr.getContentPane().add(t2);
				JButton bt= new JButton("Xác nhận");
				bt.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							if(a.CK(acc.getMa_the(), t1.getText(), Long.valueOf(t2.getText()))){
								JOptionPane.showMessageDialog(null, "Thành công !");
							}else {
								JOptionPane.showMessageDialog(null, "Thất bại !");
							}
						}catch(Exception ex) {
							ex.printStackTrace();
						}
						
					}
					
				});
				JButton bt_thoat = new JButton("Thoát");
				bt_thoat.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						fr.setVisible(false);
					}
				});
				fr.getContentPane().add(bt);
				fr.getContentPane().add(bt_thoat);
				fr.pack();
				fr.setLocationRelativeTo(null);
				fr.setSize(400, 150);
				fr.setVisible(true);
				
			}
		});
		//chức năng lsgd và giao diện
		JButton btn_lsgd = new JButton("In sao kê");
		btn_lsgd.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\printer.png"));
		btn_lsgd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_lsgd.setBounds(57, 359, 170, 70);
		contentPane.add(btn_lsgd);
		btn_lsgd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Xin chờ trong giây lát");
				try {
					Thread.sleep(3000);
					JOptionPane.showMessageDialog(null, "Đã hoàn tất. Xin cảm ơn!");
				}catch(Exception a) {
					a.printStackTrace();
				}
			}		
		});
		// chức năng kiểm tra số dư và giao diện của chức năng
		JButton btn_kiemtra = new JButton("Kiểm tra số dư");
		btn_kiemtra.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\money.png"));
		btn_kiemtra.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_kiemtra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ATM_Control a= new ATM_Control();
				a .getData();
				JFrame fr= new JFrame("Số dư của bạn");
				JLabel lb = new JLabel("Số dư của bạn là "+a.so_du(acc.getMa_the()));
				fr.getContentPane().setLayout(new BorderLayout());
				lb.setHorizontalAlignment(JLabel.CENTER);
				fr.getContentPane().add(lb);
				fr.setLocationRelativeTo(null);
				fr.setSize(350, 150);
				fr.setVisible(true);
			}
				
		});
		btn_kiemtra.setBounds(318, 177, 170, 70);
		contentPane.add(btn_kiemtra);
		//chức năng đổi mã pin và giao diện
		JButton btn_doima = new JButton("Đổi mã PIN");
		btn_doima.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\atm1.png"));
		btn_doima.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_doima.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ATM_Control a= new ATM_Control();
				a .getData();
				JFrame fr = new JFrame("Đổi mã PIN");
				fr.getContentPane().setLayout(new GridLayout(3,1));
				JLabel lb1= new JLabel("Mã PIN cũ");
				fr.getContentPane().add(lb1);
				JTextField t1 = new JTextField(20);
				fr.getContentPane().add(t1);
				JLabel lb2 = new JLabel("Mã PIN mới");
				fr.getContentPane().add(lb2);
				JTextField t2 = new JTextField(20);
				fr.getContentPane().add(t2);
				JButton bt= new JButton("Xác nhận");
				bt.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
						if(a.change_pin(acc.getMa_the(), Integer.valueOf(t2.getText()))) {
							JOptionPane.showMessageDialog(null, "Thành công");
						}else {
							JOptionPane.showMessageDialog(null, "Lỗi");
						}
						}catch(Exception a) {
							a.printStackTrace();
							System.out.println("Lỗi");
						}
					}
				});
				fr.getContentPane().add(bt);
				JButton bt2 = new JButton("Thoát");
				bt2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						fr.setVisible(false);
					}
				});
				fr.getContentPane().add(bt2);
				fr.pack();
				fr.setLocationRelativeTo(null);
				fr.setSize(300, 150);
				fr.setVisible(true);
			}
		});
		btn_doima.setBounds(318, 266, 170, 70);
		contentPane.add(btn_doima);
		// chức năng thoát
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.setIcon(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\log-out.png"));
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_thoat.setBounds(318, 359, 170, 70);
		contentPane.add(btn_thoat);
		btn_thoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn muốn thoát ?")==JOptionPane.NO_OPTION) {
                	return;
                }
				JOptionPane.showMessageDialog(null,"Xin cảm ơn!");
				System.exit(1000);
			}
		});
		// lời xin chào dưới ảnh
		JLabel lblNewLabel = new JLabel("Xin chào "+acc.getChu_tk());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(3, 132, 508, 30);
		contentPane.add(lblNewLabel);		
		
		
		//ảnh ở đầu
		JLabel lb_img = new JLabel(new ImageIcon("C:\\Users\\TechCare\\eclipse-workspace\\Connect\\src\\EndofTerm\\pixlr-bg-result.png"));
		getContentPane().add(lb_img);
		lb_img.setBounds(-7, 11, 212, 110);
		contentPane.add(lb_img);
		
		JLabel lblNewLabel_1 = new JLabel("V");
		lblNewLabel_1.setForeground(new Color(204, 0, 51));
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(175, 34, 60, 87);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("K");
		lblNewLabel_2.setForeground(new Color(255, 204, 0));
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 50));
		lblNewLabel_2.setBounds(227, 43, 48, 69);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("U");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 50));
		lblNewLabel_3.setBounds(277, 46, 48, 63);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BANK");
		lblNewLabel_4.setForeground(new Color(255, 204, 0));
		lblNewLabel_4.setFont(new Font("Stencil", Font.PLAIN, 50));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(318, 46, 164, 63);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*Lưu ý: Quý khách tuyệt đối không để người khác nhìn thấy hay chụp lại mã PIN của bạn khi rút tiền. ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_5.setBounds(13, 438, 501, 30);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBounds(10, 111, 501, 10);
		contentPane.add(panel);
}
}
