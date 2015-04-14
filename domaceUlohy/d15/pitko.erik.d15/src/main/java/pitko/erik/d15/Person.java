package pitko.erik.d15;

public class Person {
	private String name;
	private String surname;
	private String numOfBirth;
	public Person(String name, String surname, String numOfBirth) {
		super();
		this.name = name;
		this.surname = surname;
		this.numOfBirth = numOfBirth;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", numOfBirth=" + numOfBirth + "]";
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getNumOfBirth() {
		return numOfBirth;
	}

}
