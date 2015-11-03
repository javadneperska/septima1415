package pitko.erik.cv21;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
	private static UrovenCJ selectLanguage(String language) {
		UrovenCJ cj;
		switch (language) {
		case "A2":
			cj = UrovenCJ.A2;
			break;
		case "B1":
			cj = UrovenCJ.B1;
			break;
		case "B2":
			cj = UrovenCJ.B2;
			break;
		case "C1":
			cj = UrovenCJ.C1;
			break;
		default:
			cj = UrovenCJ.A1;
			break;
		}
		return cj;
	}

	public static void printMenu() {
		System.out.println("1 = Print miss list");
		System.out.println("2 = Refresh miss list");
		System.out.println("3 = Add miss to list");
		System.out.println("4 = Sort list");
		System.out.println("5 = Exit");
	}

	public static StringBuffer readFromFile(String name) {
		StringBuffer buff = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(name + ".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found ! " + e);
		}

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				buff.append(line);
				buff.append(System.lineSeparator());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buff;
	}

	public static StringBuffer keyboardEntry() throws Exception {
		boolean notFinished = true;
		boolean selectedAllLanguages = false;
		boolean validEntry = false;
		StringBuffer buff = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print("Name: ");
				buff.append(sc.nextLine());
				buff.append(",");
				System.out.print("Surname: ");
				buff.append(sc.nextLine());
				buff.append(",");
				while (!validEntry) {
					try {
						System.out.print("Age: ");
						String age = sc.nextLine();
						if (age.equals("-1")) {
							throw new Exception("incorrect age");
						}
						if (Integer.parseInt(age) < 18 || Integer.parseInt(age) > 35) {
							throw new IllegalArgumentException();
						} else {
							validEntry = true;
						}
						buff.append(age);
						buff.append(",");
					} catch (IllegalArgumentException e) {
						System.out.println("Enter age between 18 - 35, enter -1 for exit");
					}
				}
				buff.append("lang=");
				System.out.print("Level of English(A1, A2, B1, B2, C1) enter -1 for no English: ");
				String loEnglish = sc.nextLine();
				if (loEnglish.equals("A1") || loEnglish.equals("-1")) {
					System.out.println("insufficient level of English");
					throw new Exception("insufficient English level");
				}
				buff.append("English");
				buff.append("-");
				buff.append(loEnglish);
				buff.append(":");
				do {
					System.out.println("enter another language ? (y/n)");
					if (sc.nextLine().equals("n")) {
						selectedAllLanguages = true;
						break;
					} else {
						buff.append(":");
					}
					System.out.print("Language: ");
					buff.append(sc.nextLine());
					buff.append("-");
					System.out.print("Language level(A1,A2,B1,B2,C1): ");
					buff.append(sc.nextLine());
				} while (selectedAllLanguages != true);
				buff.append(",");
				System.out.print("VitalStatistics(x,y,z): ");
				String vitStat = sc.nextLine();
				if(Integer.parseInt(vitStat.split(",")[0]) > 97){
					System.out.println("oversized");
					throw new Exception();
				}
				buff.append(sc.nextLine());
				buff.append(",");
				notFinished = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid input !");
			}
		} while (notFinished);
		sc.close();
		return buff;

	}

	public static ArrayList<Miss> createMissList(StringBuffer buff) {
		ArrayList<Miss> missList = new ArrayList<Miss>();
		while (buff.length() > 2) {
			ArrayList<Language> languages = new ArrayList<Language>();
			String[] parts = buff.substring(0, buff.indexOf(System.lineSeparator())).split(",");
			buff.delete(0, buff.indexOf(System.lineSeparator()) + 1);
			if (parts[4].contains("lang=")) {
				for (String language : parts[4].substring(parts[4].indexOf("=") + 1).split(":")) {
					String[] languagePart = language.split("-");
					languages.add(new Language(languagePart[0], selectLanguage(languagePart[1])));
				}
			}
			try {
				missList.add(new Miss(parts[0], parts[1], Integer.parseInt(parts[2]),
						(parts[3].equals("VS")) ? Vzdelanie.VYSOKOSKOLSKE : Vzdelanie.STREDOSKOLSKE, languages,
						parts[5]));
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid argument " + e);
			}
			languages = null;
		}
		return missList;
	}

}
