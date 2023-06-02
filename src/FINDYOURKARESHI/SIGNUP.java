package FINDYOURKARESHI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class SIGNUP extends JFrame {
	
	Connection con;
	PreparedStatement pst;	
	
	
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
	
	private TextField text_fname;
	private TextField text_lname;
	private TextField text_age;
	private TextField text_addr;
	private TextField text_cntc;
	private JComboBox combo_gender;
	private TextField text_username;
	private JLabel gambar; 
	
	private JPanel contentPane;
	private JPasswordField text_pass;
	private JPasswordField text_cpass;
	private String imagePath;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SIGNUP frame = new SIGNUP();
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
	public SIGNUP() {
		connect();
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 1084);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel basic = new JPanel();
		basic.setBackground(Color.PINK);
		basic.setBounds(64, 80, 1223, 600);
		contentPane.add(basic);
		basic.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME:");
		lblNewLabel_2.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(46, 60, 155, 27);
		basic.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("LAST NAME:");
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(46, 120, 113, 27);
		basic.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AGE:");
		lblNewLabel_1_1.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(46, 180, 148, 27);
		basic.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ADRRESS:");
		lblNewLabel_1_2.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(46, 240, 113, 27);
		basic.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CONTACT:");
		lblNewLabel_1_3.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(46, 300, 113, 27);
		basic.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("GENDER:");
		lblNewLabel_1_4.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(46, 360, 113, 27);
		basic.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("PHOTO:");
		lblNewLabel_1_5.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(46, 420, 113, 27);
		basic.add(lblNewLabel_1_5);
		
		text_fname = new TextField();
		text_fname.setBackground(Color.BLACK);
		text_fname.setForeground(Color.PINK);
		text_fname.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		text_fname.setBounds(280, 60, 793, 27);
		basic.add(text_fname);
		
		combo_gender = new JComboBox();
		combo_gender.setForeground(Color.PINK);
		combo_gender.setBackground(Color.BLACK);
		combo_gender.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		combo_gender.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE"}));
		combo_gender.setBounds(280, 360, 155, 29);
		basic.add(combo_gender);
		
		text_lname = new TextField();
		text_lname.setForeground(Color.PINK);
		text_lname.setBackground(Color.BLACK);
		text_lname.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		text_lname.setBounds(280, 120, 793, 27);
		basic.add(text_lname);
		
		text_age = new TextField();
		text_age.setForeground(Color.PINK);
		text_age.setBackground(Color.BLACK);
		text_age.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		text_age.setBounds(280, 180, 793, 27);
		basic.add(text_age);
		
		text_addr = new TextField();
		text_addr.setForeground(Color.PINK);
		text_addr.setBackground(Color.BLACK);
		text_addr.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		text_addr.setBounds(280, 240, 793, 27);
		basic.add(text_addr);
		
		text_cntc = new TextField();
		text_cntc.setForeground(Color.PINK);
		text_cntc.setBackground(Color.BLACK);
		text_cntc.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		text_cntc.setBounds(280, 300, 793, 27);
		basic.add(text_cntc);
		
		gambar = new JLabel("");
		gambar.setVerticalAlignment(SwingConstants.BOTTOM);
		gambar.setBounds(280, 420, 213, 145);
		basic.add(gambar);
		gambar.setBackground(SystemColor.activeCaptionBorder);
		
		JButton btn_browse = new JButton("BROWSE PHOTO");
		btn_browse.setForeground(Color.PINK);
		btn_browse.setBackground(Color.BLACK);
		btn_browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_browseAction(e);
			}

			private void btn_browseAction(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser file = new JFileChooser();
		        file.setCurrentDirectory(new File(System.getProperty("user.home")));
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "gif", "png");
		        file.addChoosableFileFilter(filter);
		        int output = file.showSaveDialog(file);
		        if (output == JFileChooser.APPROVE_OPTION) {
		            File selectFile = file.getSelectedFile();
		            String path = selectFile.getAbsolutePath();
		            gambar.setIcon(adjustgambar(path, null));
		            imagePath = path;

		        } else {
		            JOptionPane.showMessageDialog(gambar, "No photo selected");
		        }
				
			}
			private ImageIcon adjustgambar(String path, byte[] pic) {
		        ImageIcon myImage = null;
		        if (path != null) {
		            myImage = new ImageIcon(path);
		        } else {
		            myImage = new ImageIcon(pic);
		        }
		        Image img = myImage.getImage();
		        Image newImage = img.getScaledInstance(gambar.getWidth(), gambar.getHeight(), Image.SCALE_SMOOTH);
		        ImageIcon icon = new ImageIcon(newImage);
		        return icon;
		    }
		});
		
		btn_browse.setBounds(506, 447, 148, 38);
		basic.add(btn_browse);
		
		JLabel lblNewLabel = new JLabel("BASIC INFORMATION");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBounds(83, 27, 221, 31);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 23));
		
		JPanel user = new JPanel();
		user.setBackground(Color.PINK);
		user.setBounds(64, 760, 1223, 234);
		contentPane.add(user);
		user.setLayout(null);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("USERNAME:");
		lblNewLabel_1_5_1.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_1_5_1.setBounds(51, 40, 107, 27);
		user.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("PASSWORD:");
		lblNewLabel_2_1.setBounds(48, 100, 110, 27);
		lblNewLabel_2_1.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		user.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("CONFIRM PASSWORD:");
		lblNewLabel_2_1_1.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(48, 160, 210, 27);
		user.add(lblNewLabel_2_1_1);
		
		text_username = new TextField();
		text_username.setForeground(Color.PINK);
		text_username.setBackground(Color.BLACK);
		text_username.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		text_username.setBounds(280, 40, 793, 27);
		user.add(text_username);
		
		text_pass = new JPasswordField();
		text_pass.setBackground(Color.BLACK);
		text_pass.setForeground(Color.PINK);
		text_pass.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		text_pass.setBounds(280, 100, 793, 27);
		user.add(text_pass);
		
		text_cpass = new JPasswordField();
		text_cpass.setForeground(Color.PINK);
		text_cpass.setBackground(Color.BLACK);
		text_cpass.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		text_cpass.setBounds(280, 160, 793, 27);
		user.add(text_cpass);
		
		JLabel lblUserInformation = new JLabel("USER INFORMATION");
		lblUserInformation.setVerticalAlignment(SwingConstants.TOP);
		lblUserInformation.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserInformation.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 23));
		lblUserInformation.setBounds(83, 705, 221, 31);
		contentPane.add(lblUserInformation);
		
