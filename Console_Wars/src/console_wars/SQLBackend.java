package console_wars;

import java.sql.*;
import java.math.*;

/**
 * TODO Put here a description of what this class does.
 *
 * @author samynpd.
 *         Created Feb 5, 2014.
 */
public class SQLBackend {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String username = "";
		String password = "";
		String url = "jdbc:sqlserver://titan.cs.rose-hulman.edu;databaseName=Console_Wars";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		if(!(conn == null)) {
			System.out.println("connected");
		}
		
		Statement s1 = conn.createStatement();
		ResultSet rs = s1.executeQuery("SELECT TOP 1000 * FROM [Console_Wars].[dbo].[Units]");
		String[] result = new String[20];
		
		if(rs!=null) {
			while(rs.next()) {

				
				String mem = rs.getString(1);
				System.out.println("Result is " + mem);
			}
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	
}
