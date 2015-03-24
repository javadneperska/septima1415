package pitko.molnar.z1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	public static final String ip = "192.168.1.48";
	private static ArrayList<Employee> CUSTARR= new ArrayList<Employee>();
	private static Type type;

	public static void main(String[] args) {
		try {
			Mysql mysql = new Mysql();
			mysql.printEmployees("employee");
			ResultSet msg = mysql.printEmployees("employee");
			while (msg.next()){
				String[] teachingSubjects = msg.getString("teachingSubjects").split(",");
				switch(msg.getString("expertiese")){
				case "profesor":
					type = type.PROFESOR;
					break;
				case "docent":
					type = type.DOCENT;
					break;
			}
				CUSTARR.add(new Employee(msg.getString("name"), msg.getString("surname"), msg.getString("birthNum"), msg.getBoolean("gender"), msg.getInt("lastJobs"), msg.getInt("experienceYears"), teachingSubjects, msg.getInt("age"), msg.getString("city"), msg.getString("country"), msg.getString("district"), msg.getInt("houseNum"), msg.getString("street"), type));
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
