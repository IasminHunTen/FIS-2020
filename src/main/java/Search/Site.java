package Search;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import MainMenu.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Color;

public class Site extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton Play;
	private JButton Aplly;
	private JButton acces;
	private JRadioButton rb2;
	private JRadioButton rb1;
	private JComboBox comboBox;
	private JButton Search;
	private DataMeneger dm;
	private ItemList il;
	private ArrayList<Item> database=new ArrayList<Item>();
	private ArrayList<Comp> temp=new ArrayList<Comp>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Site frame = new Site();
					frame.setVisible(true);
					System.out.println(getIndex("4: ydbevcfj"));
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
		dm=new DataMeneger();
		il=dm.readItems();
		database=il.getItems();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
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
		
	    Search = new JButton("search");
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(345, 63, 89, 23);
		Search.addActionListener(this);
		contentPane.add(Search);
		
	    comboBox = new JComboBox();
		comboBox.setBounds(21, 95, 318, 20);
		comboBox.addActionListener(this);
		contentPane.add(comboBox);
		
		rb1 = new JRadioButton("movies");
		rb1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rb1.setBounds(345, 94, 89, 23);
		rb1.addActionListener(this);
		contentPane.add(rb1);
		
		rb2 = new JRadioButton("series");
		rb2.setFont(new Font("Tahoma", Font.BOLD, 14));
		rb2.setBounds(345, 120, 89, 23);
		rb2.addActionListener(this);
		contentPane.add(rb2);
		
		acces = new JButton("acces");
		acces.setFont(new Font("Tahoma", Font.BOLD, 14));
		acces.setBounds(345, 171, 89, 23);
		acces.addActionListener(this);;
		contentPane.add(acces);
		
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
		
		Aplly = new JButton("aplly");
		Aplly.setFont(new Font("Tahoma", Font.BOLD, 14));
		Aplly.setBounds(345, 216, 89, 23);
		Aplly.addActionListener(this);
		contentPane.add(Aplly);
		
		Play = new JButton("play");
		Play.setFont(new Font("Tahoma", Font.BOLD, 14));
		Play.setBounds(345, 250, 89, 23);
		Play.addActionListener(this);
		contentPane.add(Play);
		
		this.CompDefault();
	}
	
	class Comp{
		private int id;
		private String ttl;
		public Comp(int id, String ttl) {
			super();
			this.id = id;
			this.ttl = ttl;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTtl() {
			return ttl;
		}
		public void setTtl(String ttl) {
			this.ttl = ttl;
		}
		@Override
		public String toString() {
			return  id +": "+ ttl;
		}
		
	}
	
	public void CompDefault() {
	  for (int i=0;i<database.size();i++)
		  temp.add(new Comp(i,database.get(i).getTitle())); 
	  for (Comp c : temp) {
		  comboBox.addItem(c.toString());
	  }
	}
	
	public static int getIndex(String s) {
		int rez;
		String str[]=s.split(":");
		rez=Integer.parseInt(str[0]);
		return rez;
	}
    
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