//		private TextField text_fname;
//		private TextField text_lname;
//		private TextField text_age;
//		private TextField text_addr;
//		private TextField text_cntc;
//		private JComboBox combo_gender;
		
		JButton btn_done = new JButton("DONE");
		btn_done.setForeground(Color.PINK);
		btn_done.setBackground(Color.BLACK);
		btn_done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				try {
					
					
					String fname = text_fname.getText();
					String lname = text_lname.getText();
					String age = text_age.getText();
					String addr = text_addr.getText();
					String cntc = text_cntc.getText();
					String gender = combo_gender.getSelectedItem().toString(); 
					String username = text_username.getText();
					String pass = text_pass.getText();
					String cpass = text_cpass.getText();
					pst = con.prepareStatement("insert into user(fname,lname,age,address,contact,gender,photo,username,password)values(?,?,?,?,?,?,?,?,?)");
					pst.setString(1, fname);
					pst.setString(2, lname);
					pst.setString(3, age);
					pst.setString(4, addr);
					pst.setString(5, cntc);
					pst.setString(6, gender);
					pst.setString(7, imagePath);
					pst.setString(8, username);
					pst.setString(9, pass);
					
					pst.executeUpdate();
					
					
					JOptionPane.showMessageDialog(contentPane, "user added");
					close();
					
					text_fname.setText("");
					text_lname.setText("");
					text_age.setText("");
					text_addr.setText("");
					text_cntc.setText("");
					combo_gender.setSelectedIndex(-1);;
					text_username.setText("");
					text_pass.setText("");
					text_cpass.setText("");
					imagePath=null;
					gambar.setIcon(null);
					
					text_fname.requestFocus();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_done.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		btn_done.setBounds(1320, 700, 120, 50);
		contentPane.add(btn_done);
		
		JButton btn_clear = new JButton("CLEAR");
		btn_clear.setBackground(Color.BLACK);
		btn_clear.setForeground(Color.PINK);
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_fname.setText("");
				text_lname.setText("");
				text_age.setText("");
				text_addr.setText("");
				text_cntc.setText("");
				combo_gender.setSelectedIndex(-1);
				text_username.setText("");
				text_pass.setText("");
				text_cpass.setText("");
				imagePath=null;
				gambar.setIcon(null);
				
				text_fname.requestFocus();
			}
		});
		btn_clear.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		btn_clear.setBounds(1320, 800, 120, 50);
		contentPane.add(btn_clear);
		
		JButton btn_cancel = new JButton("CANCEL");
		btn_cancel.setBackground(Color.BLACK);
		btn_cancel.setForeground(Color.PINK);
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btn_cancel.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		btn_cancel.setBounds(1320, 900, 120, 50);
		contentPane.add(btn_cancel);
		
//		private TextField text_fname;
//		private TextField text_lname;
//		private TextField text_age;
//		private TextField text_addr;
//		private TextField text_cntc;
//		private JComboBox combo_gender;
		
		 
		
	}
	public void close() {
		LOGIN home = new LOGIN();
        home.setVisible(true);
        this.dispose();
	}
}
