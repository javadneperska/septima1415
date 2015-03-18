
public class Address {
	String street, city, district, country;
	int houseNumber;
	
	public Address(String street, String city, String district, String country, int houseNumber) {
		this.street = street;
		this.city = city;
		this.district = district;
		this.country = country;
		this.houseNumber = houseNumber;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}
	
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", district="
				+ district + ", country=" + country + ", houseNumber="
				+ houseNumber + "]";
	}
}
