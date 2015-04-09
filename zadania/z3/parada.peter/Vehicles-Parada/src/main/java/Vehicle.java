
public class Vehicle {
	Type type;
	double mileage;
	int yearOfRelease;
	int lifespan;
	String VIN;
	int numOfWheels;
	boolean canMontage;
	boolean canTransportPeople;
	
	public Vehicle(Type type, double mileage, int yearOfRelease, int lifespan,
			String vIN, int numOfWheels, boolean canMontage,
			boolean canTransportPeople) {
		this.type = type;
		this.mileage = mileage;
		this.yearOfRelease = yearOfRelease;
		this.lifespan = lifespan;
		VIN = vIN;
		this.numOfWheels = numOfWheels;
		this.canMontage = canMontage;
		this.canTransportPeople = canTransportPeople;
	}
	
	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", mileage=" + mileage
				+ ", yearOfRelease=" + yearOfRelease + ", lifespan=" + lifespan
				+ ", VIN=" + VIN + ", numOfWheels=" + numOfWheels
				+ ", canMontage=" + canMontage + ", canTransportPeople="
				+ canTransportPeople + "]";
	}

	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public double getMileage() {
		return mileage;
	}
	
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	public int getYearOfRelease() {
		return yearOfRelease;
	}
	
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	
	public int getLifespan() {
		return lifespan;
	}
	
	public void setLifespan(int lifespan) {
		this.lifespan = lifespan;
	}
	
	public String getVIN() {
		return VIN;
	}
	
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	
	public int getNumOfWheels() {
		return numOfWheels;
	}
	
	public void setNumOfWheels(int numOfWheels) {
		this.numOfWheels = numOfWheels;
	}
	
	public boolean isCanMontage() {
		return canMontage;
	}
	
	public void setcanMontage(boolean canMontage) {
		this.canMontage = canMontage;
	}
	
	public boolean isCanTransportPeople() {
		return canTransportPeople;
	}
	
	public void setCanTransportPeople(boolean canTransportPeople) {
		this.canTransportPeople = canTransportPeople;
	}
	
}
