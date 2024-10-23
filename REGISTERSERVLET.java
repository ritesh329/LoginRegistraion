package in.BB.Backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DATABASECON.DBCONN;
import DBDAO.RegistrationDAO;
import MODEL.WEBMODEL;

@WebServlet("/logreg")
public class REGISTERSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String username = request.getParameter("username1").trim();
		String email = request.getParameter("email1").trim();
		String password = request.getParameter("pass1").trim();

		if (username.isEmpty() | email.isEmpty() | password.isEmpty()) {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please Fill All Field');");
			out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/REGISTRATION.html");
			rd.include(request, response);

			return;
		}

		try {

			RegistrationDAO ud = new RegistrationDAO(DBCONN.getConnection());

		} catch (SQLException e) {

			e.printStackTrace();
		}
		WEBMODEL model = new WEBMODEL();
		model.setName(username);
		model.setEmail(email);
		model.setPassword(password);

		boolean che = RegistrationDAO.checkUserAlreadyExist(model);
		if (che) {

			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Already registered');");
			out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/REGISTRATION.html");
			rd.include(request, response);
			return;

		}

		boolean ans = RegistrationDAO.register(model);

		if (ans == true) {

			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Register Sucessfully');");
			out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/REGISTRATION.html");
			rd.include(request, response);

		} else {

			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User not Register please try Again');");
			out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/REGISTRATION.html");
			rd.include(request, response);
		}

	}
}
