package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnections extends base{
	public void setConnection() throws SQLException {
		
		String port= prp.getProperty("port");
		String host=prp.getProperty("host");
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/DBQA", "root", "117707Ash@");
		Statement s= con.createStatement();
		ResultSet rs= s.executeQuery("Select * from DBQA where UserName='amazher'");
		while(rs.next()) {
	System.out.println(rs.getString("Name"));
	System.out.println(rs.getString("Password"));
		}
		
	}
	
	
}


