package finalProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Bookparkingspace implements ActionListener {

	int numParkingSpots = 10000; // max number of parking spots
	int numParkingSpotsSecond = 20;
	public static ArrayList<Parking> parkingSpaces = new ArrayList<Parking>();

	public static String parkingFile = "parkingSpots.csv";

	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();

	public static JFrame frame2 = new JFrame();
	public static JPanel panel2 = new JPanel();

	public static JFrame frame3 = new JFrame();
	public static JPanel panel3 = new JPanel();

	public static JLabel licenseNumber;
	public static JLabel parkingID;
	public static JLabel parkingTime;
	public static JLabel paymentLabel;

	public static JTextField licenseNumberInput;
	public static JTextField parkingTextInput;
	public static JTextField parkingTimeInput;
	public static JTextField paymentInput;

	public static JButton bookParking;
	public static JButton viewBookings;
	public static JButton logOut;
	public static JButton closePanel;
	public static JButton cancelParking;
	public static JButton payParking;
	public static JButton payParkingButton;

	public static JLabel successLabel;

	public static JScrollPane scroll;

	public static JTable table1;

	public static JCheckBox checkBox1;
	public static JCheckBox checkBox2;
	public static JCheckBox checkBox3;

	//
	public static DefaultListModel<Parking> listModel;
	public static JList<Parking> myJList;
	public static DefaultTableModel tableModel;

	public static JTextArea textarea;

	public static int parkingSpotNumber;
	public static int parkingTimeInt;
	public static int counter;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		loadParking(parkingFile);
		bookParkingGUI();

	}

	public static void bookParkingGUI() {
		panel = new JPanel();
		frame = new JFrame();

		panel2 = new JPanel();
		frame2 = new JFrame();

		frame.setSize(350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		frame.setTitle("Customer Book Parking GUI");

		System.out.println("I GOT RUN");

		licenseNumber = new JLabel("License #");
		licenseNumber.setBounds(10, 20, 80, 25);// x,y,width, height
		panel.add(licenseNumber);

		licenseNumberInput = new JTextField(20);
		licenseNumberInput.setBounds(100, 20, 165, 25);
		panel.add(licenseNumberInput);

		parkingID = new JLabel("Parking ID");
		parkingID.setBounds(10, 50, 80, 25);
		panel.add(parkingID);

		parkingTextInput = new JTextField(20);
		parkingTextInput.setBounds(100, 50, 165, 25);
		panel.add(parkingTextInput);

		parkingTime = new JLabel("Parking Time");
		parkingTime.setBounds(10, 80, 110, 25);
		panel.add(parkingTime);

		parkingTimeInput = new JTextField(20);
		parkingTimeInput.setBounds(100, 80, 165, 25);
		panel.add(parkingTimeInput);

		bookParking = new JButton("Book Parking");// x,y,width, height
		bookParking.setBounds(10, 110, 110, 25);
		panel.add(bookParking);
		bookParking.addActionListener(new Bookparkingspace());

		viewBookings = new JButton("View Bookings");// x,y,width, height
		viewBookings.setBounds(120, 110, 120, 25);
		panel.add(viewBookings);
		viewBookings.addActionListener(new Bookparkingspace());

		logOut = new JButton("logOut");// x,y,width, height
		logOut.setBounds(240, 110, 100, 25);
		panel.add(logOut);
		logOut.addActionListener(new Bookparkingspace());

		payParking = new JButton("payParking");
		payParking.setBounds(10, 140, 110, 25);
		panel.add(payParking);
		payParking.addActionListener(new Bookparkingspace());

		cancelParking = new JButton("cancelParking");
		cancelParking.setBounds(120, 140, 140, 25);
		panel.add(cancelParking);
		cancelParking.addActionListener(new Bookparkingspace());

		successLabel = new JLabel("");
		successLabel.setBounds(10, 200, 200, 25);
		panel.add(successLabel);

		frame.setVisible(true);

	}

	public static void loadParking(String path) throws IOException {
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();

		while (reader.readRecord()) {
			Parking userObj = new Parking();
			// customerEmail,parkingSpotNumber,parkingTime,licenseNumber,parkingSpotQty,parkingStatus
			userObj.setcustomerEmail(reader.get("customerEmail"));
			userObj.setParkingSpotNumber(Integer.valueOf(reader.get("parkingSpotNumber")));
			userObj.setParkingTime(Integer.valueOf(reader.get("parkingTime")));
			userObj.setlicenseNumber(reader.get("licenseNumber"));
			userObj.setparkingSpotQTY(Integer.valueOf(reader.get("parkingSpotQty")));
			userObj.setParkingStatus(Boolean.valueOf(reader.get("parkingStatus")));
			parkingSpaces.add(userObj);

		}

		for (int i = 0; i < parkingSpaces.size(); i++) {
			System.out.println(parkingSpaces.get(i));
		}
	}

	public static void errorPromptTime() {
		JOptionPane.showMessageDialog(null, "Parking Time: " + parkingTimeInput.getText(), "Invalid",
				JOptionPane.OK_OPTION);
	}

	public static void updateFile(String path) {
		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
			// customerEmail,parkingSpotNumber,parkingTime,licenseNumber,parkingSpotQty,parkingStatus
			csvOutput.write("customerEmail");
			csvOutput.write("parkingSpotNumber");
			csvOutput.write("parkingTime");
			csvOutput.write("licenseNumber");
			csvOutput.write("parkingSpotQty");
			csvOutput.write("parkingStatus");
			csvOutput.endRecord(); // this will throw expceptions

			// else assume that the file already has the correct header line
			// write out a few records
			for (Parking u : parkingSpaces) {
//				csvOutput.write(path);
				// customerEmail, parkingID, parkingTime
				csvOutput.write(u.getEmail());
				csvOutput.write(String.valueOf(u.getParkingSpotNumber()));
				csvOutput.write(String.valueOf(u.getParkingTime()));// fix this
				csvOutput.write(u.getlicenseNumber());
				csvOutput.write(String.valueOf(u.getparkingSpotQTY()));
				csvOutput.write(String.valueOf(u.getParkingStatus()));
				csvOutput.endRecord();
			}
			csvOutput.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void bookParkingSpot() throws IOException {
		Login login = new Login();
		parkingSpaces.clear();
		Bookparkingspace.loadParking(parkingFile);
		String licenseNum = licenseNumberInput.getText();
		parkingSpotNumber = Integer.parseInt(parkingTextInput.getText());
		parkingTimeInt = Integer.parseInt(parkingTimeInput.getText());

		if (!checkValidParking(parkingSpotNumber) && countSpotsUser(Login.emailStringForOutsideUse) < 3
				&& parkingSpotNumber < 10000) { // the
			// licenseNumber
			// if not
			// yet
			// parked
			Bookparkingspace.parkingSpaces.add(new Parking(Login.emailStringForOutsideUse, parkingSpotNumber,
					parkingTimeInt, licenseNum, parkingSpaces.size() + 1, false));
			// figure out how to get active users email
			// customerEmail, parkingSpotNumber, parkingTime, licenseNumber,
			// parkingSpotQty,parkingStatus;
			Bookparkingspace.updateFile(parkingFile);
			successLabel.setText("Parking Spot Added" + parkingSpotNumber);
//			System.out.println(licenseNum + parkingSpotNumber + parkingTime);
		} else {
			successLabel.setText("Try Again, Click View parking to see available parking");

		}

	}

	public static boolean checkValidParking(int parkingSpotNumber) {

		for (Parking p : parkingSpaces) {
			if (p.getParkingSpotNumber() == parkingSpotNumber) {
				// we should check if the license number and parking spot are valid, so the
				return true;
			}
		}
		return false;
	}

	public static int countSpotsUser(String email) {
		int counterUser = 0;
		for (Parking p : parkingSpaces) {
			if (p.getEmail().equals(email)) {
				counterUser++;
			}
		}
		return counterUser;
	}

	public void viewBookings() {

		panel2 = new JPanel();
		frame2 = new JFrame();

		frame2.setSize(700, 250);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(panel2);
		panel2.setLayout(null);

		textarea = new JTextArea();
		textarea.setText("");

		textarea.setBounds(1, 1, 700, 200); // x,y,width, height

		closePanel = new JButton("Close Window");
		closePanel.setBounds(500, 201, 200, 25);
		closePanel.addActionListener(new Bookparkingspace());
		panel2.add(closePanel);

		textarea.append(
				"customerEmail, parkingSpotNumber, parkingTime, licenseNumber, parkingSpotQty, parkingStatus" + "\n");
		for (Parking p : parkingSpaces) {// customerEmail, parkingSpotNumber, parkingTime, licenseNumber, parkingSpotQty
			textarea.append(p.getEmail() + ", " + p.getParkingSpotNumber() + ", " + p.getParkingTime() + ", "
					+ p.getlicenseNumber() + ", " + p.getparkingSpotQTY() + ", " + p.getParkingStatus() + "\n");
		}
		textarea.setBackground(Color.GRAY);

		panel2.add(textarea);

		frame2.setVisible(true);

	}

	public static void cancelParkingSpot() {

		for (Parking p : parkingSpaces) {
			if (p.getParkingSpotNumber() == Integer.parseInt(parkingTextInput.getText())
					&& p.getlicenseNumber().equals(licenseNumberInput.getText())) {
				parkingSpaces.remove(p);
				Bookparkingspace.updateFile(parkingFile);
				successLabel.setText("Parking Cancelled");

			}

		}
		System.out.println(parkingTextInput.getText() + licenseNumberInput.getText());

	}

	public static void payParking() {

		for (Parking p : parkingSpaces) {
			if (p.getEmail().equals(Login.emailStringForOutsideUse)
					&& p.getlicenseNumber().equals(licenseNumberInput.getText())
					&& p.getParkingSpotNumber() == Integer.valueOf(parkingTextInput.getText())) {
				p.setParkingStatus(true);
				Bookparkingspace.updateFile(parkingFile);
				successLabel.setText("Successfully Paid for " + parkingTextInput.getText());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == bookParking) {
			System.out.println("BOOK PARKING PRESSED");
			try {
				bookParkingSpot();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == viewBookings) {
			System.out.println("VIEW BOOKINGS PRESSED");
			viewBookings();
		} else if (e.getSource() == logOut) {
			frame.dispose(); // this will close the frame but i want it to set users logout status to
								// false/notlogged in
			Login.logOut(Login.emailStringForOutsideUse);
			frame2.dispose();
		} else if (e.getSource() == closePanel) {
			frame2.dispose();
		} else if (e.getSource() == cancelParking) {
			cancelParkingSpot();
			frame2.dispose();
		} else if (e.getSource() == payParking) {

			payParking();
		}

	}

}
