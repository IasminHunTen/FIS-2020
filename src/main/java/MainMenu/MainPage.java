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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JButton btnMark;
	private DataMeneger dm;
	private ArrayList<Item> database;
	private ArrayList<Element> copybase;
    private ArrayList<Integer> mark;

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
	    database=new ArrayList<Item>();
	    copybase=new ArrayList<Element>();
	    mark=new ArrayList<Integer>();
	    
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
		search.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		btnEdit.setBounds(0, 188, 77, 30);
		btnEdit.addActionListener(this);
		contentPane.add(btnEdit);
		
		btnAdd = new JButton("add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(0, 227, 77, 30);
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);
		
	    btnMark = new JButton("mark");
		btnMark.setHorizontalAlignment(SwingConstants.LEFT);
		btnMark.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMark.setBounds(0, 150, 77, 30);
		btnMark.addActionListener(this);
		contentPane.add(btnMark);
		
		this.init();
		this.setDefaultStatus(); 
	}
	
       class Element{
    	 private int index;
    	 private Item it;
    	 
	
    	public Element(int index, Item it) {
			this.index = index;
			this.it = it;
		}

		public int getIndex() {
			return index;
		}
	
		public Item getIt() {
			return it;
		}

		@Override
		public String toString() {
			return index+": "+it.getTitle();
		}
		
    	
		
       }
       
       
	
	public   void  setDefaultStatus() {
		 
		 choice.removeAllItems();
		 choice.addItem("");
		 for(Element el:copybase)
			 choice.addItem(el.toString());
		 
		 textField.setText("");
		 textField_1.setText("");
		 textField_2.setText(""); 
		 movies.setSelected(false);
		 series.setSelected(false);
		 
		}
	
	public void init() {
	  database.clear();
	  copybase.clear();
	  database=dm.readItems().getItems();
	  ArrayList<String> gen=new ArrayList<String>();
		for(int i=0;i<database.size();i++) {
			copybase.add(new Element(i,database.get(i)));
			if(!gen.contains(database.get(i).getGen()))
			   gen.add(database.get(i).getGen());
		}   
		choice_1.addItem("");
		for(String str : gen)
			choice_1.addItem(str);
	}
	
	public void writeElement(ArrayList<Element> el) {
		choice.removeAllItems();
		choice.addItem("");
		for(Element e:el)
			choice.addItem(e.toString());
	}
	
	public void callOutByName(String str) {

		ArrayList<Element> rez=new ArrayList<Element>();
	    String target=str.toLowerCase();
	    
	    for(Element it: copybase) {
	    	if(it.getIt().getTitle().toLowerCase().contains(target))
	    		rez.add(it);
	    }
	    
	    this.writeElement(rez);
	  
	}
	
	public int getTarget(String str){
		String[] aux=str.split(":");
	    int rez=Integer.parseInt(aux[0]);
		return rez;
	}
	
	
	public void filter(String gen,Integer y1,Integer y2) {
		ArrayList<Element> rez=new ArrayList<Element>(copybase);
		
		if(gen!=null) {
			for(int i=0;i<rez.size();i++)
				if(!rez.get(i).getIt().getGen().equals(gen))
                  rez.remove(i);
		}
		if(y1!=null) {
		  for(int i=0;i<rez.size();i++)
			  if(rez.get(i).getIt().getYear()<y1)
				  rez.remove(i);
		  
		}
		
		if(y2!=null) {
			for(int i=0;i<rez.size();i++)
				if(rez.get(i).getIt().getYear()>y2)
					rez.remove(i);
		}
		
	    this.writeElement(rez);
	
	}
	
    
	public void onlyOneFictionary(Class<? extends Item> cla) {
		ArrayList<Element> rez=new ArrayList<Element>();
		for(Element it: copybase) 
			if(it.getIt().getClass()==cla) 
				rez.add(it);
		this.writeElement(rez);
	}
	
	public void del(int x) {
		if(x==0) {
			System.out.println("No Item Selected");
			return;
		}
		
	    int decision=JOptionPane.showConfirmDialog(null," Are you sore you want to delete item : "+choice.getItemAt(x));
		if(JOptionPane.YES_OPTION==decision) {
			int d=getTarget(choice.getItemAt(x).toString());
			if(!mark.contains(d))
				mark.add(d);
			choice.removeItemAt(x);
		
		}
			
	}
	
	
	
	public void systemRealise() {
		Collections.sort(mark);
		Collections.reverse(mark);
		for(Integer it:mark)
			database.remove(it.intValue());
		dm.writeItems(new ItemList(database));
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
	    
	      if(e.getSource()==btnMark) {      
	       this.del(choice.getSelectedIndex());
	      }
	      
	      if(e.getSource()==btnDelete) {
	    	  this.systemRealise();
	    	  this.init();
	    	  this.setDefaultStatus();
	      }
	    	  
	      if(e.getSource()==btnAdd) {
            this.setVisible(false);
            this.dispose();
	    	new AddItem().setVisible(true);;
	      }
	      if(e.getSource()==btnEdit) {
	    	 int next=choice.getSelectedIndex();
	    	
	    	 if(next==0) {
	    		 System.out.println("No Item Selected");
	    	 }else {
	         next=getTarget(choice.getSelectedItem().toString());	
	       
	   	     this.setVisible(false);
	   	     this.dispose();
	   	     new EditItem(next).setVisible(true);
	    	 }
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
