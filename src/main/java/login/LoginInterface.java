package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import register.UserManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginInterface extends JFrame implements ActionListener {

	private JPanel contentPane;
	private UserManager manager;
	private JTextField usernameField;
	private JTextField passwordField;
	
	public LoginInterface() {
		
		manager=new UserManager();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 438);
		contentPane=new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Log In");
		titleLabel.setBounds(237, 39, 71, 21);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(titleLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(114, 124, 71, 14);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(114, 160, 73, 14);
		contentPane.add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(197, 121, 175, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(197, 157, 175, 20);
		contentPane.add(passwordField);
		
		JButton loginButton = new JButton("Log in");
		loginButton.setBounds(10, 297, 89, 23);
		contentPane.add(loginButton);
		
		JLabel isBoxEmpty = new JLabel("");
		isBoxEmpty.setBounds(114, 231, 258, 14);
		contentPane.add(isBoxEmpty);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
