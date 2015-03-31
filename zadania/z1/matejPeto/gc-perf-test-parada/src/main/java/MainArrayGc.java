
public class MainArrayGc {

	public static void main(String[] args) {
		double time;
		
		time = System.currentTimeMillis();
		
		int[] arrayGC = new int[1000000];
		
		for (int i = 0; i < arrayGC.length; i++) {
			arrayGC[i] = i;
		}
		
		Utils.calcSumArray(arrayGC);
		
		arrayGC = null;
		
		System.gc();
		
		time = (System.currentTimeMillis() - time);
		
		System.out.println(time);

	}

}
