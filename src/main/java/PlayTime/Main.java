package PlayTime;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.TextArea;

import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import MainMenu.Item;
import MainMenu.Movie;
import MainMenu.Series;
import Search.Site;
import register.Client;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static Item it;
	private static Client cl;
	private JButton back;
	private JRadioButton rba;
	private JRadioButton rbmp;
	private JComboBox cb1;
	private JComboBox cb;
	private JButton aq;
	private JButton play;
	private JLabel lblEpisode;
	private JLabel lblSeason;
	private JTextArea ta;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> act=new ArrayList();
		act.add("aa");
		act.add("bb");
		act.add("cc");
		ArrayList<Integer> sez =new ArrayList<Integer>();
		sez.add(10);
		sez.add(20);
		sez.add(15);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main(it,cl);
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
	public Main(Item it,Client cl) {
		this.it=it;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel(it.getTitle());
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Script MT Bold", Font.ITALIC, 35));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 24, 424, 43);
		contentPane.add(title);
		
	    play = new JButton("Play");
		play.setBackground(new Color(0, 128, 0));
		play.setFont(new Font("Stencil", Font.PLAIN, 11));
		play.setBounds(330, 200, 89, 50);
		play.addActionListener(this);
		contentPane.add(play);
		
		aq = new JButton("Add to queue");
		aq.setBackground(new Color(0, 0, 255));
		aq.setFont(new Font("Stencil", Font.PLAIN, 11));
		aq.setBounds(10, 200, 107, 50);
		aq.addActionListener(this);
		contentPane.add(aq);
		
	    ta= new JTextArea(10,20);
		
		ta.setBackground(Color.GRAY);
		ta.setBounds(72, 78, 229, 114);
		ta.setText(it.getMainPlot());
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setEditable(false);
		contentPane.add(ta);
		
		JLabel lblYear = new JLabel(String.valueOf(it.getYear()));
		lblYear.setFont(new Font("Vivaldi", Font.BOLD, 22));
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(0, 98, 46, 28);
		contentPane.add(lblYear);
		
		JLabel lblGen = new JLabel(it.getGen());
		lblGen.setHorizontalAlignment(SwingConstants.CENTER);
		lblGen.setFont(new Font("Vivaldi", Font.BOLD, 16));
		lblGen.setBounds(0, 143, 60, 28);
		contentPane.add(lblGen);
		
	    lblSeason = new JLabel("season");
		lblSeason.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeason.setBounds(147, 200, 46, 14);
		contentPane.add(lblSeason);
		
	    lblEpisode = new JLabel("episode");
		lblEpisode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEpisode.setBounds(245, 200, 46, 14);
		contentPane.add(lblEpisode);
		
	    cb = new JComboBox();
		cb.setBounds(130, 225, 80, 20);
		cb.addActionListener(this);
		contentPane.add(cb);
		
		cb1 = new JComboBox();
		cb1.setBounds(227, 225, 85, 20);
		cb1.addActionListener(this);
		contentPane.add(cb1);
		
		rbmp = new JRadioButton("main plot");
		rbmp.setBounds(315, 79, 109, 23);
		rbmp.addActionListener(this);
		contentPane.add(rbmp);
		
	    rba = new JRadioButton("actors");
		rba.setForeground(new Color(0, 0, 0));
		rba.setSelected(true);
		rba.setBounds(315, 120, 109, 23);
		rba.addActionListener(this);
		contentPane.add(rba);
		
	    back = new JButton("back");
		back.setFont(new Font("Tahoma", Font.BOLD, 14));
		back.setBounds(0, 0, 89, 23);
		back.addActionListener(this);
		contentPane.add(back);
		this.setUp();
	}
	
	
	
	private void setUp() {
		if(it instanceof Movie) {
		 lblSeason.setVisible(false);
		 lblEpisode.setVisible(false);
		 cb.setEnabled(false);
		 cb1.setEnabled(false);
		 cb.setVisible(false);
		 cb1.setVisible(false);
		}else {	
         Series s=(Series) it;
         for(int i=0;i<s.getSeasons().size();i++)
        	 cb.addItem("Season "+(i+1));
		}

	}
	
	private void setEpisodeList(int len) {
		cb1.removeAllItems();
		for(int i=0;i<len;i++)
			cb1.addItem("Episode "+(i+1));
	}

	public void actionPerformed(ActionEvent e) {
	     	if(rbmp.isSelected()) {
	     	  ta.setText(it.getMainPlot());
	     	  rba.setSelected(false);
	     	}
	     	if(rba.isSelected()) {
	          String rez=new String();
	          for(int i=0;i<it.getActors().size();i++)
	        	  rez+=it.getActors().get(i)+"\n";
	          ta.setText(rez);
	          rbmp.setSelected(false);
	     	}
	     	
	     	if(e.getSource()==cb) {
	     		Series s =(Series)it;
	     		int len =s.getSeasons().get(cb.getSelectedIndex());
	     	    this.setEpisodeList(len);
	     	}
	     	
	     	if(e.getSource()==play) {
	     		if(it instanceof Movie)
	     			JOptionPane.showMessageDialog(null, "enjoy the Movie "+it.getTitle());
	     		else
	     			JOptionPane.showMessageDialog(null, "enjoy the Series "+ it.getTitle()+"\nseason "+(cb.getSelectedIndex()+1)+"\nepisode "+(cb1.getSelectedIndex()+1));
	     		
	     	}
	     	if(e.getSource()==aq) {
	     	   cl.addItem(it);
	     	}
	     	
	     	if(e.getSource()==back) {
	     		new Site(cl).setVisible(true);
	     		this.setVisible(false);
	     		this.dispose();
	     	}
	     	
	}
}
