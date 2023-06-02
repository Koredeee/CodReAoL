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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class RATE extends JFrame {

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
	private JTextField txt_id;
	private JComboBox comboBox_rate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RATE frame = new RATE();
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
	public RATE() {
		connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 696);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRateYourKareshi = new JLabel("RATE YOUR KARESHI");
		lblRateYourKareshi.setForeground(Color.PINK);
		lblRateYourKareshi.setBackground(Color.PINK);
		lblRateYourKareshi.setFont(new Font("Segoe UI Light", Font.PLAIN, 60));
		lblRateYourKareshi.setBounds(170, 32, 548, 62);
		contentPane.add(lblRateYourKareshi);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setLayout(null);
		panel.setBounds(144, 136, 604, 352);
		contentPane.add(panel);
		
		JButton btn_rste = new JButton("RATE UP");
		btn_rste.setBackground(Color.BLACK);
		btn_rste.setForeground(Color.PINK);
		btn_rste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int sid = Integer.parseInt(txt_id.getText());
					String rate = comboBox_rate.getSelectedItem().toString();
					pst = con.prepareStatement("update kareshi set rate = ? where kid = ?");
					pst.setString(1, rate);
					pst.setInt(2, sid);
					
					pst.executeUpdate();
					
					
					JOptionPane.showMessageDialog(contentPane, "Kareshi Rated");
					
					txt_id.setText(null);
					comboBox_rate.setSelectedIndex(-1);
					
					txt_id.requestFocus();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_rste.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btn_rste.setBounds(231, 297, 134, 23);
		panel.add(btn_rste);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(86, 40, 441, 214);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBackground(Color.PINK);
		txt_id.setBounds(178, 54, 98, 27);
		panel_1.add(txt_id);
		txt_id.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txt_id.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("RATING");
		lblNewLabel_2_2.setForeground(Color.PINK);
		lblNewLabel_2_2.setBounds(191, 116, 120, 32);
		panel_1.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		
		comboBox_rate = new JComboBox();
		comboBox_rate.setBackground(Color.PINK);
		comboBox_rate.setForeground(Color.BLACK);
		comboBox_rate.setModel(new DefaultComboBoxModel(new String[] {"SO BAD", "BAD", "NOT BAD", "MEDIOCRE", "GOOD", "MARVELOUS", "PERFECT"}));
		comboBox_rate.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		comboBox_rate.setBounds(100, 159, 258, 29);
		panel_1.add(comboBox_rate);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("KARESHI ID");
		lblNewLabel_2_2_1.setForeground(Color.PINK);
		lblNewLabel_2_2_1.setBounds(178, 11, 120, 32);
		panel_1.add(lblNewLabel_2_2_1);
		lblNewLabel_2_2_1.setBackground(Color.BLACK);
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		
		JButton btn_back = new JButton("BACK");
		btn_back.setBackground(Color.PINK);
		btn_back.setForeground(Color.BLACK);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btn_back.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btn_back.setBounds(144, 555, 97, 42);
		contentPane.add(btn_back);
	}
	public void close() {
		HOME home = new HOME();
        home.setVisible(true);
        this.dispose();
	}
}
