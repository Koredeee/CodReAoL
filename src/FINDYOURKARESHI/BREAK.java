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

public class BREAK extends JFrame {
	
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

	private JPanel contentPane;
	private JTextField txt_src;
	private JTextField txt_fname;
	private JTextField txt_lname;
	private JTextField txt_age;
	private JTextField txt_gender;
	private JTextField txt_uname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BREAK frame = new BREAK();
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
	public BREAK() {
		connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 696);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WHEN THERE IS A MEETING, PARTING SURE TO FOLLOW");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel.setBounds(47, 11, 759, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ARE YOU REALLY SURE ABOUT THIS? INSERT YOUR KARESHI ID HERE");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 119, 637, 44);
		contentPane.add(lblNewLabel_1);
		
		txt_src = new JTextField();
		txt_src.setBackground(Color.BLACK);
		txt_src.setForeground(Color.RED);
		txt_src.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_src.setColumns(10);
		txt_src.setBounds(612, 128, 96, 27);
		contentPane.add(txt_src);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.setBounds(57, 226, 604, 352);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(38, 25, 120, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("LAST NAME");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBackground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(38, 75, 120, 32);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("AGE");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setBackground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(38, 125, 120, 32);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("GENDER");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setBackground(Color.BLACK);
		lblNewLabel_2_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(38, 175, 120, 32);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("USERNAME");
		lblNewLabel_2_4.setForeground(Color.RED);
		lblNewLabel_2_4.setBackground(Color.BLACK);
		lblNewLabel_2_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_4.setBounds(38, 225, 120, 32);
		panel.add(lblNewLabel_2_4);
		
		txt_fname = new JTextField();
		txt_fname.setBackground(Color.RED);
		txt_fname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_fname.setColumns(10);
		txt_fname.setBounds(203, 24, 352, 31);
		panel.add(txt_fname);
		
		txt_lname = new JTextField();
		txt_lname.setBackground(Color.RED);
		txt_lname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_lname.setColumns(10);
		txt_lname.setBounds(203, 76, 352, 31);
		panel.add(txt_lname);
		
		txt_age = new JTextField();
		txt_age.setBackground(Color.RED);
		txt_age.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_age.setColumns(10);
		txt_age.setBounds(203, 126, 352, 31);
		panel.add(txt_age);
		
		txt_gender = new JTextField();
		txt_gender.setBackground(Color.RED);
		txt_gender.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_gender.setColumns(10);
		txt_gender.setBounds(203, 175, 352, 31);
		panel.add(txt_gender);
		
		txt_uname = new JTextField();
		txt_uname.setBackground(Color.RED);
		txt_uname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_uname.setColumns(10);
		txt_uname.setBounds(203, 225, 352, 31);
		panel.add(txt_uname);
		
		JButton btn_break = new JButton("BREAK UP");
		btn_break.setBackground(Color.RED);
		btn_break.setForeground(Color.BLACK);
		btn_break.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int sid = Integer.parseInt(txt_src.getText());
					
					pst = con.prepareStatement("delete from kareshi where kid = ?");
					pst.setInt(1, sid);
					
					pst.executeUpdate();
					
					
					JOptionPane.showMessageDialog(contentPane, "Kareshi Broke Up");
					
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
		btn_break.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btn_break.setBounds(38, 303, 134, 23);
		panel.add(btn_break);
		
		JButton btn_clear = new JButton("CLEAR");
		btn_clear.setBackground(Color.RED);
		btn_clear.setForeground(Color.BLACK);
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
		btn_back.setBackground(Color.BLACK);
		btn_back.setForeground(Color.RED);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btn_back.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btn_back.setBounds(724, 536, 97, 42);
		contentPane.add(btn_back);
		
		JButton btn_search = new JButton("SEARCH");
		btn_search.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btn_search.setForeground(Color.RED);
		btn_search.setBackground(Color.BLACK);
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
					pst = con.prepareStatement("select * from kareshi where kid = ?");
					pst.setInt(1, sid);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
					txt_fname.setText(String.valueOf(rs.getString(1)));
					txt_lname.setText(String.valueOf(rs.getString(2)));
					txt_age.setText(String.valueOf(rs.getString(3)));
					txt_gender.setText(String.valueOf(rs.getString(4)));
					txt_uname.setText(String.valueOf(rs.getString(5)));
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
		btn_search.setBounds(736, 128, 97, 27);
		contentPane.add(btn_search);
	}
	
	public void close() {
		HOME home = new HOME();
        home.setVisible(true);
        this.dispose();
	}

}
