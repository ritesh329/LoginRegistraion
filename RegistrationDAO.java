package DBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

import MODEL.WEBMODEL;
import jakarta.servlet.RequestDispatcher;

public class RegistrationDAO {

	private static Connection con;

	private static String q;

	private static PreparedStatement pst;

	public RegistrationDAO(Connection connection) {

		this.con = connection;
	}

	
	// this function check user already exist or not if user already exist show alert massage
	
	public static boolean checkUserAlreadyExist(WEBMODEL model) {

		boolean state = false;
		try {

			String query = "SELECT * FROM user WHERE name = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, model.getName());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				state = true;
			}

		} catch (Exception e) {

			System.out.print("It is database Exception");
			return state;
		}

		return state;
	}

//   user registration part

	public static boolean register(WEBMODEL model) {

		boolean result = false;

		try {

			q = "insert into user(name,email,pass) values(?,?,?)";
			pst = con.prepareStatement(q);
			pst.setString(1, model.getName());
			pst.setString(2, model.getEmail());
			pst.setString(3, model.getPassword());

			pst.executeUpdate();

			result = true;

		} catch (Exception e) {

			e.printStackTrace();
			return result;
		}

		return result;

	}
}
