package fuska.radovan.d15;

public class User {
	private final String name;
	private final String surname;
	private final String number;

	public User(String name, String surname, String number) {
		this.name = name;
		this.surname = surname;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getNumber() {
		return number;
	}

	@Override public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", number=" + number + "]";
	}
}