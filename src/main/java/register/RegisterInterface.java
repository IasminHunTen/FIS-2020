package register;

import javax.swing.JFrame;
import java.awt.BorderLayout;
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

import MainMenu.MainPage;


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
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
		
		JLabel label = new JLabel("");
		label.setBounds(0, 283, 0, 0);
		
		JLabel titleLabel = new JLabel("Register");
		titleLabel.setBounds(237, 39, 71, 21);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(114, 124, 71, 14);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(114, 160, 73, 14);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(502, 283, 0, 0);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(-10008, -10031, 0, 0);
		
		JLabel roleLabel = new JLabel("Role");
		roleLabel.setBounds(114, 201, 73, 14);
		contentPane.add(roleLabel);
		
		isFieldEmpty = new JLabel("");
		isFieldEmpty.setBounds(26, 250, 73, 14);
		contentPane.add(isFieldEmpty);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(197, 121, 175, 20);
		UsernameField.setColumns(10);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(197, 157, 175, 20);
		
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(titleLabel);
		contentPane.add(UsernameField);
		contentPane.add(usernameLabel);
		contentPane.add(passwordLabel);
		contentPane.add(PasswordField);
		contentPane.add(label_1);
		contentPane.add(label_2);
		
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
			String password=PasswordField.getText(); //stiu ca nu ar trebui sa fac asta, nici daca o trimit spre incriptare, dar nu sunt sigur
													// cum poate fi obtinut fara a folosi getText niciodata; momentan merge
			String role=comboBox.getSelectedItem().toString();								 
			if(username.isEmpty())
				isFieldEmpty.setText("Username cannot be empty");
			else if(password.isEmpty())
				isFieldEmpty.setText("Password cannot be empty");
			else if(role.isEmpty())
				isFieldEmpty.setText("Please choose a role");
			else if(role.equals("Admin")) {//mai eficienta ar fi fost verificare dupa index
				manager.addAdmin(new Admin(username,password));
				//takes you to MainPage
			}
			else if(role.equals("Client")) {
				manager.addClient(new Client(username,password));
			}
			
		}
		if (e.getSource()==backButton)
		{
			//takes you to login
		}
	}
}
