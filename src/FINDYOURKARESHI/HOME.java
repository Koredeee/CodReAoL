package FINDYOURKARESHI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HOME extends JFrame {
	
	int iid;
	String uName;
	String passw;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HOME frame = new HOME();
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
	public HOME() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME BACK,");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		lblNewLabel.setBounds(30, 31, 334, 40);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(30, 109, 322, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("YOUR IDEAL TYPE");
		btnNewButton_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnNewButton_1.setForeground(Color.PINK);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iclose();
			}
		});
		btnNewButton_1.setBounds(102, 30, 125, 50);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("FIND YOUR KARESHI");
		btnNewButton_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnNewButton_2.setForeground(Color.PINK);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fclose();
			}
		});
		btnNewButton_2.setBounds(83, 101, 156, 50);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BREAK UP");
		btnNewButton_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnNewButton_3.setForeground(Color.PINK);
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bclose();
			}
		});
		btnNewButton_3.setBounds(102, 310, 125, 50);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LOG OUT");
		btnNewButton_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnNewButton_4.setForeground(Color.PINK);
		btnNewButton_4.setBackground(Color.BLACK);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton_4.setBounds(102, 380, 125, 25);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3_1 = new JButton("RATE MY KARESHI");
		btnNewButton_3_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnNewButton_3_1.setForeground(Color.PINK);
		btnNewButton_3_1.setBackground(Color.BLACK);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rclose();
			}
		});
		btnNewButton_3_1.setBounds(102, 170, 125, 50);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("KARESHI LIST");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lclose();
			}
		});
		btnNewButton_3_1_1.setForeground(Color.PINK);
		btnNewButton_3_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnNewButton_3_1_1.setBackground(Color.BLACK);
		btnNewButton_3_1_1.setBounds(102, 240, 125, 50);
		panel.add(btnNewButton_3_1_1);
	}

	public HOME(int id, String uname, String pass) {
		this.uName = uname;
		this.passw = pass;
		this.iid = id;
	}
	public void close() {
		LOGIN home = new LOGIN();
        home.setVisible(true);
        this.dispose();
	}
	public void iclose() {
		IDEAL home = new IDEAL();
        home.setVisible(true);
        this.dispose();
	}
	public void fclose() {
		FIND home = new FIND();
        home.setVisible(true);
        this.dispose();
	}
	public void bclose() {
		BREAK home = new BREAK();
        home.setVisible(true);
        this.dispose();
	}
	public void rclose() {
		RATE home = new RATE();
        home.setVisible(true);
        this.dispose();
	}
	public void lclose() {
		LIST home = new LIST();
        home.setVisible(true);
        this.dispose();
	}

}
