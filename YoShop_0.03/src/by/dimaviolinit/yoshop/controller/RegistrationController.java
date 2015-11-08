package by.dimaviolinit.yoshop.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.dimaviolinit.yoshop.DAO.IUserDAO;
import by.dimaviolinit.yoshop.DAO.impl.DAOFactory;
import by.dimaviolinit.yoshop.domain.User;

public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = -4006561145676424435L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if ((name == null || "".equals(name)) || (email == null || "".equals(email))
				|| (password == null || "".equals(password))) {
			String error = "Mandatory Parameters Missing";
			request.getSession().setAttribute("errorReg", error);
			response.sendRedirect("index.jsp#register");
		} else {

			User user = new User();
			user.setEmail(email);
			user.setLogin(name);
			user.setPassword(password);

			DAOFactory factory = DAOFactory.getInstance();
			IUserDAO userDAO = factory.getUserDAO();

			try {
				boolean result = userDAO.addUser(user);
				if (result) {
					request.getSession().removeAttribute("errorReg");
					response.sendRedirect("success.jsp");
				} else {
					request.getSession().setAttribute("errorReg", "Internal Server Error, Please try again later.");
					response.sendRedirect("index.jsp#register");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}