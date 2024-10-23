package in.BB.Backend;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import DATABASECON.DBCONN;
import DBDAO.UserDAO;
import MODEL.WEBMODEL;



//this is userLogin Server Backend Process  Class

@WebServlet("/LOGIN")
public class LOGIN extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		try (PrintWriter out = res.getWriter()) {

			String name = req.getParameter("name1").trim();
			String password = req.getParameter("pass1").trim();

			if (name.isEmpty() || password.isEmpty()) {

				return;
			}

			try {

				UserDAO udao = new UserDAO(DBCONN.getConnection());

				WEBMODEL user = udao.userlogin(name, password);

				if (user != null) {

					req.getSession().setAttribute("username", user.getName().toUpperCase());

					res.sendRedirect("PROFILE.jsp");

				} else {

					out.print("<h1 style=\"color: red;\">user login failed</h1>");
				}
			} catch (Exception e) {

			}
		}

	}
}
