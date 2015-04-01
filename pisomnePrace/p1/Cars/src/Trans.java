import java.util.Date;

public class Trans {

	private String type;
	private double km;
	private Date yom;
	private int aveLife;
	private int vin;
	private int wheels;
	private boolean hitch;
	private boolean people;

	public Trans(String type, double km, Date yom, int aveLife, int vin,
			int wheels, boolean hitch, boolean people) {
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

}
