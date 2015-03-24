package pavlo.fuska.z1;

public class Address {
	final String country;
	final String city;
	final String street;
	final int houseNumber;

	public Address(int houseNumber, String street, String city, String country) {
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	@Override public String toString() {
		return "Address [Country=" + country + ", City=" + city + ", Street=" + street + ", House number=" + houseNumber + "]";
	}

	public String getStreet() {
		return street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}
}