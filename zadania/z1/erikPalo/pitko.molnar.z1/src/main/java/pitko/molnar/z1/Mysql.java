package pitko.molnar.z1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Mysql {
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;

	public Mysql() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://"+ Main.ip + "/irc", "kosec", "kondor");
		st = con.createStatement();
	}
	
	
	public void write(String nick, int UserID) throws SQLException{
		pst = con.prepareStatement("INSERT INTO sessions(nick, userID) VALUES(?, ?)");
		pst.setString(1, nick);
		pst.setInt(2, UserID);
		pst.executeUpdate();
	}

	public String search(String table, String row, String msg) throws SQLException {
		rs = st.executeQuery("SELECT * from " + table + " WHERE " + row + "='" + msg + "'");
		if (rs.next()) {
			return msg;
		} else {
			return "N";
		}
	}

	public ResultSet printEmployees(String table) throws SQLException {
		rs = st.executeQuery("SELECT * from " + table);
		return rs;
	}


	public void close() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
		if (pst != null) {
			pst.close();
		}
	}
}