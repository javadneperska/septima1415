package pavlo.fuska.z1;

public class Emploee {
	final String name;
	final String surname;
	final String socialSecurityNumber;
	final boolean isWoman;
	final Address address;
	final EmploeeType type;
	final ExtraInfo info;

	public Emploee(String name, String surname, String socialSecurityNumber, boolean isWoman, Address address, EmploeeType type, ExtraInfo extraInfo) {
		this.name = name;
		this.surname = surname;
		this.socialSecurityNumber = socialSecurityNumber;
		this.isWoman = isWoman;
		this.address = address;
		this.type = type;
		this.info = extraInfo;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public boolean isWoman() {
		return isWoman;
	}

	public Address getAddress() {
		return address;
	}

	public EmploeeType getType() {
		return type;
	}

	public ExtraInfo getExtraInfo() {
		return info;
	}
}