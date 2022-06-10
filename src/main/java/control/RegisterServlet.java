package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.registerDAO;
import entity.User;
import entity.UserDetail;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String checking ="";
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String rePass = request.getParameter("rePass");
		String question = request.getParameter("sercurity");
		String answer = request.getParameter("answer");
		
		registerDAO register = new registerDAO();
		
		if(userName.length() == 0 || pass.length() == 0 || rePass.length() == 0 || answer.length() == 0) {
			checking = "empty";
			session.setAttribute("checking", checking);
			response.sendRedirect("login.jsp");
		}else {
			if(userName.equals("admin@admin")) {
				checking = "invalidUser";
				session.setAttribute("checking", checking);
				response.sendRedirect("login.jsp");
			}else {
				if(pass.equals(rePass)) {
					try {
						int question_id = Integer.parseInt(question);
						User user = new User(userName,pass);
						UserDetail detail = new UserDetail(question_id,answer);
						String result = register.insert(user);
						String result2 = register.insertSercurity(detail);
						if(result.equals("successfully") && result2.equals("successfully")) {
							checking= "successfully";
							session.setAttribute("checking", checking);
							response.sendRedirect("login.jsp");
						}else {
							checking= "exist";
							session.setAttribute("checking", checking);
							response.sendRedirect("login.jsp");
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}else if(!pass.equals(rePass)){
					checking = "notMatch";
					session.setAttribute("checking", checking);
					response.sendRedirect("login.jsp");
				}
			}
		}
		
		
	}

}
