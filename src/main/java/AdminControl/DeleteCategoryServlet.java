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

/**
 * Servlet implementation class DeleteCategoryServlet
 */
@WebServlet("/DeleteCategory")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String message = "";
		
		
		String cateID = request.getParameter("CateDel");
		out.print("cate id: "+cateID);
		
		categoryDAO dao = new categoryDAO();
		String result = dao.DeleteCategoryById(cateID);
		if("successfully".equals(result)) {
			message = "successfully";
			session.setAttribute("checkingC", message);
			response.sendRedirect("AdminIndex.jsp");
		}else {
			message = "failed";
			session.setAttribute("checkingC", message);
			response.sendRedirect("AdminIndex.jsp");
		}
	}

}
