package AdminControl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.productDAO;
import entity.Product;

/**
 * Servlet implementation class SelectAndShowServlet
 */
@WebServlet("/SelectAndShow")
public class SelectAndShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		

		String select = request.getParameter("select");
		productDAO dao = new productDAO();
		if("1".equals(select)) {
			List<Product> list = dao.ShowAllProductAdminPage();
			request.setAttribute("listC", list);
			request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
		}else if("2".equals(select)) {
			List<Product> list = dao.ShowAllNewestProductAdminPage();
			request.setAttribute("listC", list);
			request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
		}
	}

}
