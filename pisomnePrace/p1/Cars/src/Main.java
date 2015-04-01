import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class Main {

	/**
	 * @param args
	 */
	public static ArrayList<Trans> ARR = new ArrayList<Trans>();
	public static int CARN;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

	}
	public static void printCars() {
		CARN = 1;
		for (int n = 0; n < ARR.size(); n++) {
			System.out.format("%2d. " + ARR.get(n).toString(), CARN);
			CARN++;
		}
	}
	public static void addCar(String type, double km, Date yom, int aveLife, int vin, int wheels, boolean hitch, boolean people ) {
		try {
			ARR.add(new Trans(type, km, yom, aveLife, vin, wheels, hitch, people));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
