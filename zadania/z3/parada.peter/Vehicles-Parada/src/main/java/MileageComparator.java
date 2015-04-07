import java.util.Comparator;


public class MileageComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		return (int) (v1.getMileage() - v2.getMileage());
	}
	
}
