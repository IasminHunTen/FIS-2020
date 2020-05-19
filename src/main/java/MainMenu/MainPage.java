package MainMenu;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

public class MainPage extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton search;
	private JCheckBox movies;
	private JCheckBox series;
	private JComboBox choice;
	private JComboBox choice_1;
	private JButton btnFilter;
	private JButton btnDefault;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnAdd;
	private DataMeneger dm;
	private ItemList list;
	private ArrayList<Item> database;
	private ArrayList<Item> copybase;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					   MainPage frame = new MainPage();
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
	public MainPage() {
		
	    dm=new DataMeneger();
	    list=dm.readItems();
	    database=list.getItems();
	    copybase=new ArrayList<Item>(database);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(20, 11, 286, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		search = new JButton("search");
		search.setFont(new Font("Tahoma", Font.BOLD, 14));
		search.setBounds(347, 10, 77, 23);
		search.addActionListener(this);
		contentPane.add(search);
		
	    movies = new JCheckBox("movies");
	    movies.addItemListener(this);
		movies.setBackground(new Color(128, 128, 128));
		movies.setHorizontalAlignment(SwingConstants.CENTER);
		movies.setBounds(70, 48, 97, 23);
		contentPane.add(movies);
		
		series = new JCheckBox("series");
		series.addItemListener(this);
		series.setBackground(Color.GRAY);
		series.setHorizontalAlignment(SwingConstants.CENTER);
		series.setBounds(205, 48, 97, 23);
		contentPane.add(series);
		
		choice = new JComboBox();
		choice.setBounds(90, 79, 237, 20);
		choice.addActionListener(this);
		choice.setEditable(true);
		contentPane.add(choice);
		
		JLabel lblItems = new JLabel("items :");
		lblItems.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItems.setHorizontalAlignment(SwingConstants.RIGHT);
		lblItems.setBounds(10, 82, 46, 14);
		contentPane.add(lblItems);
		
		JLabel lblGen = new JLabel("gen :");
		lblGen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGen.setHorizontalAlignment(SwingConstants.CENTER);
		lblGen.setBounds(357, 52, 46, 20);
		contentPane.add(lblGen);
		
		choice_1 = new JComboBox();
		choice_1.addActionListener(this);
		choice_1.setEditable(true);
		choice_1.setBounds(347, 79, 84, 20);
		contentPane.add(choice_1);
		
		JLabel lblStartYear = new JLabel("start year :");
		lblStartYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStartYear.setBounds(345, 115, 80, 14);
		contentPane.add(lblStartYear);
		
		textField_1 = new JTextField();
		textField_1.setBounds(347, 135, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEndYear = new JLabel("end year :");
		lblEndYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndYear.setBounds(345, 160, 80, 14);
		contentPane.add(lblEndYear);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(347, 180, 86, 20);
		contentPane.add(textField_2);
		
		btnFilter = new JButton("filter ");
		btnFilter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFilter.setBounds(347, 205, 89, 23);
		btnFilter.addActionListener(this);
		contentPane.add(btnFilter);
		
		btnDelete = new JButton("delete");
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(0, 113, 77, 30);
		btnDelete.addActionListener(this);
		contentPane.add(btnDelete);
		
		btnDefault = new JButton("default");
		btnDefault.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDefault.setBounds(347, 230, 89, 23);
		btnDefault.addActionListener(this);
		contentPane.add(btnDefault);
		
		btnEdit = new JButton("edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(0, 158, 77, 30);
		btnEdit.addActionListener(this);
		contentPane.add(btnEdit);
		
		btnAdd = new JButton("add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(0, 207, 77, 30);
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);
		
		
		this.setDefaultStatus(); 
	}
	
	public   void  setDefaultStatus() {
		 copybase=(ArrayList<Item>) database.clone();
		 choice.removeAllItems();
		 choice_1.removeAllItems();
		 ArrayList<String> gen=new ArrayList<String>();
		 choice.addItem("");
		 choice_1.addItem("");
		 for(int i=0;i<database.size();i++) {
			 choice.addItem(database.get(i).getTitle());
			 if(!gen.contains(database.get(i).getGen()))
				 gen.add(database.get(i).getGen());
		 } 
		 
		 for(String str:gen)
			 choice_1.addItem(str);
		 
		 textField.setText("");
		 textField_1.setText("");
		 textField_2.setText(""); 
		 movies.setSelected(false);
		 series.setSelected(false);
		 
		}
	
	public void callOutByName(String str) {
		choice.removeAllItems();
		ArrayList<String> rez=new ArrayList<String>();
	    String target=str.toLowerCase();
	    
	    for(Item it: copybase) {
	    	if(it.getTitle().toLowerCase().contains(target))
	    		rez.add(it.getTitle());
	    }
	    
	    choice.addItem("");
	    if(rez.size()>0)
	    for(String title : rez) 
	    	choice.addItem(title);
	    movies.setEnabled(false);
	    series.setEnabled(false);
	  
	}
	
	public void filter(String gen,Integer y1,Integer y2) {
		ArrayList<Item> rez=new ArrayList<Item>(copybase);
		
		if(gen!=null) {
			for(int i=0;i<rez.size();i++)
				if(!rez.get(i).getGen().equals(gen))
                  rez.remove(i);
		}
		if(y1!=null) {
		  for(int i=0;i<rez.size();i++)
			  if(rez.get(i).getYear()<y1)
				  rez.remove(i);
		  
		}
		
		if(y2!=null) {
			for(int i=0;i<rez.size();i++)
				if(rez.get(i).getYear()>y2)
					rez.remove(i);
		}
		
	    choice.removeAllItems();
	    
	    choice.addItem("");
	    for(Item it:rez) {
	    	choice.addItem(it.getTitle());
	    }
	
	}
	
    
	public void onlyOneFictionary(Class<? extends Item> cla) {
		choice.removeAllItems();
		choice.addItem("");
		for(Item it: copybase) 
			if(it.getClass()==cla) 
				choice.addItem(it.getTitle());
	}
	
	public void kill(String tokill) {
		for(Item it : database) {
			if(it.getTitle().equals(tokill));
			database.remove(it);
		    break;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnDefault)
			this.setDefaultStatus();
	    if(e.getSource()==search) 
	    	this.callOutByName(textField.getText());
	    if(e.getSource()==btnFilter){
	    	String p1=null;
	    	Integer p2=null,p3=null;
	        if(choice_1.getSelectedIndex()>0)
	        	p1=choice_1.getSelectedItem().toString();
	        if(!textField_1.getText().isEmpty()) 
	        	p2=Integer.parseInt(textField_1.getText());
	        if(!textField_2.getText().isEmpty()) 
	        	p3=Integer.parseInt(textField_2.getText());
	        this.filter(p1, p2, p3);  
	    }
	    
	      if(e.getSource()==btnDelete) {
	    	  System.out.println(database.toString());
	    	  if(choice.getSelectedIndex()>0) {
	    		  this.kill(choice.getSelectedItem().toString());
	    		  choice.removeItemAt(choice.getSelectedIndex());
	    	  }
	    	  System.out.println(database.toString());
	      }
	    	  
	    
	    
	       
		
	}

	public void itemStateChanged(ItemEvent e) {
		if(movies.isSelected()) {
		      this.onlyOneFictionary(Movie.class);   
		      series.setSelected(false);
		    }
		    
		if(series.isSelected()) {
		  	this.onlyOneFictionary(Series.class);
		    movies.setSelected(false);
		    }
	}
}
