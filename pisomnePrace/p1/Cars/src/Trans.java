import java.util.Date;

public class Trans {

	private Types type = Types.PERSONAL;
	private double km;
	private Date yom;
	private int aveLife;
	private int vin;
	private int wheels;
	private boolean hitch;
	private boolean people;

	public Trans(String type, double km, Date yom, int aveLife, int vin,
			int wheels, boolean hitch, boolean people) throws Exception {
		super();
		switch (type){
		case "personal":
			this.type = Types.PERSONAL;
			break;
		case "truck":
			this.type = Types.TRUCK;
			break;
		default:
			throw new Exception();
		}
		this.km = km;
		this.yom = yom;
		this.aveLife = aveLife;
		this.vin = vin;
		this.wheels = wheels;
		this.hitch = hitch;
		this.people = people;

	}

}
