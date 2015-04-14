import java.util.UUID;

public class User {
	String name, surname, idNumber, uuid;

	public User(String name, String surname, String idNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.idNumber = idNumber;
		this.uuid = UUID.randomUUID().toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", idNumber="
				+ idNumber + "]";
	}
}
