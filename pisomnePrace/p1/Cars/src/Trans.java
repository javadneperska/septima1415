import java.util.Date;

public class Trans {

	private Types type;
	private double km;
	private int yom;
	private int aveLife;
	private String vin;
	private int wheels;
	private boolean hitch;
	private boolean people;

	public Trans(Types type, double km, int yom, int aveLife, String vin,
			int wheels, boolean hitch, boolean people){
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

	@Override
	public String toString() {
		return "Trans [type=" + type + ", km=" + km + ", yom=" + yom + ", aveLife=" + aveLife + ", vin=" + vin + ", wheels=" + wheels + ", hitch=" + hitch + ", people=" + people + "]";
	}
	

}
