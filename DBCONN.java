package DATABASECON;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



//this is a database connection class

public class DBCONN {

	private static Connection connection = null;

	static public Connection getConnection() throws SQLException {

		if (connection == null) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/INTERNSHIP", "root", "root");
				System.out.println("sucessfull");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return connection;
	}

}
