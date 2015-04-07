import java.util.Comparator;


public class LifespanComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		return v1.getLifespan() - v2.getLifespan();
	}

}
