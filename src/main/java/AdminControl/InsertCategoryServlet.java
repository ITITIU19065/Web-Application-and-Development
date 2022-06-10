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
import DAO.categoryDAO;

/**
 * Servlet implementation class InsertCategory
 */
@WebServlet("/InsertCategory")
public class InsertCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String message = "";
		
		String cate = (String) request.getParameter("cate");
		if(cate.length() == 0) {
			message = "empty";
			session.setAttribute("checkingCate", message);
			response.sendRedirect("AdminIndex.jsp");
		}else {
			categoryDAO dao = new categoryDAO();
			String result = dao.InsertNewCategory(cate);
			if("successfully".equals(result)) {
				message = "successfully";
				session.setAttribute("checkingCate", message);
				response.sendRedirect("AdminIndex.jsp");
			}else {
				message = "failed";
				session.setAttribute("checkingCate", message);
				response.sendRedirect("AdminIndex.jsp");
			}
		}
	}

}
