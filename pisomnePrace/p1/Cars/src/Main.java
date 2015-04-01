

public class Main {

	/**
	 * @param args
	 */
	public static ArrayList<Trans> ARR = new ArrayList<Trans>();
	public static int CARN;
	public static void main(String[] args) {
		

	}
	public static void printCars() {
		CARN = 1;
		for (int n = 0; n < ARR.size(); n++) {
			System.out.format("%2d. " + ARR.get(n).toString(), CARN);
			CARN++;
		}
	}
	public static void addCar() {
		ARR.add(new Trans());
	}

}
