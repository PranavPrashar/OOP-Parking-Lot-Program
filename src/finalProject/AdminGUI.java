package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminGUI implements ActionListener {

	public static JPanel panel = new JPanel();
	public static JFrame frame = new JFrame();

	public static JPanel panel2 = new JPanel();
	public static JFrame frame2 = new JFrame();

	public static JPanel panel3 = new JPanel();
	public static JFrame frame3 = new JFrame();

	public static JPanel panel4 = new JPanel();
	public static JFrame frame4 = new JFrame();

	public static JButton updateOfficers = new JButton();
	public static JButton addButton = new JButton();
	public static JButton addParkingGUIButton = new JButton();
	public static JButton removeButton = new JButton();
	public static JButton updatePayment = new JButton();
	public static JButton closeWindowAdmin = new JButton();
	public static JButton closeWindowAddParking = new JButton();
	public static JButton closeWindowPayment = new JButton();

	public static JButton updatePaymentButton = new JButton();
	public static JButton closeWindowButton = new JButton();
	public static JButton remParking = new JButton();

	public static JLabel firstName = new JLabel();
	public static JLabel lastName = new JLabel();

	public static JLabel emailAddress = new JLabel();
	public static JLabel parkingSpaceNumber = new JLabel();
	public static JLabel successLabel;

	public static JTextField firstNameInput;
	public static JTextField lastNameInput;
	public static JTextField parkingSpaceInput;
	public static JTextField emailAddressInput;

	public static String fName, lName, email;

	public static String loginPath = Login.path;

//	// Payment Status -> The System Administrator changes the payment status from unpaid to paid once the
//	customer payment is confirmed where they can enter customer first name, last name, email address and parking
//	space number to change their payment status to “paid”.

	// Add or remove parking officers from system -> to add and remove parking
	// enforcement officers from the system
	/// The system will ask information such as first name, last name, and email
	// address is required to add a
	// new Parking Enforcement Officer

	public static void main(String[] args) throws IOException {
		AdminGUI.adminGUI();
		Login.loadTwo(loginPath); //
		Bookparkingspace.loadParking(Bookparkingspace.parkingFile);

	}

	public AdminGUI() {
		super();

	}

	public static void adminGUI() {
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);

		panel.setLayout(null);

		frame.setTitle("ADMIN GUI");

		addButton = new JButton("Add Parking Officer");
		addButton.setBounds(10, 10, 200, 25);
		panel.add(addButton);
		addButton.addActionListener(new AdminGUI());

		removeButton = new JButton("Remove Parking Officer");
		removeButton.setBounds(10, 40, 200, 25);// x,y,width, height
		panel.add(removeButton);
		removeButton.addActionListener(new AdminGUI());

		updatePayment = new JButton("Update Payments");
		updatePayment.setBounds(10, 70, 200, 25);// x,y,width, height
		panel.add(updatePayment);
		updatePayment.addActionListener(new AdminGUI());

		closeWindowAdmin = new JButton("Close Window");
		closeWindowAdmin.setBounds(10, 100, 200, 25);
		panel.add(closeWindowAdmin);
		closeWindowAdmin.addActionListener(new AdminGUI());

		frame.setVisible(true);
	}

	public static void addParkingOfficer() {
//		frame.setVisible(false);
////		frame.dispose();
		System.out.println("add parking");
		panel2 = new JPanel();
		frame2 = new JFrame();
		frame2.setSize(350, 250);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame2.add(panel2);

		panel2.setLayout(null);

		frame2.setTitle("Add Parking Officer/Set Parking Officer");

		firstName = new JLabel("First Name: ");
		firstName.setBounds(10, 20, 80, 25);// x,y,width, height
		panel2.add(firstName);

		firstNameInput = new JTextField(20);
		firstNameInput.setBounds(100, 20, 165, 25);
		panel2.add(firstNameInput);

		lastName = new JLabel("Last Name: ");
		lastName.setBounds(10, 50, 80, 25);
		panel2.add(lastName);

		lastNameInput = new JTextField(20);
		lastNameInput.setBounds(100, 50, 165, 25);
		panel2.add(lastNameInput);

		emailAddress = new JLabel("Email: ");
		emailAddress.setBounds(10, 80, 80, 25);
		panel2.add(emailAddress);

		emailAddressInput = new JTextField(20);
		emailAddressInput.setBounds(100, 80, 165, 25);
		panel2.add(emailAddressInput);

		addParkingGUIButton = new JButton("Add Parking Officer");
		addParkingGUIButton.setBounds(10, 110, 200, 25);// x,y,width, height
		panel2.add(addParkingGUIButton);
		addParkingGUIButton.addActionListener(new AdminGUI());

		updatePayment = new JButton("Add payment");
		updatePayment.setBounds(10, 140, 200, 25);// x,y,width, height
		panel2.add(updatePayment);
		updatePayment.addActionListener(new AdminGUI());

		closeWindowAddParking = new JButton("Close Window");
		closeWindowAddParking.setBounds(10, 170, 200, 25);
		panel2.add(closeWindowAddParking);
		closeWindowAddParking.addActionListener(new AdminGUI());

		successLabel = new JLabel("aaa");
		successLabel.setBounds(10, 200, 350, 25);
		panel2.add(successLabel);

		frame2.setVisible(true);

	}

	public void addParking2() {
		System.out.println(emailAddressInput.getText());

		for (int i = 0; i < Login.usersArray.size(); i++) {
			if (Login.usersArray.get(i).getEmail().equals(emailAddressInput.getText())) {
				System.out.println("HIT");
				Login.usersArray.get(i).setUserType("Officer");
				Login.updateFile(loginPath);
				successLabel.setText("Officer Granted: " + emailAddressInput.getText());
			} else {
				successLabel.setText("Error");
			}
		}
	}

	public static void removeParkingOfficerGUI() {

		System.out.println("removeParkingOffGUI");

		panel4 = new JPanel();
		frame4 = new JFrame();
		frame4.setSize(350, 200);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame4.add(panel4);

		panel4.setLayout(null);

		frame4.setTitle("Remove Parking Officer");

		emailAddress = new JLabel("Email: ");
		emailAddress.setBounds(10, 20, 80, 25);// x,y,width, height
		panel4.add(emailAddress);

		emailAddressInput = new JTextField(20);
		emailAddressInput.setBounds(100, 20, 165, 25);
		panel4.add(emailAddressInput);

		remParking = new JButton("Remove Parking Officer");
		remParking.setBounds(10, 110, 200, 25);// x,y,width, height
		panel4.add(remParking);
		remParking.addActionListener(new AdminGUI());

		closeWindowButton = new JButton("Close Window");
		closeWindowButton.setBounds(10, 140, 200, 25);// x,y,width, height
		panel4.add(closeWindowButton);
		closeWindowButton.addActionListener(new AdminGUI());

		frame4.setVisible(true);

	}

	public void closeWindow(JFrame frame) {
		frame.dispose();
	}

	public static void removeParkingOfficer(String email) {

		for (int i = 0; i < Login.usersArray.size(); i++) {
			if (Login.usersArray.get(i).getEmail().equals(email)) {
				Login.usersArray.get(i).setUserType("User");
				Login.updateFile(loginPath);
			}
		}
	}

	public static void setPayment() {
		// we might need to add another parameter for the parking, either parking price
		// or parkingStatus
		frame2.setVisible(false);
		System.out.println("Set Payments ADMIN");
		panel3 = new JPanel();
		frame3 = new JFrame();
		frame3.setSize(350, 250);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// where they can enter customer first name, last name, email address and
		// parking space number to change their payment status to “paid”.

		frame3.add(panel3);

		panel3.setLayout(null);

		frame3.setTitle("Set Payments ADMIN");

		firstName = new JLabel("First Name: ");
		firstName.setBounds(10, 20, 80, 25);// x,y,width, height
		panel3.add(firstName);

		firstNameInput = new JTextField(20);
		firstNameInput.setBounds(100, 20, 165, 25);
		panel3.add(firstNameInput);

		lastName = new JLabel("Last Name: ");
		lastName.setBounds(10, 50, 80, 25);
		panel3.add(lastName);

		lastNameInput = new JTextField(20);
		lastNameInput.setBounds(100, 50, 165, 25);
		panel3.add(lastNameInput);

		emailAddress = new JLabel("Email: ");
		emailAddress.setBounds(10, 80, 80, 25);
		panel3.add(emailAddress);

		emailAddressInput = new JTextField(20);
		emailAddressInput.setBounds(100, 80, 165, 25);
		panel3.add(emailAddressInput);

		parkingSpaceNumber = new JLabel("Parking Space #: ");
		parkingSpaceNumber.setBounds(10, 110, 165, 25);
		panel3.add(parkingSpaceNumber);

		parkingSpaceInput = new JTextField(20);
		parkingSpaceInput.setBounds(120, 110, 165, 25);
		panel3.add(parkingSpaceInput);

		updatePaymentButton = new JButton("updatePaymentButton");
		updatePaymentButton.setBounds(10, 140, 165, 25);
		panel3.add(updatePaymentButton);
		updatePaymentButton.addActionListener(new AdminGUI());

		closeWindowPayment = new JButton("Close Window");
		closeWindowPayment.setBounds(180, 140, 155, 25);
		closeWindowPayment.addActionListener(new AdminGUI());
		panel3.add(closeWindowPayment);

		successLabel = new JLabel("");
		successLabel.setBounds(10, 175, 350, 25);
		panel3.add(successLabel);
		frame3.setVisible(true);

	}

	public static void payment(String email, int parkingSpace) {
		for (Users u : Login.usersArray) {
			for (Parking P : Bookparkingspace.parkingSpaces)
				if (u.getEmail().equals(email) && P.getParkingSpotNumber() == parkingSpace) {
					P.setParkingStatus(true);
					u.setparkingStatusCustomer(true);
					Bookparkingspace.updateFile(Bookparkingspace.parkingFile);
					successLabel.setText("successfully Payment " + email);
					Login.updateFile(loginPath);
					break;
				} else {
					successLabel.setText("Error Payment " + email);
				}
		}
	}

	public static void addParkingSpot(int parkingSpotNumber) {

	}

//	public static void

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addButton) {
			addParkingOfficer();

		} else if (e.getSource() == removeButton) {
			removeParkingOfficerGUI();
		}

		if (e.getSource() == addParkingGUIButton) {
//			addParkingOfficer();
			addParking2();
			System.out.println("addParkingGUIButton");
		}

		if (e.getSource() == updatePayment) {
			setPayment();
		}

		if (e.getSource() == updatePaymentButton) {
			AdminGUI.payment(emailAddressInput.getText(), Integer.parseInt(parkingSpaceInput.getText()));
		}

		if (e.getSource() == closeWindowButton) {
			closeWindow(frame4);
		}
		if (e.getSource() == remParking) {
			removeParkingOfficer(emailAddressInput.getText());
		}

		if (e.getSource() == closeWindowAdmin) {
			closeWindow(frame);
		}
		if (e.getSource() == closeWindowAddParking) {
			closeWindow(frame2);
		}
		if (e.getSource() == closeWindowPayment) {
			closeWindow(frame3);
		}
	}

}
