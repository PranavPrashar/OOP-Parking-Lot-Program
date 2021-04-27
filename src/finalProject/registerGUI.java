package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class registerGUI implements ActionListener {
	public static JFrame frame;
	public static JPanel panel;
	public static JButton registerButton;
	public static JTextField firstNameInput, lastNameInput, passwordInput;
	public static JTextField emailInput;
	public static JLabel firstNameLabel;
	public static JLabel lastNameLabel;
	public static JLabel emailLabel;
	public static JLabel passwordLabel;
	public static JLabel succsessLabel;
	
	

	JCheckBox customerCheckBox;
	JCheckBox parkingOffCheckBox;

	JLabel programName;
	public static String path = "users.csv";

//	Login login = new Login();

	public static void main(String[] args) {
//		Login login = new Login();
		new registerGUI();
		regGUI();
		// new Login();
	}

	public static void regGUI() {
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);

		panel.setLayout(null);

		frame.setTitle("Register GUI");

		firstNameLabel = new JLabel("FirstName:");
		firstNameLabel.setBounds(10, 20, 80, 25);// x,y,width, height
		panel.add(firstNameLabel);

		firstNameInput = new JTextField(20);
		firstNameInput.setBounds(100, 20, 165, 25);
		panel.add(firstNameInput);

		lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(10, 50, 80, 25);// x,y,width, height
		panel.add(lastNameLabel);

		lastNameInput = new JTextField(20);
		lastNameInput.setBounds(100, 50, 165, 25);
		panel.add(lastNameInput);

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 80, 80, 25);// x,y,width, height
		panel.add(emailLabel);

		emailInput = new JTextField(20);
		emailInput.setBounds(100, 80, 165, 25);
		panel.add(emailInput);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 110, 80, 25);// x,y,width, height
		panel.add(passwordLabel);

		passwordInput = new JTextField(20);
		passwordInput.setBounds(100, 110, 165, 25);
		panel.add(passwordInput);

		registerButton = new JButton("Register");
		registerButton.setBounds(10, 140, 80, 25);
		panel.add(registerButton);
		registerButton.addActionListener(new registerGUI());
		
		succsessLabel = new JLabel("");
		succsessLabel.setBounds(100, 140, 300, 25);
		panel.add(succsessLabel);

		
		

		frame.setVisible(true);

	}

	public static void addUser() {
//		String user = firstNameInput.getText();
		String email = emailInput.getText();
//		String password = passwordInput.getText();

		for (int i = 0; i < Login.usersArray.size(); i++) {
			if (!(email.contains(Login.usersArray.get(i).getEmail()))) {
				// if (!Login.usersArray.get(i).getEmail().contains(email) &&
				// !Login.usersArray.get(i).getFirstName().contains(user) &&
				// !Login.usersArray.get(i).getPassword().contains(password))
//				frame.setVisible(false); // this will close the past login page
				Login.usersArray.add(new Users(firstNameInput.getText(), lastNameInput.getText(), emailInput.getText(),
						passwordInput.getText(), "" + (Login.usersArray.size() + 2), "User", "false", false));
				succsessLabel = new JLabel("Succsess New user has been added");
				succsessLabel.setBounds(10, 110, 80, 25);
				panel.add(succsessLabel);
				Login.updateFile(path);
				break;
			} else {
				
			}

		}
	}

	public static boolean checkValid(String emailInput) {
		for (Users u : Login.usersArray) {
			if (u.getEmail().equals(emailInput)) {
				return true;
			}
		}
		return false;
	}
	
	

	public static void succsessPrompt() {
		JOptionPane.showMessageDialog(null, "Email: " + emailInput.getText() + "registered", "Succsess registered ",
				JOptionPane.OK_OPTION);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// addUser();
//		Login.updateFile(path);

		if (!checkValid(emailInput.getText())) {
			Login.usersArray.add(new Users(firstNameInput.getText(), lastNameInput.getText(), emailInput.getText(),
					passwordInput.getText(), "" + (Login.usersArray.size() + 2), "User", "false",false));
			System.out.println("was True");
			Login.updateFile(path);
			frame.setVisible(false);
			succsessPrompt();
		}
		
		

		if (e.getSource() == registerButton) {
			Login.login();
		}

	}
}
