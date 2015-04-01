import java.util.Comparator;

public class Trans {

	private Types type;
	private double km;
	private int yom;
	private int aveLife;
	private String vin;
	private int wheels;
	private boolean hitch;
	private boolean people;

	public Trans(Types type, double km, int yom, int aveLife, String vin, int wheels, boolean hitch, boolean people) {
		super();
		this.type = type;
		this.km = km;
		this.yom = yom;
		this.aveLife = aveLife;
		this.vin = vin;
		this.wheels = wheels;
		this.hitch = hitch;
		this.people = people;

	}

	public Types getType() {
		return type;
	}

	public double getKm() {
		return km;
	}

	public int getYom() {
		return yom;
	}

	public int getAveLife() {
		return aveLife;
	}

	public String getVin() {
		return vin;
	}

	public int getWheels() {
		return wheels;
	}

	public boolean isHitch() {
		return hitch;
	}

	public boolean isPeople() {
		return people;
	}

	@Override
	public String toString() {
		return "Trans [type=" + type + ", km=" + km + ", yom=" + yom + ", aveLife=" + aveLife + ", vin=" + vin + ", wheels=" + wheels + ", hitch=" + hitch + ", people=" + people + "]";
	}

	public final static class SorterbyWheels implements Comparator<Trans> {

		@Override
		public int compare(Trans o1, Trans o2) {
			return o1.getWheels() - o2.getWheels();
		}

	}
	public final static class SorterbyType implements Comparator<Trans> {
		
		@Override
		public int compare(Trans o1, Trans o2) {
			return o1.getType().ordinal() - o2.getType().ordinal();
		}
		
	}
	public final static class SorterbyKm implements Comparator<Trans> {
		
		@Override
		public int compare(Trans o1, Trans o2) {
			return Double.compare(o1.getKm(), o2.getKm());
		}
		
	}
}
