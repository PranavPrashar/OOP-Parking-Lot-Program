package finalProject;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class jUnit {
	Users user;
	String path = "users.csv";
	String parkingPath = "parkingSpots.csv";

	@Test
	void test() {
		try {
			Bookparkingspace.loadParking(parkingPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(true, Bookparkingspace.parkingSpaces.size() > 0);
	}

	

//	@Test void test2() {
//		AdminGUI.setPayment();
//		
//		Assert.assertArrayEquals("pranav98@my.yorku.ca", null);
//	}

	@Test
	public void test3() {
		try {
			Login.loadTwo(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(true, Login.usersArray.size() > 0);
	}

	@Test
	public void test4() {
		// check unique id
		Login.login();

		try {
			Login.loadTwo(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean value = false;

		for (int i = 0; i < Login.usersArray.size(); i++) {
			for (int j = 1; j < Login.usersArray.size(); j++) {
				if (Login.usersArray.get(i).getID().equals(Login.usersArray.get(j).getID())) {
					value = false;
					break;
				}

			}
			value = true;
		}

		Assert.assertEquals(true, value);

	}

	@Test
	public void test5() {
		Login.login();

		try {
			Login.loadTwo(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean value = false;
		String email = "pranav98@my.yorku.ca";

		for (Users U : Login.usersArray) {
			if (U.getEmail().equals(email)) {
				value = true;
				break;
			} else {
				value = false;
				break;
			}
		}
		Assert.assertEquals(true, value);
	}

	@Test
	public void test6() {
		String email = "pranav98@my.yorku.ca";
		Login.loadEmail(email);

		Assert.assertEquals(email, Login.emailStringForOutsideUse);
	}

	@Test
	public void test7() {
		String email = "pranav98@my.yorku.ca";
		boolean value = true;

		for (Users u : Login.usersArray) {
			if (u.getEmail().equals(email) && u.getLoginStatus().equals("false")) {
				u.setLoginStatus("true");
			}
		}

		for (Users u : Login.usersArray) {
			if (u.getEmail().equals(email) && u.getLoginStatus().equals("true")) {
				value = true;
			}
		}

		Assert.assertEquals(true, value);

	}

	@Test
	public void test8() {
//		Login.usersArray.add(new Users("eshaan","prashar","12","2eshaan@live.ca","testing2","Officer","false",true));
		String firstName = "eshaan";
		String lastName = "prashar";
		String email = "eshaan2@live.ca";
		boolean value = false;

		for (Users u : Login.usersArray) {
			if (u.getEmail().equals(email) && u.getFirstName().equals(firstName) && u.getLastName().equals(lastName)) {
				value = true;
			}
		}

		Assert.assertEquals(true, value);

	}

	@Test
	public void test9() {

		String firstName = "eshaan";
		String lastName = "prashar";
		String email = "eshaan2@live.ca";
		boolean value = false;

		if (registerGUI.checkValid(email)) {
			value = true;
		} else {
			value = false;
		}

		Assert.assertEquals(true, value);
	}

	@Test
	public void test10() {

		String email = "eshaan222@live.ca";
		boolean value = false;

		if (registerGUI.checkValid(email)) {
			value = true;
		} else {
			value = false;
		}

		Assert.assertFalse(value);
	}

	@Test
	public void test11() {
		String email = "pranav98@my.yorku.ca";
		boolean value = false;
		try {
			Bookparkingspace.loadParking("parkingSpots.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Parking P : Bookparkingspace.parkingSpaces) {
			if (P.getParkingSpotNumber() == 2) {
				value = true;
			}
		}

		Assert.assertEquals(true, value);
	}

	@Test
	public void test12() {
		String email = "pranav98@my.yorku.ca";

		try {
			Login.loadTwo(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean value = false;

		for (Users U : Login.usersArray) {
			if (U.getEmail().equals(email) && U.getLoginStatus().equals("true")) {
				Login.logOut(email);
			}

			for (Users user : Login.usersArray) {
				if (user.getEmail().equals(email) && user.getLoginStatus().equals("false")) {
					value = true;
				} else {
					value = false;
				}
			}

			Assert.assertEquals(false, value);
		}

	}
	
	@Test
	public void test13() {
		String email = "NOTHING";
		boolean value = false;
		try {
			Bookparkingspace.loadParking("parkingSpots.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Parking P : Bookparkingspace.parkingSpaces) {
			if (P.getEmail().equals(email)) {
				value = true;
			}
			else {
				value = false;
			}
		}

		Assert.assertEquals(false, value);
	}
	
	@Test
	public void test14() {
		String email = "abcd";
		boolean value = false;
		try {
			Bookparkingspace.loadParking("parkingSpots.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Parking P : Bookparkingspace.parkingSpaces) {
			if (P.getEmail().equals(email)) {
				value = true;
			}
			else {
				value = false;
			}
		}

		Assert.assertEquals(false, value);
	}
}
