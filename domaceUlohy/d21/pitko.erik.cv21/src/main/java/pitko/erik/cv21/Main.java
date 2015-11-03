package pitko.erik.cv21;

import java.util.ArrayList;
import java.util.Scanner;

import pitko.erik.cv21.Miss.Sorter;

public class Main {

	private static ArrayList<Miss> missList = new ArrayList<Miss>();
	
	public static void main(String[] args) {
		boolean inmenu = true;
		Scanner sc = new Scanner(System.in);
		String option;
		refreshList();
		do {
			Utils.printMenu();
			option = sc.nextLine();
			switch(option){
			case "1":
				for (int i = 0; i < missList.size(); i++){
					System.out.println(missList.get(i).toString());
				}
				break;
			case "2":
				refreshList();
				break;
			case "3":
				try{
				missList.add(Utils.createMissList(Utils.keyboardEntry()).get(0));
				}catch(Exception e){
					System.out.println(e);
				}
				break;
			case "4":
				calcScore();
				break;
			case "5":
				inmenu = false;
			}
		}while (inmenu);
		sc.close();

	}
	
	private static void refreshList(){
		ArrayList<Miss> temp = Utils.createMissList(Utils.readFromFile("miss"));
		for(int i = 0; i < temp.size(); i++){
			missList.add(temp.get(i));
		}
		temp = null;
	}
	
	private static void calcScore(){
			ArrayList<Miss> ageList= missList;
			ageList.sort(new Sorter());
			
			for (int i = 0; i < ageList.size(); i++){
				System.out.println(ageList.get(i).toString());
			}
			
	}

}
