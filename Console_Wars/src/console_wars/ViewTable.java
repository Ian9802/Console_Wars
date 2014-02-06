package console_wars;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewTable {

	public ViewTable() {

	}

	public ViewTable(Connection con, String dbName) throws SQLException {
		Statement stmt = null;
		// Just a type of call same in sql
		String query = "select TYPE, ATTACK, DAMAGE, " + "from " + dbName
				+ ".Units";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// rs.getString(string ColumnLabel)
				String typeName = rs.getString("TYPE");
				int attack = rs.getInt("ATTACK");
				int damage = rs.getInt("DAMAGE");
				System.out.println(typeName + "\n" + attack + "\n" + damage
						+ "\n");
			}

		} catch (SQLException e) {

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}