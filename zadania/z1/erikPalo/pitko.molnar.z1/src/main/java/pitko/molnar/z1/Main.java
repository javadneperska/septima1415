package pitko.molnar.z1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {
	public static final String ip = "192.168.1.48";
	private static ArrayList<Employee> CUSTARR = new ArrayList<Employee>();
	private static Hashtable<Type, SubjEmp> TABLE= new Hashtable<Type, SubjEmp>();	
	// SubjEmp>();
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
			int j;
			for (Type k : Type.values()) {
				int bio = 0;
				int chem = 0;
				int cze = 0;
				int eng = 0;
				int math = 0;
				int n = 0;
				for (int i = 0; i < CUSTARR.size(); i++) {
					if (CUSTARR.get(i).getExpertise() == k) {
						
						for (String temp : CUSTARR.get(i).getSubjects()) {
							favorite[n] = temp;
							n += 1;
							System.out.println(k + " : " + temp);
							SubjEmp subjemp = new SubjEmp();
							switch(Utilities.getSubject(temp)){
							case BIOGRAPHY:
								bio++;
								break;
							case CHEMISTRY:
								chem++;
								break;
							case CZECH:
								cze++;
								break;
							case ENGLISH:
								eng++;
								break;
							case MATH:
								math++;
								break;
								
							}
							if (TABLE.containsKey(k)){
								j = TABLE.get(k).nOfSubj;
								Subject s = TABLE.get(k).subj;
								subjemp.nOfSubj = ++j;
								subjemp.subj = s;
								subjemp.bio = bio;
								subjemp.chem = chem;
								subjemp.cze = cze;
								subjemp.eng = eng;
								subjemp.math = math;
								
								TABLE.put(k, subjemp);
							}else{
								subjemp.subj = Utilities.getSubject(temp);
								subjemp.nOfSubj = 1;
								
								TABLE.put(k, subjemp);
							}
							}
						}
					}
				}
			System.out.println("###################");
			for (Type k : Type.values()){
					System.out.println(k + " : " + TABLE.get(k).nOfSubj);			
					System.out.println(Subject.BIOGRAPHY + " : " + TABLE.get(k).bio);
					System.out.println(Subject.CHEMISTRY + " : " + TABLE.get(k).chem);
					System.out.println(Subject.CZECH + " : " + TABLE.get(k).cze);
					System.out.println(Subject.ENGLISH + " : " + TABLE.get(k).eng);
					System.out.println(Subject.MATH + " : " + TABLE.get(k).math);
					System.out.println("favorite subject: " + TABLE.get(k).max());
					if (TABLE.get(k).bio == TABLE.get(k).max()){
						System.out.println("favourite: " + Subject.BIOGRAPHY);
					}
					if (TABLE.get(k).chem == TABLE.get(k).max()){
						System.out.println("favourite: " + Subject.CHEMISTRY);						
					}
					if (TABLE.get(k).cze == TABLE.get(k).max()){
						System.out.println("favourite: " + Subject.CZECH);												
					}
					if (TABLE.get(k).eng == TABLE.get(k).max()){
						System.out.println("favourite: " + Subject.ENGLISH);																		
					}
					if (TABLE.get(k).math == TABLE.get(k).max()){
						System.out.println("favourite: " + Subject.MATH);																								
					}
					System.out.println("###################");
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
