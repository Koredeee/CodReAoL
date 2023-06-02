package FINDYOURKARESHI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IDEAL extends JFrame {
	
//	String crit;
//	String req;
	
	
	Connection con;
	PreparedStatement pst;	
	ResultSet rs;
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
	private JTextField textreq;
	private JComboBox comboBox_cri;
	private JTable ctable;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IDEAL frame = new IDEAL();
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
	public IDEAL() {
		connect();
		
		
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 696);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WHAT IS YOUR IDEAL TYPE?");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 60));
		lblNewLabel.setBounds(10, 11, 744, 58);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(58, 136, 428, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CRITERIA");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(177, 27, 133, 19);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("REQUIREMENT");
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(153, 114, 126, 28);
		panel.add(lblNewLabel_2);
		
		comboBox_cri = new JComboBox();
		comboBox_cri.setForeground(Color.PINK);
		comboBox_cri.setBackground(Color.BLACK);
		comboBox_cri.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		comboBox_cri.setModel(new DefaultComboBoxModel(new String[] {"HEIGHT", "NATIONALITY", "AGE", "HOBBY", "RELIGION"}));
		comboBox_cri.setBounds(65, 62, 310, 28);
		panel.add(comboBox_cri);
		
		textreq = new JTextField();
		textreq.setForeground(Color.PINK);
		textreq.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		textreq.setBackground(Color.BLACK);
		textreq.setBounds(67, 153, 308, 28);
		panel.add(textreq);
		textreq.setColumns(10);
		
		JButton btnsave = new JButton("SAVE");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					String crit = comboBox_cri.getSelectedItem().toString();
					String req = textreq.getText();
					pst = con.prepareStatement("insert into ideal(criteria,requirement)values(?,?)");
					pst.setString(1, crit);
					pst.setString(2, req);
					pst.executeUpdate();
					
					
					JOptionPane.showMessageDialog(contentPane, "ideal type added");
					
					comboBox_cri.setSelectedIndex(-1);
					textreq.setText("");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
			
			
			
		});
		
		
	
		
		btnsave.setBackground(Color.BLACK);
		btnsave.setForeground(Color.PINK);
		btnsave.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnsave.setBounds(177, 205, 64, 23);
		panel.add(btnsave);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton.setForeground(Color.PINK);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		
		btnNewButton.setBounds(58, 476, 126, 35);
		contentPane.add(btnNewButton);
//		ctable.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				d = (DefaultTableModel)ctable.getModel();
//				int indx= ctable.getSelectedRow();
//				String iid = d.getValueAt(indx, 0).toString();
//				comboBox_cri.setSelectedItem(d.getValueAt(indx, 1));
//				textreq.setText(d.getValueAt(indx, 2).toString());
//				
//			}
//		});
		
	
		
		JLabel lblNewLabel_3 = new JLabel("CANT SEE IT? CLICK REFRESH");
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(479, 547, 164, 20);
		contentPane.add(lblNewLabel_3);
		
		JButton btnrefresh = new JButton("REFRESH");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cload();
				
			}
		});
		btnrefresh.setForeground(Color.PINK);
		btnrefresh.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnrefresh.setBackground(Color.BLACK);
		btnrefresh.setBounds(640, 544, 75, 23);
		contentPane.add(btnrefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(611, 136, 219, 328);
		contentPane.add(scrollPane);
		
		ctable = new JTable();
		scrollPane.setViewportView(ctable);
		
	}
	
	public void cload() {
		
		try {
			pst = con.prepareStatement("select * from ideal");
			rs = pst.executeQuery();
			
			ResultSetMetaData rsd = rs.getMetaData();
			d = (DefaultTableModel)ctable.getModel();
			
			int a1 = rsd.getColumnCount();
			String row[] = new String[a1];
			
			for(int i = 0; i < a1 ; i++) {
				
				row[i] = rsd.getColumnName(i+1);
				d.setColumnIdentifiers(row);
				while(rs.next()) {
					String cri = rs.getString(1);
					String req = rs.getString(2);
					
					String addrow[] = {cri,req};
					d.addRow(addrow);
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void close() {
		HOME home = new HOME();
        home.setVisible(true);
        this.dispose();
	}
}
