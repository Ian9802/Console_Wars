package console_wars;

import java.sql.*;
import java.math.*;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author samynpd. Created Feb 5, 2014.
 */
public class SQLBackend {

	private static String username = "";
	private static String password = "";
	private static String url = "jdbc:sqlserver://titan.cs.rose-hulman.edu;databaseName=Console_Wars";

	private static Connection conn;

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			connectToDB();

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("SELECT TOP 1000 [name],[HQ],[perks] FROM [Console_Wars].[dbo].[Companies]");
			// String[] result = new String[20];

			if (rs != null) {
				while (rs.next()) {

					String name = rs.getString("name");
					String hq = rs.getString("HQ");
					int perks = rs.getInt("perks");
					System.out.println(name + " " + hq + " " + " " + perks);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Connect to DB
	 * 
	 */
	public static void connectToDB() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			if (!(conn == null)) {
				System.out.println("connected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getCompanies() {

		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("SELECT TOP 1000 [name],[HQ],[perks] FROM [Console_Wars].[dbo].[Companies]");

			if (rs != null) {
				while (rs.next()) {

					String name = rs.getString("name");
					String hq = rs.getString("HQ");
					int perks = rs.getInt("perks");
					System.out.println(name + " " + hq + " " + " " + perks);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getUnits() {

		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("SELECT TOP 1000 [unitName],[ability],[attack],[defense],[attackRange],[type],[name],[genName],[mobility],[life] FROM [Console_Wars].[dbo].[Units]");

			if (rs != null) {
				while (rs.next()) {

					String unitName = rs.getString("unitName");
					int ability = rs.getInt("ability");
					int attack = rs.getInt("attack");
					int defense = rs.getInt("defense");
					int attackRange = rs.getInt("attackRange");
					int type = rs.getInt("type");
					String name = rs.getString("name");
					String genName = rs.getString("genName");
					int mobility = rs.getInt("mobility");
					int life = rs.getInt("life");

					System.out.println(unitName + " " + ability + " " + attack
							+ " " + defense + " " + attackRange + " " + type
							+ " " + name + " " + genName + " " + mobility + " "
							+ life);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getGenerals() {

		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("SELECT TOP 1000 [unitName],[ability],[attack],[defense],[attackRange],[type],[name],[genName],[mobility],[life] FROM [Console_Wars].[dbo].[Units] WHERE unitName = genName");

			if (rs != null) {
				while (rs.next()) {

					String unitName = rs.getString("unitName");
					int ability = rs.getInt("ability");
					int attack = rs.getInt("attack");
					int defense = rs.getInt("defense");
					int attackRange = rs.getInt("attackRange");
					int type = rs.getInt("type");
					String name = rs.getString("name");
					String genName = rs.getString("genName");
					int mobility = rs.getInt("mobility");
					int life = rs.getInt("life");

					System.out.println(unitName + " " + ability + " " + attack
							+ " " + defense + " " + attackRange + " " + type
							+ " " + name + " " + genName + " " + mobility + " "
							+ life);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getRegions() {

		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("SELECT TOP 1000 [regionID],[controlling],[controlValue],[resourcesAmmo],[resourcesFuel] FROM [Console_Wars].[dbo].[Region]");

			if (rs != null) {
				while (rs.next()) {

					int regionID = rs.getInt("regionID");
					String controlling = rs.getString("controlling");
					int controlValue = rs.getInt("controlValue");
					int resourcesAmmo = rs.getInt("resourcesAmmo");
					int resourcesFuel = rs.getInt("resourcesFuel");

					System.out.println(regionID + " " + controlling + " " + controlValue + " " + resourcesAmmo + " " + resourcesFuel);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getPlayer() {
		//TODO
		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("SELECT TOP 1000 [regionID],[controlling],[controlValue],[resourcesAmmo],[resourcesFuel] FROM [Console_Wars].[dbo].[Region]");

			if (rs != null) {
				while (rs.next()) {

					int regionID = rs.getInt("regionID");
					String controlling = rs.getString("controlling");
					int controlValue = rs.getInt("controlValue");
					int resourcesAmmo = rs.getInt("resourcesAmmo");
					int resourcesFuel = rs.getInt("resourcesFuel");

					System.out.println(regionID + " " + controlling + " " + controlValue + " " + resourcesAmmo + " " + resourcesFuel);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void queryDB(String query) {
		// not useful since dont know return values

		try {
			Statement s1 = conn.createStatement();
			ResultSet rs = s1.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
