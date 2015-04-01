
public class MainArray {

	public static void main(String[] args) {
		double time;
		
		time = System.currentTimeMillis();
		
		int[] array = new int[1000000];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		Utils.calcSumArray(array);
		
		time = (System.currentTimeMillis() - time);
		
		System.out.println(time);
	}

}
