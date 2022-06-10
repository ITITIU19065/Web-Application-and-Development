package AdminControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.brandDAO;

/**
 * Servlet implementation class DeleteBrandServlet
 */
@WebServlet(name = "DeleteBrand", urlPatterns = { "/DeleteBrand" })
public class DeleteBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String message = "";
	
		String brandID =  request.getParameter("brandDel");
		out.print("brand id : "+brandID+"<br>");
		
		brandDAO dao = new brandDAO();
		String result = dao.DeleteBrand(brandID);
		if("successfully".equals(result)) {
			message = "successfully";
			session.setAttribute("checkingB", message);
			response.sendRedirect("AdminIndex.jsp");
		}else {
			message = "failed";
			session.setAttribute("checkingB", message);
			response.sendRedirect("AdminIndex.jsp");
		}
	}

}
