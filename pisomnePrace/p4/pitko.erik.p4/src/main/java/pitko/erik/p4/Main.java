package pitko.erik.p4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static boolean full = false;
	public static Random rand = new Random();
	public static long price;
	private static int trucks = 1;

	public static void main(String[] args) {
		// program, ktory nacita zoznam skladoveho nabytku(stolicka, skrina,
		// postel, regal, suflik),
		// kazdy z nabytkov ma cenu zvysenu o 10% svojho predchodcu
		// dodatocne info(farba, material - enum(drevo, drevotrieska, ine),
		// sirka, vyska, dlzka)
		// rozmer kamionu ktory prepravuje nabytok - 15x3 - optimalne povie aky
		// pocet a ake druhy nabytkov s akymi variaciami vieme dat do kamiona

		// int[] truck = new int[] { 2000 + rand.nextInt(2000), 500 +
		// rand.nextInt(500) };
		int[] truck = new int[] { 5000 + rand.nextInt(9000), 500 + rand.nextInt(500) };
		ArrayList<Furniture> furniture = new ArrayList<Furniture>();
		ArrayList<Furniture> furnitureSorted = new ArrayList<Furniture>();
		Scanner sc = new Scanner(System.in);
		Boolean fileend = false;
		int index;

		try {
			FileUtils file = new FileUtils("furniture.txt");
			System.out.println("Total num of generated objects: ");
			file.genFile(sc.nextInt());
			System.out.println("Enter price of the 1st product: ");
			price = sc.nextInt();
			sc.close();
			StringBuffer buff = file.loadFile();
			while (!fileend) {
				if ((index = buff.indexOf("|")) > 1) {
					String[] row = buff.substring(0, index).toString().split(",");
					furniture.add(new Furniture(row[0], row[1], new int[] { Integer.parseInt(row[2]),
							Integer.parseInt(row[3]), Integer.parseInt(row[4]) }));
					buff.delete(0, index +1);
				} else {
					fileend = true;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		furnitureSorted = furniture;
		furnitureSorted.sort(new Furniture.SortbyLength());

		int diff, i = 0;
		for (; furnitureSorted.size() > 0 && !full; i++) {
			i = 0;
			if ((truck[0] - furnitureSorted.get(i).getLength()) > 0) {
				if ((diff = truck[1] - furnitureSorted.get(i).getWidth()) > 0) {
					truck[0] -= furnitureSorted.get(i).getLength();
					int[] temp = new int[] { diff, furnitureSorted.get(i).getLength() };
					System.out.println(furnitureSorted.get(i).toString() + " succesfully loaded.");
					furnitureSorted.remove(i);
					for (int n = 0; n < furnitureSorted.size(); n++) {
						if ((temp[0] - furnitureSorted.get(n).getWidth() > 0) && (temp[1] - furnitureSorted.get(n)
								.getLength()) > 0) {
							temp[0] -= furnitureSorted.get(n).getWidth();
							System.out.println(furnitureSorted.get(n).toString() + " succesfully loaded.");
							furnitureSorted.remove(n);
						}
					}

				}
			} else {
				System.out.println(trucks + ". truck FULL");
				trucks += 1;
				truck = new int[] { 5000 + rand.nextInt(9000), 500 + rand.nextInt(500) };
			}
			if (furnitureSorted.size() == 0) {
				System.out.println("All objects loaded");
				full = true;
			}
		}
		System.out.println("Total number of trucks to load: " + trucks);
		System.out.println("Total price of furniture: " + Furniture.getFullPrice());

	}
}
