package Search;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Color;

public class Site extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Site frame = new Site();
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
	public Site() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMoviesAndSeries = new JLabel("Movies and Series Online");
		lblMoviesAndSeries.setFont(new Font("French Script MT", Font.BOLD, 24));
		lblMoviesAndSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoviesAndSeries.setBounds(21, 23, 383, 32);
		contentPane.add(lblMoviesAndSeries);
		
		textField = new JTextField();
		textField.setBounds(20, 64, 319, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(345, 63, 89, 23);
		contentPane.add(btnSearch);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 95, 318, 20);
		contentPane.add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("movies");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(345, 94, 89, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnSeries = new JRadioButton("series");
		rdbtnSeries.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnSeries.setBounds(345, 120, 89, 23);
		contentPane.add(rdbtnSeries);
		
		JButton btnNewButton = new JButton("acces");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(345, 171, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblMyQueue = new JLabel("my queue");
		lblMyQueue.setFont(new Font("French Script MT", Font.PLAIN, 20));
		lblMyQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyQueue.setBounds(345, 150, 80, 17);
		contentPane.add(lblMyQueue);
		
		JLabel lblFilters = new JLabel("filters");
		lblFilters.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilters.setFont(new Font("French Script MT", Font.PLAIN, 20));
		lblFilters.setBounds(345, 199, 80, 17);
		contentPane.add(lblFilters);
		
		JButton btnAplly = new JButton("aplly");
		btnAplly.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAplly.setBounds(345, 216, 89, 23);
		contentPane.add(btnAplly);
	}
}
