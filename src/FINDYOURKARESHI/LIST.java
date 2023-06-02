package FINDYOURKARESHI;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LIST extends JFrame {
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
	private JTable ltable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LIST frame = new LIST();
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
	public LIST() {
		connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 696);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourKareshiList = new JLabel("YOUR KARESHI LIST");
		lblYourKareshiList.setForeground(Color.PINK);
		lblYourKareshiList.setBackground(Color.PINK);
		lblYourKareshiList.setFont(new Font("Segoe UI Light", Font.PLAIN, 60));
		lblYourKareshiList.setBounds(179, 41, 548, 62);
		contentPane.add(lblYourKareshiList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 156, 737, 403);
		contentPane.add(scrollPane);
		
		ltable = new JTable();
		scrollPane.setViewportView(ltable);
		
		JButton btnNewButton = new JButton("SEE LIST");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					pst = con.prepareStatement("select * from kareshi");
					rs = pst.executeQuery();
					
					ResultSetMetaData rsd = rs.getMetaData();
					d = (DefaultTableModel)ltable.getModel();
					
					int a = rsd.getColumnCount();
					String row[] = new String[a];
					
					for(int i = 0; i < a ; i++) {
						row[i] = rsd.getColumnName(i+1);
						d.setColumnIdentifiers(row);
						while(rs.next()) {
							String fname = rs.getString(1);
							String lname = rs.getString(2);
							String age = rs.getString(3);
							String gender = rs.getString(4);
							String username = rs.getString(5);
							String rate = rs.getString(6);
							String kid = rs.getString(7);
							String addrow[] = {fname,lname,age,gender,username,rate,kid};
							d.addRow(addrow);
						}
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnNewButton.setBounds(387, 593, 131, 35);
		contentPane.add(btnNewButton);
		
		JButton btn_back = new JButton("BACK");
		btn_back.setBackground(Color.PINK);
		btn_back.setForeground(Color.BLACK);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btn_back.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btn_back.setBounds(713, 589, 97, 42);
		contentPane.add(btn_back);
	}
	
	public void close() {
		HOME home = new HOME();
        home.setVisible(true);
        this.dispose();
	}
}

	
