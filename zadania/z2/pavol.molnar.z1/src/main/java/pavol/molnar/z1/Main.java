package pavol.molnar.z1;

public class Main {

	public static void main(String[] args) {

		long time = System.currentTimeMillis();
		double[] Array = new double[1000000];
		double[] Array2 = new double[1000000];
		for (int i = 0; i < 1000000; i++) {
			Array = null;
		}
		time = System.currentTimeMillis() - time;

		System.out.println("No GC: " + time);

		long time2 = System.currentTimeMillis();
		for (int a = 0; a < 1000000; a++) {
			Array2 = null;
			
		}
		System.gc();
		time2 = System.currentTimeMillis() - time2;

		System.out.println("With GC: " + time2);

	}
}