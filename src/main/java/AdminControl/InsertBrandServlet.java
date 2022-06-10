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
 * Servlet implementation class InsertBrand
 */
@WebServlet("/InsertBrand")
public class InsertBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String message = "";
		
		String brand = request.getParameter("brand");
		if(brand.length() == 0) {
			message = "empty";
			session.setAttribute("checkingBrand", message);
			response.sendRedirect("AdminIndex.jsp");
		}else {
			brandDAO dao = new brandDAO();
			String result = dao.InsertNewBrand(brand);
			if("successfully".equals(result)) {
				message = "successfully";
				session.setAttribute("checkingBrand", message);
				response.sendRedirect("AdminIndex.jsp");
			}else {
				message = "failed";
				session.setAttribute("checkingBrand", message);
				response.sendRedirect("AdminIndex.jsp");
			}
		}
		
	}

}
