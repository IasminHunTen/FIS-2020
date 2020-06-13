package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.MainPage;
import register.Admin;
import register.Client;
import register.RegisterInterface;
import register.User; // TO DO sterge cand inlocuiesti cu UserList
import register.UserManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginInterface extends JFrame implements ActionListener {

	private JPanel contentPane;
	private UserManager manager;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel isFieldEmpty;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface frame = new LoginInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(197, 157, 175, 20);
		contentPane.add(passwordField);
		
		loginButton = new JButton("Log in");
		loginButton.addActionListener(this);
		loginButton.setBounds(10, 297, 89, 23);
		contentPane.add(loginButton);
		
		isFieldEmpty = new JLabel("");
		isFieldEmpty.setBounds(114, 231, 258, 14);
		contentPane.add(isFieldEmpty);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginButton) {
			String username = usernameField.getText();
			char[] password = passwordField.getPassword();
			if(username.isEmpty())
				isFieldEmpty.setText("Username cannot be empty");
			else if(new String(password).isEmpty())
				isFieldEmpty.setText("Password cannot be empty");
			else
				try {
					if(manager.checkPassword(username, new String(password))) {// impartirea clientilor si adminilor in baze de date separate devine din ce in ce mai dureroasa
						User u=manager.getUser(username);
						if(u instanceof Client) {
							this.setVisible(false);
				            this.dispose();
				            // TO DO new Search().setVisible(true);
						}
						else if(u instanceof Admin) {
							this.setVisible(false);
				            this.dispose();
				            new MainPage().setVisible(true);
						}
					}
				} catch (Exception e1) {
					isFieldEmpty.setText("Username or password is incorect");
				}
		}
		
	}
}
