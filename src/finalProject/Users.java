package finalProject;

public class Users {
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public String id;
	public String userType; // because we will have two types
	public String loginStatus;
	public boolean parkingStatus;

	public Users(String firstName, String lastName, String email, String password, String id, String userType,
			String loginStatus, boolean parkingStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.id = id;
		this.userType = userType;
		this.loginStatus = loginStatus;
		this.parkingStatus = parkingStatus;
	}

	public Users() {
		super();

	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getName() {
		return this.firstName + "" + this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setID(String id) {
		String s = "" + Login.usersArray.size() + 1;
		this.id = s;
	}

	public String getID() {
		return this.id;
	}

	public String getType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getLoginStatus() {
		return this.loginStatus;
	}

	public void setparkingStatusCustomer(boolean customerPaymentStatus) {
		this.parkingStatus = customerPaymentStatus;
	}

	public boolean getParkingStatusCustomer() {
		return parkingStatus;
	}

	@Override
	public String toString() {
		return firstName + lastName + id + email + password + userType + loginStatus + parkingStatus;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

	// firstName, lastName, id, email, password

}
