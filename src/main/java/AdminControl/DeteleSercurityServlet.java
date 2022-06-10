package AdminControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.sercurityDAO;

/**
 * Servlet implementation class DeteleSercurityServlet
 */
@WebServlet("/DeteleSercurity")
public class DeteleSercurityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String message = "";
		
		String question_id = request.getParameter("sercurityDel");
		sercurityDAO dao = new sercurityDAO();
		String result = dao.DeleteSercurityById(question_id);
		if("successfully".equals(result)) {
			message = "successfully";
			session.setAttribute("checkingQs", message);
			response.sendRedirect("AdminIndex.jsp");
		}else {
			message = "failed";
			session.setAttribute("checkingQs", message);
			response.sendRedirect("AdminIndex.jsp");
		}
	}

}
