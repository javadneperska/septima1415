package pitko.erik.z2;

import java.util.ArrayList;

public class Utils {
	public static int sum(Integer[] array) {
		int x = 0;
		for (int i = 0; i < array.length; i++) {
			x += array[i];
		}
		return x;
	}

	public static int sum(ArrayList<Integer> list) {
		int x = 0;
		for (int i = 0; i < list.size(); i++) {
			x += list.get(i);
		}
		return x;
	}

}
