package pitko.molnar.z1;

import java.sql.SQLException;

public class Main {
	public static final String ip = "192.168.1.48";

	public static void main(String[] args) {
		try {
			Mysql mysql = new Mysql();
			mysql.printEmployees("employee");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
