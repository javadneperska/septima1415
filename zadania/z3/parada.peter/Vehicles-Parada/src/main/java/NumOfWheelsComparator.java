import java.util.Comparator;


public class NumOfWheelsComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		return v1.getNumOfWheels() - v2.getNumOfWheels();
	}

}