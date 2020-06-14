package queue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.ObjectMapper;

import MainMenu.Item;
import MainMenu.ItemList;
import MainMenu.Movie;
import Search.Site;
import register.Client;
import register.RegisterInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class QueueInterface extends JFrame  implements ActionListener{

	private JPanel contentPane;
	private JButton backButton;
	private JButton selectButton;
	private JButton deleteButton;
	private JComboBox<String> comboBoxQueue;
	private Client cl;
	private ItemList il;
	private ObjectMapper omap;
	
	public static void main(String[] args) {
			Client c=new Client("user","hass");
			ArrayList<String> a=new ArrayList<String>();
			a.add("fas");
			Item it=new Movie("a","a",4,"x",a);
			c.addItem(it);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						QueueInterface frame = new QueueInterface(c);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
	
	public QueueInterface(Client cl) {
		
		this.cl=cl;
		omap=new ObjectMapper();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 438);
		contentPane=new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Queue");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(254, 23, 62, 29);
		getContentPane().add(lblNewLabel);
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBounds(27, 308, 89, 23);
		contentPane.add(backButton);
		
		selectButton = new JButton("Select");
		selectButton.addActionListener(this);
		selectButton.setBounds(440, 308, 89, 23);
		contentPane.add(selectButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		deleteButton.setBounds(440, 254, 89, 23);
		contentPane.add(deleteButton);
		
		comboBoxQueue = new JComboBox<String>();
		comboBoxQueue.setBounds(27, 63, 404, 20);
		contentPane.add(comboBoxQueue);
		comboBoxQueue.addItem("");
		File f=new File("Queue Database/"+cl.getPlayList()+".json");
		if(!f.exists() || f.length()==0)
			 il= new ItemList();
		try {
			if(f.length()!=0)
				il=omap.readerFor(ItemList.class).readValue(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Item> iList=il.getItems();
		for(int i=0;i<iList.size();i++) {
			comboBoxQueue.addItem(iList.get(i).getTitle());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			this.setVisible(false);
            this.dispose();
            new Site(cl).setVisible(true);
		}
		else if (e.getSource()==selectButton) {
			//a
		}
		else if (e.getSource()==deleteButton) {
			String itemName=comboBoxQueue.getSelectedItem().toString();
			ArrayList<Item> iList=il.getItems();
			//Cauta filmul sau serialul dupa titlu, in loc de un id cum ar fi normal,
			//
			for(int i=0;i<iList.size();i++)
				if(iList.get(i).getTitle().equals(itemName))
					cl.removeItem(iList.get(i));
			//redeschide interfata, cu item-ul eliminat din lista
			this.setVisible(false);
            this.dispose();
            new QueueInterface(cl).setVisible(true);
		}
	}
}
