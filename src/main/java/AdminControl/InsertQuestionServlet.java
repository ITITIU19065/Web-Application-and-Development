package AdminControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.categoryDAO;
import DAO.sercurityDAO;

/**
 * Servlet implementation class InsertQuestionServlet
 */
@WebServlet("/InsertQuestion")
public class InsertQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String message = "";
		
		
		String question = (String) request.getParameter("question");
		if(question.length() == 0) {
			message = "empty";
			session.setAttribute("checkingQ", message);
			response.sendRedirect("AdminIndex.jsp");
		}else {
			sercurityDAO dao = new sercurityDAO();
			String result = dao.InsertNewSercurity(question);
			if("successfully".equals(result)) {
				message = "successfully";
				session.setAttribute("checkingQ", message);
				response.sendRedirect("AdminIndex.jsp");
			}else {
				message = "failed";
				session.setAttribute("checkingQ", message);
				response.sendRedirect("AdminIndex.jsp");
			}
		}
	}

}
