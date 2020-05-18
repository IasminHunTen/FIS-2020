package MainMenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;

public class AddItem extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewButton; 
	private JButton btnNewButton_1;
	private JButton btnAddActor;
	private JButton btnClean;
	private ItemList list;
	private DataMeneger dm;
    private ArrayList<String> act=new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AddItem frame = new AddItem();
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
	public AddItem() {
		dm=new DataMeneger();
		list=dm.readItems();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("title :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 36, 69, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblGen = new JLabel("gen :");
		lblGen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGen.setBounds(12, 64, 79, 17);
		contentPane.add(lblGen);
		
		textField = new JTextField();
		textField.setBounds(115, 36, 287, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 64, 287, 20);
		contentPane.add(textField_1);
		
		JLabel lblMainPlot = new JLabel("main plot :");
		lblMainPlot.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMainPlot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainPlot.setBounds(12, 93, 81, 20);
		contentPane.add(lblMainPlot);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 95, 287, 20);
		contentPane.add(textField_2);
		
		JLabel label = new JLabel("");
		label.setBounds(45, 133, 46, 14);
		contentPane.add(label);
		
		JLabel lblYear = new JLabel(" year :");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(45, 133, 46, 20);
		contentPane.add(lblYear);
		
		textField_3 = new JTextField();
		textField_3.setBounds(115, 133, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblActors = new JLabel("actors :");
		lblActors.setHorizontalAlignment(SwingConstants.RIGHT);
		lblActors.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActors.setBounds(22, 174, 69, 14);
		contentPane.add(lblActors);
		
		btnAddActor = new JButton("add actor");
		btnAddActor.addActionListener(this);
		btnAddActor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddActor.setBounds(115, 172, 113, 23);
		contentPane.add(btnAddActor);
		
		chckbxNewCheckBox = new JCheckBox("series");
		chckbxNewCheckBox.setBackground(Color.GRAY);
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(32, 205, 59, 23);
		contentPane.add(chckbxNewCheckBox);
		
	    btnNewButton = new JButton("add new item");
	    btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(134, 207, 142, 23);
		contentPane.add(btnNewButton);
		
	    btnNewButton_1 = new JButton("back");
	    btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(313, 207, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblItemFactory = new JLabel("Item factory");
		lblItemFactory.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemFactory.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblItemFactory.setBounds(92, 0, 243, 25);
		contentPane.add(lblItemFactory);
		
	    btnClean = new JButton("Clean");
	    btnClean.addActionListener(this);
		btnClean.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClean.setBounds(313, 133, 89, 23);
		contentPane.add(btnClean);
		
	
	}

	public void actionPerformed(ActionEvent e) {
		 
		 ArrayList<Integer> sez=new ArrayList<Integer>();
		 int selected,sez_cnt,sez_i;
		 String aux;
		 Item nou;
		 if(e.getSource()==btnAddActor) {
			 aux=JOptionPane.showInputDialog(null,"Add new actor");
			 act.add(aux);
		 }
		 if(e.getSource()==btnNewButton) {
		 if(chckbxNewCheckBox.isSelected()) {
			 nou=new Series();
			 aux=JOptionPane.showInputDialog(null,"How many seasons has this series ?");
			 sez_cnt=Integer.parseInt(aux);
			 for(int i=0;i<sez_cnt;i++) {
				 aux=JOptionPane.showInputDialog(null,"How many episodes has season "+(i+1)+"?");
				 sez_i =Integer.parseInt(aux);
				 sez.add(sez_i);
			 }
			 ((Series)nou).setSeasons(sez);
		 }else
			 nou=new Movie();
	      nou.setTitle(textField.getText());
	      nou.setGen(textField_1.getText());
	      nou.setMainPlot(textField_2.getText());
	      int an=Integer.parseInt(textField_3.getText());
	      nou.setYear(an);
	      nou.setActors(act);
	      list.addItem(nou);	 
		 }
		 if(e.getSource()==btnClean) {
			 textField.setText("");
			 textField_1.setText("");
			 textField_2.setText("");
			 textField_3.setText("");
			 act.clear();
			 sez.clear();
		 }
		 
		 if(e.getSource()==btnNewButton_1) {
			 dm.writeItems(list);
		 }
		
	}
}


