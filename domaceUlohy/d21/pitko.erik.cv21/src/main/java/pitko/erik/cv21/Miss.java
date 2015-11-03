package pitko.erik.cv21;

import java.util.ArrayList;
import java.util.Comparator;

public class Miss {
	private String name;
	private String surname;
	private int age;
	private Vzdelanie vzdelanie;
	private ArrayList<Language> language;
	private String vitalStatistics;
	private int vitalScore;

	public Miss(String name, String surname, int age, Vzdelanie vzdelanie, ArrayList<Language> language,
			String vitalStatistics) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.vzdelanie = vzdelanie;
		this.language = language;
		this.vitalStatistics = vitalStatistics;
		String[] parts = vitalStatistics.split("-");
		this.vitalScore = Math.abs(90 - Integer.parseInt(parts[0])) + Math
				.abs(60 - Integer.parseInt(parts[1]) + Math.abs(90 - Integer.parseInt(parts[2])));
	}

	public final static class Sorter implements Comparator<Miss> {

		@Override
		public int compare(Miss o1, Miss o2) {
			int out = o1.getVitalScore() - o2.getVitalScore();
			if (out <= -5 || out >= 5) {
				out = o1.getNumofLanguages() - o2.getNumofLanguages();
				if (out == 0){
					out = o1.getAge() - o2.getAge();					
				}
				if (out == 0) {
					out = o1.getVzdelanie().compareTo(o2.getVzdelanie());
				}
			}
			return out;
		}

	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getVitalScore() {
		return vitalScore;
	}

	public int getAge() {
		return age;
	}

	public int getNumofLanguages() {
		return language.size();
	}

	public Vzdelanie getVzdelanie() {
		return vzdelanie;
	}

	public ArrayList<Language> getLanguage() {
		return language;
	}

	public String getVitalStatistics() {
		return vitalStatistics;
	}

	@Override
	public String toString() {
		return "Miss [name=" + name + ", surname=" + surname + ", age=" + age + ", vzdelanie=" + vzdelanie + " number of learnt languages: " + getNumofLanguages() + ", language=" + language + ", vitalStatistics=" + vitalStatistics + ", vitalScore=" + vitalScore + "]";
	}

	// @Override
	// public String toString() {
	// return "Miss [name=" + name + ", surname=" + surname + ", age=" + age +
	// ", vzdelanie=" + vzdelanie + ", language=" + language + ",
	// vitalStatistics=" + vitalStatistics + "]";
	// }

}
