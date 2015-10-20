package pitko.erik.cv21;

import java.util.ArrayList;

import pitko.erik.cv21.Miss.Sorter;

public class Main {

	public static ArrayList<Miss> missList = new ArrayList<Miss>();
	
	public static void main(String[] args) {
		FileUtils.readFromFile("miss");
		for (int i = 0; i < missList.size(); i++){
			System.out.println(missList.get(i).toString());
		}
		System.out.println();
		calcScore();

	}
	
	private static void calcScore(){
//		if (based.equals("age")){
			ArrayList<Miss> ageList= missList;
			ageList.sort(new Sorter());
			
			for (int i = 0; i < ageList.size(); i++){
				System.out.println(ageList.get(i).toString());
			}
			
//		}
	}

}
