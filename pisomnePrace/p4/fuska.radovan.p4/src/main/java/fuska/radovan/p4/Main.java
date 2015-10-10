package fuska.radovan.p4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static ArrayList<Nabytok> list;
	static Scanner sc;

	public static void main(String[] args) {
		list = new ArrayList<Nabytok>();
		sc = new Scanner(System.in);

		int option = 0;
		while(option != 6) {
			printMenu();
			System.out.print("Enter option:");
			option = sc.nextInt();
			switch(option) {
				case 1:
					add();
					break;
				case 2:
					remove();
					break;
				case 3:
					list();
					break;
				case 4:
					generate();
					break;
				case 5:
					compute();
					break;
			}
		}
		sc.close();
	}

	static void add() {
		System.out.print("Enter type:");
		Typ typ = Typ.GetType(sc.next());
		System.out.print("Enter material:");
		Material material = Material.GetType(sc.next());
		System.out.print("Enter red component of color:");
		int r = sc.nextInt();
		System.out.print("Enter green component of color:");
		int g = sc.nextInt();
		System.out.print("Enter blue component of color:");
		int b = sc.nextInt();
		Color farba = new Color(r, g, b);
		System.out.print("Enter height:");
		int vyska = sc.nextInt();
		System.out.print("Enter width:");
		int sirka = sc.nextInt();
		System.out.print("Enter length:");
		int dlzka = sc.nextInt();
		System.out.print("Enter price:");
		int cena = sc.nextInt();
		Nabytok n = new Nabytok(typ, farba, material, vyska, sirka, dlzka, cena);
		list.add(n);
	}

	static void remove() {
		System.out.print("Enter index to remove:");
		int i = sc.nextInt();
		list.remove(i);
	}

	static void list() {
		for(int c = 0; c < list.size(); c++)
			System.out.format("%d: %s\n", c, list.get(c).toString());
	}

	static void generate() {
		System.out.print("Enter number of items to generate:");
		int n = sc.nextInt();

		Random r = new Random();

		int t = Typ.values().length;
		int m = Material.values().length;
		for(int c = 0; c < n; c++) {
			list.add(new Nabytok(Typ.values()[r.nextInt(t)], new Color(r.nextInt(0xFFFFFF)), Material.values()[r.nextInt(m)], r.nextInt(2) + 1, r.nextInt(3) + 1, r.nextInt(3) + 1, r.nextInt(1000)));
		}
	}

	static void compute() {
		Packer p = new Packer();
		Packer.Kamion[] k = p.pack(list.toArray(new Nabytok[0]), 3, 15);
		for(int i = 0; i < k.length; i++)
			for(int n = 0; n < k[i].nabytok.length; n++) {
				System.out.format("%d: #%d id=%d at x= %d y=%d\n", i + 1, n + 1, k[i].nabytok[n].Id, k[i].nabytok[n].X, k[i].nabytok[n].Y);
			}
	}

	static void printMenu() {
		System.out.println("1: Add");
		System.out.println("2: Remove");
		System.out.println("3: Show list");
		System.out.println("4: Generate random");
		System.out.println("5: Compute space");
		System.out.println("6: Exit");
	}
}