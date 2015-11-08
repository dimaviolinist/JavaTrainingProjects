package by.dimaviolinit.yoshop.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.dimaviolinit.yoshop.DAO.IUserDAO;
import by.dimaviolinit.yoshop.DAO.impl.DAOFactory;
import by.dimaviolinit.yoshop.domain.User;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -4602272917509602701L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error;
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		DAOFactory factory = DAOFactory.getInstance();
		IUserDAO userDAO = factory.getUserDAO();

		User userDB;
		try {
			userDB = userDAO.loginUser(login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//
		// if (userDB.getName() == null) {
		// error = "Invalid Email or password";
		// session.setAttribute("error", error);
		// response.sendRedirect("index.jsp");
		// } else {
		// session.setAttribute("user", userDB.getName());
		// session.removeAttribute("error");
		// response.sendRedirect("welcome.jsp");
		// }
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("logout".equalsIgnoreCase(request.getParameter("param"))) {
			HttpSession session = request.getSession();
			if (session != null) {
				session.invalidate();
			}
			response.sendRedirect("index.jsp");
		}
	}
}