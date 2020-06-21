package welcomePage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.FileUtils;

import login.LoginInterface;
import register.RegisterInterface;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class WelcomePage extends JFrame implements ActionListener{

	private JPanel contentPane;

	private JButton loginButton;
	private JButton registerButton;
	/**
	 * Launch the application.
	 */
	private static void copyFile(File src, File dest) {
		try {
			FileUtils.copyFileToDirectory(src,dest);
		}catch(IOException e) {
	    	e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File from_client =new File("\\client_database.json").getAbsoluteFile();
					File from_admin =new File("\\admin_database.json").getAbsoluteFile();
					File from_item =new File("\\database.json").getAbsoluteFile();
					File from_queue =new File("Queue Database.dir").getAbsoluteFile(); //nu stiu cum sa rezolv, nu e timp
					File dest = new File("\\target");
					
					copyFile(from_client,dest);
					copyFile(from_admin,dest);
					copyFile(from_item,dest);
					copyFile(from_queue,dest);
					
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		registerButton = new JButton("Register");
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		registerButton.addActionListener(this);
		registerButton.setBounds(53, 191, 89, 23);
		contentPane.add(registerButton);
		
		loginButton = new JButton("Log In");
		loginButton.addActionListener(this);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginButton.setBounds(283, 191, 89, 23);
		contentPane.add(loginButton);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(-16, 32, 424, 115);
		contentPane.add(lblNewLabel);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginButton) {
			this.setVisible(false);
            this.dispose();
            new LoginInterface().setVisible(true);
		}
		if(e.getSource()==registerButton) {
			this.setVisible(false);
            this.dispose();
            new RegisterInterface().setVisible(true);
		}
		
	}
}
