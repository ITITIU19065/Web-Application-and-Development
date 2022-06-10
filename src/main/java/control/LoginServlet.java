package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.loginDAO;
import entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =UTF-8");
		String checkingLogin ="";
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("accountName");
		String pass = request.getParameter("accountPass");
		User user = new User(userName,pass);
		if(userName.length() == 0 || pass.length() == 0) {
			checkingLogin = "empty";
			session.setAttribute("checkingLogin", checkingLogin);
			response.sendRedirect("login.jsp");
		}else {
			if("admin@admin".equals(userName) && "admin".equals(pass)) {
				session.setAttribute("user", userName);
				response.sendRedirect("AdminIndex.jsp");
			}else {
				loginDAO login = new loginDAO();
				User checking = login.login(userName,pass);
				if(checking == null) {
					checkingLogin = "failed";
					session.setAttribute("checkingLogin", checkingLogin);
					response.sendRedirect("login.jsp");
				}else {
					session.setAttribute("user", userName);
					response.sendRedirect("index.jsp");
					
				}
			}
		}
	}

}
