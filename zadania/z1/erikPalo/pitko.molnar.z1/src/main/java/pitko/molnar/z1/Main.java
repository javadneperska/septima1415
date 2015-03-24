package pitko.molnar.z1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
	public static final String ip = "88.212.33.75";
	private static ArrayList<Employee> CUSTARR = new ArrayList<Employee>();
	private static Hashtable<Type, Subjects> TABLE= new Hashtable<Type, Subjects>();	
	private static Type expertise;

	public static void main(String[] args) {
		try {
			Mysql mysql = new Mysql();
			mysql.printEmployees("employee");
			ResultSet msg = mysql.printEmployees("employee");
			while (msg.next()) {
				String[] teachingSubjects = msg.getString("teachingSubjects").split(",");
				expertise = Utilities.getType(msg.getString("expertiese"));
				if (expertise != null) {
					CUSTARR.add(new Employee(msg.getString("name"), msg.getString("surname"),
							msg.getString("birthNum"), msg.getBoolean("gender"), msg.getInt("lastJobs"), msg
									.getInt("experienceYears"), teachingSubjects, msg.getInt("age"), msg
									.getString("city"), msg.getString("country"), msg.getString("district"), msg
									.getInt("houseNum"), msg.getString("street"), expertise));
				} else {
					System.out.println("Invalid expertise of employee: " + msg.getString("name"));
				}
			}
			for (int i = 0; i < CUSTARR.size(); i++) {
				System.out.println(CUSTARR.get(i).toString());
			}
			String[] favorite = new String[Employee.max];
			int n = 0;
			for (Type k : Type.values()) {
				int j = 0;
				for (int i = 0; i < CUSTARR.size(); i++) {
					if (CUSTARR.get(i).getExpertise() == k) {
						
						for (String temp : CUSTARR.get(i).getSubjects()) {
							favorite[n] = temp;
							n += 1;
							TABLE.put(k, Utilities.getSubject(temp));
							}
						}
					}
				}
			
//			for (String k : favorite) {
//				System.out.println(k);
//			}
			for (int i = 0; i<TABLE.size(); i++){
				for (Type k : Type.values()){
					System.out.println(k + " : " + TABLE.get(k));			
				}				
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
