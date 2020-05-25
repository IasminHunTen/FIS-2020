package Search;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import MainMenu.*;
import PlayTime.Main;
import register.Client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Color;

public class Site extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton Play;
	private JButton Aplly;
	private JButton acces;
	private JRadioButton rb2;
	private JRadioButton rb1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton Search;
	private DataMeneger dm;
	private ItemList il;
	private ArrayList<Item> database=new ArrayList<Item>();
	private ArrayList<Comp> temp=new ArrayList<Comp>();
	private ArrayList<Comp> db=new ArrayList<Comp>();
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton Default;
	private static Client cl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		cl=new Client("iasmin","HunTen");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Site frame = new Site(cl);
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
	public Site(Client cl) {
		dm=new DataMeneger();
		il=dm.readItems();
		database=il.getItems();
		this.cl=cl;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMoviesAndSeries = new JLabel("Movies and Series Online");
		lblMoviesAndSeries.setFont(new Font("French Script MT", Font.BOLD, 24));
		lblMoviesAndSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoviesAndSeries.setBounds(120, 23, 383, 32);
		contentPane.add(lblMoviesAndSeries);
		
		textField = new JTextField();
		textField.setBounds(120, 64, 319, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	    Search = new JButton("search");
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(445, 63, 89, 23);
		Search.addActionListener(this);
		contentPane.add(Search);
		
	    comboBox = new JComboBox();
		comboBox.setBounds(120, 95, 318, 20);
		comboBox.addActionListener(this);
		contentPane.add(comboBox);
		
		rb1 = new JRadioButton("movies");
		rb1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rb1.setBounds(445, 94, 89, 23);
		rb1.addItemListener(this);;
		contentPane.add(rb1);
		
		rb2 = new JRadioButton("series");
		rb2.setFont(new Font("Tahoma", Font.BOLD, 14));
		rb2.setBounds(445, 120, 89, 23);
		rb2.addItemListener(this);
		contentPane.add(rb2);
		
		acces = new JButton("acces");
		acces.setFont(new Font("Tahoma", Font.BOLD, 14));
		acces.setBounds(445, 171, 89, 23);
		acces.addActionListener(this);;
		contentPane.add(acces);
		
		JLabel lblMyQueue = new JLabel("my queue");
		lblMyQueue.setFont(new Font("French Script MT", Font.PLAIN, 20));
		lblMyQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyQueue.setBounds(445, 150, 80, 17);
		contentPane.add(lblMyQueue);
		
		JLabel lblFilters = new JLabel("filters");
		lblFilters.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilters.setFont(new Font("French Script MT", Font.PLAIN, 20));
		lblFilters.setBounds(20, 206, 80, 17);
		contentPane.add(lblFilters);
		
		Aplly = new JButton("aplly");
		Aplly.setFont(new Font("Tahoma", Font.BOLD, 14));
		Aplly.setBounds(20, 225, 89, 23);
		Aplly.addActionListener(this);
		contentPane.add(Aplly);
		
		Play = new JButton("play");
		Play.setFont(new Font("Tahoma", Font.BOLD, 14));
		Play.setBounds(445, 250, 89, 23);
		Play.addActionListener(this);
		contentPane.add(Play);
		
		JLabel lblBeginYear = new JLabel("begin year");
		lblBeginYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeginYear.setFont(new Font("French Script MT", Font.BOLD, 20));
		lblBeginYear.setBounds(10, 67, 100, 14);
		contentPane.add(lblBeginYear);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 87, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEndYear = new JLabel("end year");
		lblEndYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndYear.setFont(new Font("French Script MT", Font.BOLD, 20));
		lblEndYear.setBounds(10, 115, 100, 14);
		contentPane.add(lblEndYear);
		
		textField_2 = new JTextField();
		textField_2.setBounds(20, 132, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblGen = new JLabel("gen");
		lblGen.setHorizontalAlignment(SwingConstants.CENTER);
		lblGen.setFont(new Font("French Script MT", Font.BOLD, 20));
		lblGen.setBounds(10, 147, 100, 30);
		contentPane.add(lblGen);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(20, 175, 90, 20);
		comboBox_1.addActionListener(this);
		contentPane.add(comboBox_1);
		
		Default = new JButton("default");
		Default.setFont(new Font("Tahoma", Font.BOLD, 14));
		Default.setBounds(20, 252, 89, 23);
		Default.addActionListener(this);
		contentPane.add(Default);
		this.setGens();
		this.CompDefault();
	}
	
	class Comp{
		private int id;
		private Item it;
		
		public Comp(int id, Item it) {
			super();
			this.id = id;
			this.it = it;
		}
        
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Item getIt() {
			return it;
		}
		public void setIt(Item it) {
			this.it = it;
		}


		@Override
		public String toString() {
			return  id +": "+ it.getTitle();
		}
		
	}
	
	public void CompDefault() {	
	  for (int i=0;i<database.size();i++)
		  temp.add(new Comp(i,database.get(i))); 
	  for (Comp c : temp) {
		  comboBox.addItem(c.toString());
	  }
	}
	
	
	public void setGens() {
		ArrayList<String> gen=new ArrayList<String>();
		for(Item it: database)
		   if(!gen.contains(it.getGen()))
			   gen.add(it.getGen());
		comboBox_1.addItem("");
		for(String str: gen)
			comboBox_1.addItem(str);
	}
	
	public static int getIndex(String s) {
		int rez;
		String str[]=s.split(":");
		rez=Integer.parseInt(str[0]);
		return rez;
	}
	
	public void searchProces(String target){
		ArrayList<Comp> src=new ArrayList<Comp>();
		comboBox.removeAllItems();
        String sir=target.toLowerCase();
        for(Comp c:temp) 
        	if(c.getIt().getTitle().toLowerCase().contains(sir)) 
        		src.add(c);
        for (Comp c1:src) 
        	comboBox.addItem(c1.toString());
       
	}
	
	 public int verify(JTextField tf) {
	    	int safe=0;
	    	try {
	    		 safe=Integer.parseInt(tf.getText());
	    		 return safe;
	    	}catch(NumberFormatException e) {
	    		tf.setText(JOptionPane.showInputDialog("plese insert an number"));
	    		verify(tf);
	    	}
			return safe;
      }
	 
	 public void typeItems(Class<? extends Item> cla) {
		 comboBox.removeAllItems();
		 for(Comp it: temp)
			 if(it.getIt().getClass()==cla)
				 comboBox.addItem(it.toString());
	  }
	 
	 public void filt(String p1,Integer p2,Integer p3) {
	        ArrayList<Integer> mark =new ArrayList<Integer>();
	        db=(ArrayList<Comp>) temp.clone();
	    	if(p1!=null) {
	    		for(int i=0;i<db.size();i++)
	    			if(!p1.equals(db.get(i).getIt().getGen()))
	    				if(!mark.contains(i))
	    				    mark.add(i);
	    	}
	    	
	    	
	    	if(p2!=null) {
	    		for(int i=0;i<db.size();i++)
	    			if(p2>db.get(i).getIt().getYear())
	    				if(!mark.contains(i))
	    				    mark.add(i);
	    	}
	    	System.out.println(mark);
	    	if(p3!=null) {
	    		for(int i=0;i<db.size();i++)
	    			if(p3<db.get(i).getIt().getYear())
	    				if(!mark.contains(i))
	    				    mark.add(i);
	    	}
	    	System.out.println(mark);
	    	
	    	
	    	Collections.sort(mark);
	    	System.out.println(mark);
	    	Collections.reverse(mark);
	    	System.out.println(mark);
	    	for(Integer i: mark)
	    		db.remove(i.intValue());
	    	
	    }

	 
	 
	 
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Search)
			this.searchProces(textField.getText());
		if(e.getSource()==Aplly) {
			String p1=null;
	    	Integer p2=null,p3=null;
	    	if(comboBox_1.getSelectedIndex()>0)
	    		p1=comboBox_1.getSelectedItem().toString();
	    	if(!textField_1.getText().isEmpty()) 
	    		p2=verify(textField_1);
	    	if(!textField_2.getText().isEmpty()) 
	    		p3=verify(textField_2);
	    	this.filt(p1, p2, p3);
			comboBox.removeAllItems();
			for(Comp c : db)
				comboBox.addItem(c);
		}
	    if(e.getSource()==Play) {
	    	String str=comboBox.getSelectedItem().toString();
	    	int choice=getIndex(str);
	    	new Main(database.get(choice),cl).setVisible(true);
	    	this.setVisible(false);
	    	this.dispose();
	    }
	    
	    if(e.getSource()==Default) {
	    	rb1.setSelected(false);
	    	rb2.setSelected(false);
	    	textField.setText("");
	    	textField_1.setText("");
	    	textField_2.setText("");
	    	comboBox.removeAllItems();
	    	 for (Comp c : temp) 
	   		  comboBox.addItem(c.toString());
	    }
		
	}

	public void itemStateChanged(ItemEvent arg0) {
		if(rb1.isSelected()) {
			this.typeItems(Movie.class);
			rb2.setSelected(false);
		}
		if(rb2.isSelected()) {
			this.typeItems(Series.class);
			rb1.setSelected(false);
		}
	}
}
