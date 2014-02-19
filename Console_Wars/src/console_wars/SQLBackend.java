package console_wars;

import java.sql.*;
import java.util.ArrayList;
import java.awt.Color;
import java.math.*;

import javax.swing.JFrame;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author samynpd. Created Feb 5, 2014.
 */
public class SQLBackend {

	private static String username = "hallami";
	private static String password = "R0settaSt0ne";

	private static String url = "jdbc:sqlserver://titan.cs.rose-hulman.edu;databaseName=Console_Wars";

	private static Connection conn;
	private static String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h",
			"i", "j" };

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

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @return
	 */
	public static Company[] getCompanies() {

		ArrayList<Company> companies = new ArrayList<Company>();

		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("Exec getCompanies");

			if (rs != null) {
				while (rs.next()) {

					String name = rs.getString("name");
					String hq = rs.getString("HQ");
					int perks = rs.getInt("perks");
					// System.out.println(name + " " + hq + " " + " " + perks);

					companies.add(new Company(name, hq, perks));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return companies.toArray(new Company[companies.size()]);
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 */
	public static Units[] getUnits() {

		ArrayList<Units> units = new ArrayList<Units>();
		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("Exec getUnits");

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
					
					units.add(new Units(unitName, ability, attack, defense, attackRange, type, name, genName, mobility, life));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return units.toArray(new Units[units.size()]);
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 */
	public static Units[] getGenerals() {

		ArrayList<Units> units = new ArrayList<Units>();
		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("Exec getGeneral");

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
					
					units.add(new Units(unitName, ability, attack, defense, attackRange, type, name, genName, mobility, life));
					
					System.out.println(unitName + " " + ability + " " + attack
							+ " " + defense + " " + attackRange + " " + type
							+ " " + name + " " + genName + " " + mobility + " "
							+ life);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return units.toArray(new Units[units.size()]);
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 */
	public static void getRegions() {

		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("Exec getRegion");

			if (rs != null) {
				while (rs.next()) {

					int regionID = rs.getInt("regionID");
					String controlling = rs.getString("controlling");
					int controlValue = rs.getInt("controlValue");
					int resourcesAmmo = rs.getInt("resourcesAmmo");
					int resourcesFuel = rs.getInt("resourcesFuel");

					System.out.println(regionID + " " + controlling + " "
							+ controlValue + " " + resourcesAmmo + " "
							+ resourcesFuel);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 */
	public static void getPlayer() {
		// TODO
		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("Exec getRegion");

			if (rs != null) {
				while (rs.next()) {

					int regionID = rs.getInt("regionID");
					String controlling = rs.getString("controlling");
					int controlValue = rs.getInt("controlValue");
					int resourcesAmmo = rs.getInt("resourcesAmmo");
					int resourcesFuel = rs.getInt("resourcesFuel");

					System.out.println(regionID + " " + controlling + " "
							+ controlValue + " " + resourcesAmmo + " "
							+ resourcesFuel);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @return
	 */
	public static String[] getCompaniesNamesList() {

		Company[] companies = getCompanies();
		ArrayList<String> names = new ArrayList<String>();

		for (int i = 0; i < companies.length; i++) {
			names.add(companies[i].getName());
		}
		//
		// try {
		//
		// Statement s1 = conn.createStatement();
		// ResultSet rs = s1
		// .executeQuery("SELECT TOP 1000 [name],[HQ],[perks] FROM [Console_Wars].[dbo].[Companies]");
		//
		// if (rs != null) {
		// while (rs.next()) {
		//
		// String name = rs.getString("name");
		//
		// names.add(name);
		// }
		// }
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		String[] namesArray = names.toArray(new String[names.size()]);
		return namesArray;
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

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @return
	 */
	public static Integer[] getLevelIDsList(JFrame frame, Game game) {
		Level[] levels = getLevels(frame, game);
		ArrayList<Integer> names = new ArrayList<Integer>();

		for (int i = 0; i < levels.length; i++) {
			names.add(levels[i].getLevelID());
		}
		return names.toArray(new Integer[names.size()]);
	}

	public static Level[] getLevels(JFrame frame, Game game) {

		ArrayList<Level> levels = new ArrayList<Level>();

		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("Exec getLevelLayout");

			if (rs != null) {
				while (rs.next()) {
					int levelID = rs.getInt("layoutID");
					Level newLevel = new Level(levelID, frame, game);

					for (int i = 0; i < letters.length; i++) {
						for (int j = 0; j < 10; j++) {
							String key = letters[i] + j;

							int tileInt = rs.getInt(key);

							AbstractTile tile = new AbstractTile(i
									* Main.TILE_SIZE, j * Main.TILE_SIZE);

							if (tileInt == 1) {
								//
							} else if (tileInt == 2) {
								tile.setMoveThrough(false);
								tile.setColor(Color.black);
							} else {
								//
							}

							newLevel.setTile(i, j, tile);

						}
					}
					levels.add(newLevel);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return levels.toArray(new Level[levels.size()]);
	}

	public static Units getUnitForName(String unitNameRequested) {
		
		Units unit = null;
		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("Exec getUnitData @unitName = '" + unitNameRequested + "'");

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
					
					unit = new Units(unitName, ability, attack, defense, attackRange, type, name, genName, mobility, life);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return unit;
		
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 * 
	 */
	public static Units[][] getUnitLayout(int layoutNum) {

		Units[][] unitList = new Units[10][10];
		
		try {

			Statement s1 = conn.createStatement();
			ResultSet rs = s1
					.executeQuery("Exec getUnitLocation @unitName = '" + layoutNum + "'");

			if (rs != null) {
				while (rs.next()) {

					for (int i = 0; i < letters.length; i++) {
						for (int j = 0; j < 10; j++) {
							String key = letters[i] + j;

							String unitName = rs.getString(key);

							if (unitName.equals("x")) {
								unitList[i][j] = null;
//								System.out.println("null");
							} else {
								unitList[i][j] = getUnitForName(unitName);
								unitList[i][j].setX(Main.TILE_SIZE * i);
								unitList[i][j].setY(Main.TILE_SIZE * j);
//								System.out.println(unitList[i][j].getUnitName());
							}

						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return unitList;
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 * 
	 */
	public static void updateRegion(String name, int id) {

		// company name, level id
		try {
			Statement s1 = conn.createStatement();
			s1.executeQuery("Exec regionChange @ID = '" + id + "'" + " @winner = '" + name + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
