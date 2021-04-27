package finalProject;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Login implements ActionListener {
	public static String path = "users.csv";
	public static ArrayList<Users> usersArray = new ArrayList<Users>();

	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();

	JFrame frame2 = new JFrame();

	//
	TextField firstName;
	TextField lastName;
	TextField email;
	TextField password;

//	JButton register;
	JButton login;
	//

	JLabel programName;

	private static JLabel label;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button, button2;
	private static JLabel sucsessLabel;

	public static String emailStringForOutsideUse;

	public static String fName, lName, id, emailString, passwordString;
	// private static String[] userArray; // use comma as separator

	public static void main(String[] args) throws IOException {
		login();
		Login.loadTwo(path);
//		Login login = new Login();
//		load(path);
//		updateFile(path);
	}

	public static void login() {
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);
		frame.setTitle("LOGIN");

		panel.setLayout(null);
		label = new JLabel("Email:");
		label.setBounds(10, 20, 80, 25);// x,y,width, height
		panel.add(label);

		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);

		button = new JButton("Login");
		button.setBounds(10, 80, 80, 25);
		panel.add(button);
		button.addActionListener(new Login());

		button2 = new JButton("Register");
		button2.setBounds(80, 80, 80, 25);
		panel.add(button2);
		button2.addActionListener(new Login());

		sucsessLabel = new JLabel("");
		sucsessLabel.setBounds(10, 110, 300, 25);
		panel.add(sucsessLabel);

		sucsessLabel.setText("Success");
		emailStringForOutsideUse = userText.getText();

		frame.setVisible(true);
	}

	public static void loadTwo(String path) throws IOException {
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();

		while (reader.readRecord()) {
			Users userObj = new Users();
			// firstName, lastName, id, email, password
			userObj.setFirstName(reader.get("firstName"));
			userObj.setLastName(reader.get("lastName"));
			userObj.setID(reader.get("id"));
			userObj.setEmail(reader.get("email"));
			userObj.setPassword(reader.get("password"));
			userObj.setUserType(reader.get("userType"));
			userObj.setLoginStatus(reader.get("loginStatus"));
			userObj.setparkingStatusCustomer(Boolean.valueOf(reader.get("paymentStatusCustomer")));
			usersArray.add(userObj);

		}

		for (int i = 0; i < usersArray.size(); i++) {
			System.out.println(usersArray.get(i));
		}

	}

	public static void loadEmail(String emailLoaded) {
		emailStringForOutsideUse = emailLoaded;
	}

	public static void updateFile(String path) {
		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
			// firstName, lastName, id, email, password
			csvOutput.write("firstName");
			csvOutput.write("lastName");
			csvOutput.write("id");
			csvOutput.write("email");
			csvOutput.write("password");
			csvOutput.write("userType");
			csvOutput.write("loginStatus");
			csvOutput.write("paymentStatusCustomer");
			csvOutput.endRecord(); // this will throw expceptions

			// else assume that the file already has the correct header line
			// write out a few records
			for (Users u : usersArray) {
				csvOutput.write(u.getFirstName());
				csvOutput.write(u.getLastName());
				csvOutput.write(u.getID());
				csvOutput.write(u.getEmail());
				csvOutput.write(u.getPassword());
				csvOutput.write(u.getType());
				csvOutput.write(u.getLoginStatus());
				csvOutput.write(String.valueOf(u.getParkingStatusCustomer()));
				csvOutput.endRecord();
			}
			csvOutput.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void logOut(String userName) {
		for (int i = 0; i < usersArray.size(); i++) {
			if (userName.contains(usersArray.get(i).getEmail())) {
				sucsessLabel.setText("Found");
				System.out.println("Sucess" + userName);
				frame.setVisible(false); // this will close the past login page
				usersArray.get(i).setLoginStatus("false");
				updateFile(path);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		registerGUI registerObj = new registerGUI();
		Bookparkingspace bookParkingGUI = new Bookparkingspace();

		String user = userText.getText(); // this is getting email
		String password = passwordText.getText();

		for (int i = 0; i < usersArray.size(); i++) {
			if (user.contains(usersArray.get(i).getEmail()) && password.equals(usersArray.get(i).getPassword())) {
				if (user.equals(usersArray.get(i).getEmail()) && password.equals(usersArray.get(i).getPassword())
						&& usersArray.get(i).getType().equals("Officer")) {
					System.out.println("TYPE WAS OFFICER");
					Parkingofficergui.parkingOfficerGUI();
					break;
				}
				sucsessLabel.setText("Found");
				System.out.println("Sucess" + user + "" + password);
				frame.setVisible(false); // this will close the past login page
				usersArray.get(i).setLoginStatus("true");
				updateFile(path);

				bookParkingGUI.bookParkingGUI();
				loadEmail(usersArray.get(i).getEmail().toString());
				break;
			} else if (user.equals("admin") && password.equals("admin")) { // this will be for admin page
				System.out.println("ADMIN ACCESS");
				AdminGUI.adminGUI();
				frame.setVisible(false);
				break;
			}
//			else if(user.equals(usersArray.get(i).getEmail()) && password.equals(usersArray.get(i).getPassword()) && usersArray.get(i).getType().equals("Officer")){
//				System.out.println("TYPE WAS OFFICER");
//			}
			else {
				sucsessLabel.setText("Not Found, Try Registering");
				System.out.println("Not" + user + "" + password);
			}

		}

		if (e.getSource() == button2) {
			frame.setVisible(false);
			registerObj.regGUI();
		}

	}

}
