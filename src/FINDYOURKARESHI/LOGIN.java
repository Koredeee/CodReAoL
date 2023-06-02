package FINDYOURKARESHI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;


import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LOGIN extends JFrame {

	Connection con;
	PreparedStatement pst;	
	DefaultTableModel d;

	
public void connect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/kareshimanage","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JPanel contentPane;
	private JTextField txt_uname;
	private JPasswordField txt_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
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
	public LOGIN() {
		connect();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 881);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 53));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 178, 196));
		lblNewLabel.setBounds(198, 165, 298, 104);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 178, 196), new Color(255, 178, 196), new Color(255, 178, 196), new Color(255, 178, 196)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(255, 176, 176));
		panel.setBounds(238, 269, 579, 290);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(new Color(255, 178, 196));
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(244, 26, 113, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setForeground(new Color(255, 178, 196));
		lblNewLabel_2.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(244, 147, 130, 41);
		panel.add(lblNewLabel_2);
		
		txt_uname = new JTextField();
		txt_uname.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		txt_uname.setBackground(new Color(255, 176, 176));
		txt_uname.setBounds(63, 78, 482, 41);
		panel.add(txt_uname);
		txt_uname.setColumns(10);
		
		txt_pass = new JPasswordField();
		txt_pass.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		txt_pass.setBackground(new Color(255, 176, 176));
		txt_pass.setBounds(63, 216, 482, 41);
		panel.add(txt_pass);
		
		JButton btn_login = new JButton("LOG IN");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = txt_uname.getText();
				String pass = txt_pass.getText();
				
				try {
					pst = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
					pst.setString(1, uname);
					pst.setString(2, pass);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						
						hclose();
						
						
					}
					else {
						JOptionPane.showMessageDialog(contentPane,"Username or Password is not correct!");
						txt_uname.setText("");
						txt_pass.setText("");
						txt_uname.requestFocus();
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		btn_login.setForeground(new Color(255, 178, 196));
		btn_login.setBackground(new Color(0, 0, 0));
		btn_login.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		btn_login.setBounds(450, 595, 180, 45);
		contentPane.add(btn_login);
		
		JLabel vfavadf = new JLabel("DONT HAVE ACCOUNT? SIGN UP HERE");
		vfavadf.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 11));
		vfavadf.setForeground(new Color(255, 128, 128));
		vfavadf.setBounds(86, 759, 245, 14);
		contentPane.add(vfavadf);
		
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnSignIn.setForeground(new Color(255, 178, 196));
		btnSignIn.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		btnSignIn.setBackground(new Color(0, 0, 0));
		btnSignIn.setBounds(339, 759, 91, 16);
		contentPane.add(btnSignIn);
		
		JLabel lblNewLabel_4 = new JLabel("KARESHI");
		lblNewLabel_4.setForeground(new Color(255, 178, 196));
		lblNewLabel_4.setFont(new Font("Segoe Script", Font.PLAIN, 72));
		lblNewLabel_4.setBounds(339, 27, 417, 81);
		contentPane.add(lblNewLabel_4);
		
		
	}
	public void hclose(){
		HOME home = new HOME();
        home.setVisible(true);
        this.dispose();
	}
	public void close() {
		SIGNUP home = new SIGNUP();
        home.setVisible(true);
        this.dispose();
	}
}
