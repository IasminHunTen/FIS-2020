package register;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JToolBar;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Insets;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import MainMenu.AddItem;
import MainMenu.MainPage;
import login.LoginInterface;


import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegisterInterface extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTextField UsernameField;
	private JPasswordField PasswordField;
	private JComboBox<String> comboBox;
	private JLabel isFieldEmpty;
	private JButton registerButton;
	private JButton backButton;
	private UserManager manager;
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					  RegisterInterface frame = new RegisterInterface();
					  frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RegisterInterface() {
		
		manager=new UserManager();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 438);
		contentPane=new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Register");
		titleLabel.setBounds(237, 39, 71, 21);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(114, 124, 71, 14);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(114, 160, 73, 14);
		
		JLabel roleLabel = new JLabel("Role");
		roleLabel.setBounds(114, 201, 73, 14);
		contentPane.add(roleLabel);
		
		isFieldEmpty = new JLabel("");
		isFieldEmpty.setBounds(115, 250, 353, 14);
		contentPane.add(isFieldEmpty);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(197, 121, 175, 20);
		UsernameField.setColumns(10);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(197, 157, 175, 20);
		
		contentPane.setLayout(null);
		contentPane.add(titleLabel);
		contentPane.add(UsernameField);
		contentPane.add(usernameLabel);
		contentPane.add(passwordLabel);
		contentPane.add(PasswordField);
		
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		registerButton.setBounds(10, 297, 89, 23);
		contentPane.add(registerButton);
		
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBounds(10, 341, 89, 23);
		contentPane.add(backButton);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(197, 198, 175, 20);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("Admin");
		comboBox.addItem("Client");
		comboBox.addActionListener(this);
		
		
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==registerButton)
		{	
			
			String username=UsernameField.getText();
			char[] password=PasswordField.getPassword();
			String role=comboBox.getSelectedItem().toString();								 
			if(username.isEmpty())
				isFieldEmpty.setText("Username cannot be empty");
			else if(new String(password).isEmpty())
				isFieldEmpty.setText("Password cannot be empty");
			else if(role.isEmpty())
				isFieldEmpty.setText("Please choose a role");
			else if(role.equals("Admin")) {//mai eficienta ar fi fost verificare dupa index
				int ok=0;
				try {
					manager.addAdmin(new Admin(username,new String(password)));
				} catch (Exception e1) {
					isFieldEmpty.setText("Username already in use");
					ok=1;
				}
				if(ok==0) {
					this.setVisible(false);
		            this.dispose();
			    	new LoginInterface().setVisible(true);	
				}
			}
			else if(role.equals("Client")) {
				int ok=0;
				try {
					manager.addClient(new Client(username,new String(password)));
				} catch (Exception e1) {
					isFieldEmpty.setText("Username already in use");
					ok=1;
				}
				if(ok==0) {
					this.setVisible(false);
		            this.dispose();
			    	new LoginInterface().setVisible(true);	
				}
			}
			
		}
		if (e.getSource()==backButton)
		{
			this.setVisible(false);
            this.dispose();
            new LoginInterface().setVisible(true);
		}
	}
}
