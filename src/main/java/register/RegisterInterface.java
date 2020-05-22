package register;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JToolBar;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Insets;
import javax.swing.JTextField;
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
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class RegisterInterface extends JFrame implements ActionListener{
	private JTextField Username;
	private JComboBox comboBox;
	JButton registerButton;
	JButton backButton;
	
	public RegisterInterface() {
		
		JLabel label = new JLabel("");
		label.setBounds(0, 283, 0, 0);
		
		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setBounds(237, 39, 71, 21);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		Username = new JTextField();
		Username.setBounds(197, 121, 175, 20);
		Username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(145, 124, 48, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(145, 157, 46, 14);
		
		JPasswordField textPane = new JPasswordField();
		textPane.setBounds(197, 157, 175, 20);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(502, 283, 0, 0);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(-10008, -10031, 0, 0);
		getContentPane().setLayout(null);
		getContentPane().add(label);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(Username);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(textPane);
		getContentPane().add(label_1);
		getContentPane().add(label_2);
		
		registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		registerButton.setBounds(10, 297, 89, 23);
		getContentPane().add(registerButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(10, 341, 89, 23);
		getContentPane().add(backButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(197, 198, 175, 20);
		getContentPane().add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("Admin");
		comboBox.addItem("Client");
		comboBox.addActionListener(this);
		
		JLabel lblNewLabel_3 = new JLabel("Role");
		lblNewLabel_3.setBounds(145, 201, 46, 14);
		getContentPane().add(lblNewLabel_3);
		// TODO Auto-generated constructor stub
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==registerButton)
		{
			
		}
		if (e.getSource()==backButton)
		{
			
		}
	}
}
