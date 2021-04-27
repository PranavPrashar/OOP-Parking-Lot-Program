package finalProject;


public class Parking {

	public int parkingSpotNumber;
	public int parkingTime;
	public String customerEmail;
	public String licenseNumber;
	public int parkingSpotQTY;
	public boolean parkingStatus;
	public Parking(String customerEmail, int parkingSpotNumber, int parkingTime, String licenseNumber, int parkingSpotQTY, boolean parkingStatus) {
		super();
		//customerEmail, parkingSpotNumber, parkingTime, licenseNumber, parkingSpotQty,parkingStatus;
		this.customerEmail = customerEmail;
		this.parkingSpotNumber = parkingSpotNumber;
		this.parkingTime = parkingTime;
		this.licenseNumber = licenseNumber;
		this.parkingSpotQTY = parkingSpotQTY;
		this.parkingStatus = parkingStatus;

		// customerEmail, parkingID, parkingTime
	}

	public Parking() {
		super();
	}

	public int getParkingSpotNumber() {
		return this.parkingSpotNumber;
	}

	public int getParkingTime() {
		return this.parkingTime;
	}

	public String getEmail() {
		return this.customerEmail;
	}

	public void setParkingSpotNumber(int parkingSpotNumber) {
		this.parkingSpotNumber = parkingSpotNumber;

	}

	public void setParkingTime(int parkingTime) {
		this.parkingTime = parkingTime;
	}

	public void setcustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getlicenseNumber() {
		return this.licenseNumber;
	}

	public void setlicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	public int getparkingSpotQTY() {
		return parkingSpotQTY;
	}
	
	public void setparkingSpotQTY(int parkingspotQTY) {
		this.parkingSpotQTY = parkingspotQTY;
	}
	
	public void setParkingStatus(boolean parkingStatus) {
		this.parkingStatus = parkingStatus;
	}
	
	public boolean getParkingStatus() {
		return this.parkingStatus;
	}
	
	
	

	@Override
	public String toString() {
		return customerEmail + parkingSpotNumber + parkingTime + licenseNumber + parkingSpotQTY + parkingStatus ;
	}

}
