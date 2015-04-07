import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class UtilsVehicles {
	private ArrayList<Vehicle> vehicles;
	
	public UtilsVehicles(String file) {
		this.loadVehicles(file);
	}

	private void loadVehicles(String file) {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.nextLine();
		
		while(sc.hasNextLine()) {
			final String[] vehicleInfo = sc.nextLine().split(", ");
			final Type type = Type.valueOf(vehicleInfo[0]);
			final double mileage = Double.parseDouble(vehicleInfo[1]);
			final int yearOfRelease = Integer.parseInt(vehicleInfo[2]);
			final int lifespan = Integer.parseInt(vehicleInfo[3]);
			final String VIN = vehicleInfo[4];
			final int numOfWheels = Integer.parseInt(vehicleInfo[5]);
			boolean canMontage = Boolean.parseBoolean(vehicleInfo[6]);
			boolean canTransportPeople = Boolean.parseBoolean(vehicleInfo[7]);
			Vehicle vehicle = new Vehicle(type, mileage, yearOfRelease, lifespan, VIN, numOfWheels, canMontage, canTransportPeople);
			vehicles.add(vehicle);
		}
		sc.close();
		this.vehicles = vehicles;
	}
	
	public int getSize() {
		return this.vehicles.size();
	}
	
	public ArrayList<Vehicle> getVehicles() {
		return this.vehicles;
	}
	
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void printVehicles() {
		for (int i = 0; i < vehicles.size(); i++) {
			System.out.println((i+1) + "." + this.vehicles.get(i).toString());
		}
		System.out.println();
	}
	
	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	
	public void removeVehicle(int index) {
		this.vehicles.remove(index-1);
	}
	
	public void sortBy(SortType sortType) {
		switch (sortType) {
		case MILEAGE:
			Collections.sort(this.vehicles, new MileageComparator());
			break;
		case LIFESPAN:
			Collections.sort(this.vehicles, new LifespanComparator());
			break;
		case NUM_OF_WHEELS:
			Collections.sort(this.vehicles, new NumOfWheelsComparator());
			break;
		}
	}

}
