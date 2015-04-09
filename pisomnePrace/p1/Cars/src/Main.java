import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static ArrayList<Trans> ARR = new ArrayList<Trans>();
	public static int CARN;

	public static void main(String[] args) {

		try {
			String input;
			ARR = Loading.loadVehicles("vehicles.csv");
			while (true) {
				Utils.printMenu();
				input = Utils.sc.next();
				Utils.chooseMenu(input);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
