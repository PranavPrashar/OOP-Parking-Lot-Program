package finalProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class finalProject implements ActionListener{
	
	
	public int counter = 0;
	String Text = "";
	int counter2 = 0;
	JPanel panel;
	
	JLabel programName;
	
	JFrame frame;
	
	TextField firstName;
	TextField lastName;
	TextField email;
	TextField password;
	
	JButton register;
	JButton login;
	
//	JLabel label;
	
//	JButton button;
//	JButton button2;
	
	
	
	
	
	ArrayList<String> value = new ArrayList<String>();
	
	
	
	public finalProject() {
		frame = new JFrame();
		panel = new JPanel();
		
//		button = new JButton("Click Me");
//		button2 = new JButton("TESTING");
//		
//		
//		button.addActionListener(this);
//		button2.addActionListener(this);
//		label = new JLabel("Number of clicks : 0 ");
		
		programName = new JLabel("Parking Lot Program");
//		
//		register = new JButton("Register");
//		login = new JButton("Login");
//		
//		
//		firstName = new TextField("FirstName");
//		firstName.setBounds(50,100, 200,30); 
//		
//		lastName = new TextField("LastName");
//		lastName.setBounds(50,100,200,30);
//		
//		email = new TextField("Email");
//		email.setBounds(50,100,200,30);
		
		login = new JButton("Login");
		register = new JButton("Register");
		
		
		

		panel.add(login);
		panel.add(register);
		panel.add(programName);
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(500, 500, 100, 500)); // top,bottom, left, right
		panel.setLayout(new GridLayout(0,1)); // row, coulmn
		
		
		
		
//		panel.add(button);
//		panel.add(label);
		
//		
//		panel.add(firstName);
//		panel.add(lastName);
//		panel.add(email);
////		panel.add(button2);
		
		frame.add(panel, BorderLayout.CENTER);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Testing");
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new finalProject();
		
		
	}
	
	public int testingFunc() {
		counter2++;
		return counter2;
	}
	
	public void login() {		
		email = new TextField("Email");
		email.setBounds(50,100,200,30);
		
		password = new TextField("Password");
		password.setBounds(50,100,200,30);
		
		panel.add(email);
		panel.add(password);
		System.out.println("LOGIN");
		
		panel.setVisible(true);
		
		
	}

	
	public void register() {
		firstName = new TextField("FirstName");
		firstName.setBounds(50,100, 200,30); 
		
		lastName = new TextField("LastName");
		lastName.setBounds(50,100,200,30);
		
		email = new TextField("Email");
		email.setBounds(50,100,200,30);
		System.out.println("REGISTER");
		
		panel.add(firstName);
		panel.add(lastName);
		panel.add(email);
		
		panel.setVisible(true);
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Login login = new Login();
		frame.setVisible(false);
		
		if(e.getSource() == login) {
			Login.login();
		}
		else if(e.getSource() == register) {
			register();
		}
		
		
	}
	

}
