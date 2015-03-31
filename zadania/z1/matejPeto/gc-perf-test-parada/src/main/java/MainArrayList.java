import java.util.ArrayList;


public class MainArrayList {

	public static void main(String[] args) {
		double time;
		
		time = System.currentTimeMillis();
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for (int i = 0; i < 1000000; i++) {
			array.add(i);
		}
		
		Utils.calcSumArray(array);
		
		time = (System.currentTimeMillis() - time);
		
		System.out.println(time);
	}

}
