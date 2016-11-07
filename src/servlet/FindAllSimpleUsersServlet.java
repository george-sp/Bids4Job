package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.SimpleUser;
import service.SimpleUserService;

/**
 * Servlet implementation class FindAllSimpleUsersServlet
 */
@WebServlet("/FindAllSimpleUsers")
public class FindAllSimpleUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindAllSimpleUsersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// RequestDispatcher to forward in created and stored successfully in
		// database
		RequestDispatcher resultDispatcher = getServletContext().getRequestDispatcher("/find_all_results.jsp");
		
		// Instantiate a service for SimpleUser database operations
		SimpleUserService simpleUserService = new SimpleUserService();

		// A List to store all existing SimpleUsers
		List<SimpleUser> simpleUsers = new ArrayList<SimpleUser>();
		
		try {
			simpleUsers = simpleUserService.findAll();
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		// Set SimpleUser to request
		request.setAttribute("simpleUsers", simpleUsers);
		resultDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
