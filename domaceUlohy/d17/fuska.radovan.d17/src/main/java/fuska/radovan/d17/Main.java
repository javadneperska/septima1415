package fuska.radovan.d17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();

		try {
			Scanner s = new Scanner(new FileInputStream("data.txt"), "UTF-8");
			while(s.hasNext())
				arr.add(s.next());
			s.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Integer> arrI = new ArrayList<Integer>();
		ArrayList<Long> arrL = new ArrayList<Long>();
		ArrayList<Float> arrF = new ArrayList<Float>();

		for(int i = 0; i < arr.size(); i++) {
			String s = arr.get(i);
			if(s.contains(".") || s.contains(","))
				arrF.add(Float.parseFloat(s));
			else {
				try {
					arrI.add(Integer.parseInt(s));
				} catch(NumberFormatException e) {
					arrL.add(Long.parseLong(s));
				}
			}
		}

		int size = Math.min(Math.min(arrI.size(), arrL.size()), arrF.size());
		IntFloatLong[] ifl = new IntFloatLong[size];
		for(int i = 0; i < size; i++) {
			ifl[i] = new IntFloatLong(arrI.get(i), arrF.get(i), arrL.get(i));
		}

		System.out.println(ifl.toString());

	}
}