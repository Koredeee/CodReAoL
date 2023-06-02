package FINDYOURKARESHI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FIND extends JFrame {

	private JPanel contentPane;
	private JTextField txt_fname;
	private JTextField txt_lname;
	private JTextField txt_age;
	private JTextField txt_gender;
	private JTextField txt_uname;
	private JTextField txt_src;
	
	Connection con;
	PreparedStatement pst;	
	ResultSet rs;
	DefaultTableModel d;
	ResultSetMetaData rsd;
	
	
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FIND frame = new FIND();
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
	public FIND() {
		connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 696);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FIND YOUR KARESHI");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 60));
		lblNewLabel.setBounds(176, 28, 548, 62);
		contentPane.add(lblNewLabel);
		
		JLabel txt_gid = new JLabel("GOT YOUR WANTED KARESHI'S ID? INSERT HERE");
		txt_gid.setForeground(Color.PINK);
		txt_gid.setBackground(Color.PINK);
		txt_gid.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_gid.setBounds(57, 128, 454, 27);
		contentPane.add(txt_gid);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(57, 226, 604, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(38, 25, 120, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("LAST NAME");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(38, 75, 120, 32);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("AGE");
		lblNewLabel_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(38, 125, 120, 32);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("GENDER");
		lblNewLabel_2_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(38, 175, 120, 32);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("USERNAME");
		lblNewLabel_2_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_4.setBounds(38, 225, 120, 32);
		panel.add(lblNewLabel_2_4);
		
		txt_fname = new JTextField();
		txt_fname.setBackground(Color.BLACK);
		txt_fname.setForeground(Color.PINK);
		txt_fname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_fname.setBounds(203, 24, 352, 31);
		panel.add(txt_fname);
		txt_fname.setColumns(10);
		
		txt_lname = new JTextField();
		txt_lname.setForeground(Color.PINK);
		txt_lname.setBackground(Color.BLACK);
		txt_lname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_lname.setColumns(10);
		txt_lname.setBounds(203, 76, 352, 31);
		panel.add(txt_lname);
		
		txt_age = new JTextField();
		txt_age.setForeground(Color.PINK);
		txt_age.setBackground(Color.BLACK);
		txt_age.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_age.setColumns(10);
		txt_age.setBounds(203, 126, 352, 31);
		panel.add(txt_age);
		
		txt_gender = new JTextField();
		txt_gender.setForeground(Color.PINK);
		txt_gender.setBackground(Color.BLACK);
		txt_gender.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_gender.setColumns(10);
		txt_gender.setBounds(203, 175, 352, 31);
		panel.add(txt_gender);
		
		txt_uname = new JTextField();
		txt_uname.setForeground(Color.PINK);
		txt_uname.setBackground(Color.BLACK);
		txt_uname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_uname.setColumns(10);
		txt_uname.setBounds(203, 225, 352, 31);
		panel.add(txt_uname);
		
		
		
		JButton btn_confess = new JButton("CONFESS");
		btn_confess.setForeground(Color.PINK);
		btn_confess.setBackground(Color.BLACK);
		btn_confess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
//					private JTextField txt_fname;
//					private JTextField txt_lname;
//					private JTextField txt_age;
//					private JTextField txt_gender;
//					private JTextField txt_uname;
//					private JTextField txt_src;
					
					
					String fname = txt_fname.getText();
					String lname = txt_lname.getText();
					String age = txt_age.getText();
					String gender = txt_gender.getText();
					String uname = txt_uname.getText();
					int sid = Integer.parseInt(txt_src.getText());
					
					pst = con.prepareStatement("insert into kareshi(fname,lname,age,gender,username,kid)values(?,?,?,?,?,?)");
					pst.setString(1, fname);
					pst.setString(2, lname);
					pst.setString(3, age);
					pst.setString(4, gender);
					pst.setString(5, uname);
					pst.setInt(6, sid);
					
					pst.executeUpdate();
					
					
					JOptionPane.showMessageDialog(contentPane, "Kareshi confessed");
					
					txt_src.setText(null);
					txt_fname.setText("");
					txt_lname.setText("");
					txt_age.setText("");
					txt_gender.setText("");
					txt_uname.setText("");
					
					txt_src.requestFocus();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_confess.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btn_confess.setBounds(38, 303, 134, 23);
		panel.add(btn_confess);
		
		JButton btn_clear = new JButton("CLEAR");
		btn_clear.setForeground(Color.PINK);
		btn_clear.setBackground(Color.BLACK);
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_src.setText(null);
				txt_fname.setText("");
				txt_lname.setText("");
				txt_age.setText("");
				txt_gender.setText("");
				txt_uname.setText("");
				
				txt_src.requestFocus();
			}
		});
		btn_clear.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btn_clear.setBounds(431, 303, 134, 23);
		panel.add(btn_clear);
		
		JButton btn_back = new JButton("BACK");
		btn_back.setBackground(Color.PINK);
		btn_back.setForeground(Color.BLACK);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btn_back.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btn_back.setBounds(724, 536, 97, 42);
		contentPane.add(btn_back);
		
		txt_src = new JTextField();
		txt_src.setBackground(Color.PINK);
		txt_src.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_src.setBounds(489, 128, 96, 27);
		contentPane.add(txt_src);
		txt_src.setColumns(10);
		
		JButton btn_search = new JButton("SEARCH");
		btn_search.setBackground(Color.PINK);
		btn_search.setForeground(Color.BLACK);
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sid = Integer.parseInt(txt_src.getText());
				
//				private JPanel contentPane;
//				private JTextField txt_fname;
//				private JTextField txt_lname;
//				private JTextField txt_age;
//				private JTextField txt_gender;
//				private JTextField txt_uname;
//				private JTextField txt_src;
				
				try {
					pst = con.prepareStatement("select * from dummy where fid = ?");
					pst.setInt(1, sid);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
					txt_fname.setText(String.valueOf(rs.getString(2)));
					txt_lname.setText(String.valueOf(rs.getString(3)));
					txt_age.setText(String.valueOf(rs.getString(4)));
					txt_gender.setText(String.valueOf(rs.getString(5)));
					txt_uname.setText(String.valueOf(rs.getString(6)));
					}
					
					else {
						JOptionPane.showMessageDialog(contentPane, "Person Does Not Exist");
						txt_src.setText(null);
					}
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_search.setBounds(616, 128, 97, 27);
		contentPane.add(btn_search);
	}
	
	public void close() {
		HOME home = new HOME();
        home.setVisible(true);
        this.dispose();
	}

}
