package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Parkingofficergui implements ActionListener {

	public static JFrame frame;
	public static JPanel panel;
	public static JLabel licenseNumber;
	public static JLabel Duration;
	public static JLabel email;

	public static JTextField licenseInput;
	public static JTextField DurationInput;
	public static JButton submit;
	public static JTextField emailInput;
	public static JLabel ParkingSpot;
	public static JTextField ParkingSpotInput;

	public static JLabel successLabel;

	public static JButton button, button2;

	public static int parkingSpotNumber;
	public static int parkingTimeInt;
	Login login = new Login();

	static String parkingPath = "parkingSpots.csv";

	public static JLabel officerID;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Parkingofficergui.parkingOfficerGUI();
		loadTwo(parkingPath);

	}

	public static void parkingOfficerGUI() {
		panel = new JPanel();
		frame = new JFrame();

		frame.setSize(350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
//		panel.setBackground(Color.DARK_GRAY);

		email = new JLabel("Email");
		email.setBounds(10, 20, 80, 25);
		panel.add(email);

		emailInput = new JTextField(20);
		emailInput.setBounds(100, 20, 165, 25);
		panel.add(emailInput);

		licenseNumber = new JLabel("License #");
		licenseNumber.setBounds(10, 50, 80, 25);// x,y,width, height
		panel.add(licenseNumber);

		licenseInput = new JTextField(20);
		licenseInput.setBounds(100, 50, 165, 25);
		panel.add(licenseInput);

		//
		Duration = new JLabel("Duration #: ");
		Duration.setBounds(10, 80, 80, 25);
		panel.add(Duration);

		DurationInput = new JTextField(20);
		DurationInput.setBounds(100, 80, 165, 25);
		panel.add(DurationInput);

		ParkingSpot = new JLabel("Spot #: ");
		ParkingSpot.setBounds(10, 110, 80, 25);
		panel.add(ParkingSpot);

		ParkingSpotInput = new JTextField(20);
		ParkingSpotInput.setBounds(100, 110, 165, 25);
		panel.add(ParkingSpotInput);

		button = new JButton("Add Parking");
		button.setBounds(10, 140, 150, 25);
		panel.add(button);
		button.addActionListener(new Parkingofficergui());

		button2 = new JButton("Remove Parking");
		button2.setBounds(160, 140, 150, 25);
		panel.add(button2);
		button2.addActionListener(new Parkingofficergui());

		successLabel = new JLabel("");
		successLabel.setBounds(125, 165, 200, 25);
		panel.add(successLabel);

//
//		lastName = new JLabel("Last Name");
//		lastName.setBounds(10, 80, 80, 25);
//		panel.add(lastName);

//		lastNameInput = new JTextField(20);
//		lastNameInput.setBounds(10, 80, 80, 25);
////		lastNameInput.setBackground(Color.blue);
//		panel.add(lastNameInput);

		frame.setVisible(true);

	}

	public static void loadTwo(String path) throws IOException {
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
			Bookparkingspace.parkingSpaces.add(userObj);

		}

		for (int i = 0; i < Bookparkingspace.parkingSpaces.size(); i++) {
			System.out.println(Bookparkingspace.parkingSpaces.get(i));
		}

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
			for (Parking u : Bookparkingspace.parkingSpaces) {
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

	public static void addParking() throws IOException {
		Bookparkingspace.parkingSpaces.clear();
		System.out.println("TESTING");
		Bookparkingspace.loadParking(parkingPath);
		String licenseNum = licenseInput.getText();
		parkingSpotNumber = Integer.parseInt(ParkingSpotInput.getText());
		parkingTimeInt = Integer.parseInt(DurationInput.getText());

		if (!checkValidParking(parkingSpotNumber) && countSpotsUser(Login.emailStringForOutsideUse) < 3
				&& parkingSpotNumber < 10000) { // the
			// licenseNumber
			// if not
			// yet
			// parked
			Bookparkingspace.parkingSpaces.add(new Parking(Login.emailStringForOutsideUse, parkingSpotNumber,
					parkingTimeInt, licenseNum, Bookparkingspace.parkingSpaces.size() + 1, false));
			// figure out how to get active users email
			// customerEmail, parkingSpotNumber, parkingTime, licenseNumber,
			// parkingSpotQty,parkingStatus;
			Bookparkingspace.updateFile(Bookparkingspace.parkingFile);
			successLabel.setText("Parking Spot Added" + parkingSpotNumber);
//			System.out.println(licenseNum + parkingSpotNumber + parkingTime);
		} else {
			successLabel.setText("Try Again, Click View parking to see available parking");

		}
	}

	public static int countSpotsUser(String email) {
		int counterUser = 0;
		for (Parking p : Bookparkingspace.parkingSpaces) {
			if (p.getEmail().equals(email)) {
				counterUser++;
			}
		}
		return counterUser;
	}

	public static boolean checkValidParking(int parkingSpotNumber) {

		for (Parking p : Bookparkingspace.parkingSpaces) {
			if (p.getParkingSpotNumber() == parkingSpotNumber) {
				// we should check if the license number and parking spot are valid, so the
				return true;
			}
		}
		return false;
	}

	public void removeParking() {
		System.out.println("value");
		for (Parking p : Bookparkingspace.parkingSpaces) {
			if (p.getParkingSpotNumber() == Integer.parseInt(ParkingSpotInput.getText())
					&& p.getlicenseNumber().equals(licenseInput.getText())) {
				Bookparkingspace.parkingSpaces.remove(p);
				Bookparkingspace.updateFile(parkingPath);
				successLabel.setText("Parking Cancelled" + ParkingSpotInput.getText());

			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == button) {
			try {
				addParking();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == button2) {
			removeParking();
		}
	}

}
